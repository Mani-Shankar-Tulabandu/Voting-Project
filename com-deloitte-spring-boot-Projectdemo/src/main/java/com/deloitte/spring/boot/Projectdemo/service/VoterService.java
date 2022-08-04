package com.deloitte.spring.boot.Projectdemo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.Projectdemo.exception.InvalidGenderException;
import com.deloitte.spring.boot.Projectdemo.exception.InvalidMobileNumberException;
import com.deloitte.spring.boot.Projectdemo.exception.UnderAgeException;
import com.deloitte.spring.boot.Projectdemo.model.Candidates;
import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Party;
import com.deloitte.spring.boot.Projectdemo.model.Vote;
import com.deloitte.spring.boot.Projectdemo.model.Voter;
import com.deloitte.spring.boot.Projectdemo.repository.CandidatesRepository;
import com.deloitte.spring.boot.Projectdemo.repository.ConstituencyRepository;
import com.deloitte.spring.boot.Projectdemo.repository.ElectionRepository;
import com.deloitte.spring.boot.Projectdemo.repository.PartyRepository;
import com.deloitte.spring.boot.Projectdemo.repository.VoteRepository;
import com.deloitte.spring.boot.Projectdemo.repository.VoterRepository;


@Service
public class VoterService {
  @Autowired
  private VoterRepository voterRepository;
  
  @Autowired
  private CandidatesRepository candidateRepository;
  
  @Autowired
  private PartyRepository partyRepository;
  
  @Autowired
  private VoteRepository voteRepository;
	
	
		public Voter addVoter(Voter vote) throws  UnderAgeException,  InvalidGenderException {
			
			boolean result = false;
			String regexName = "^[A-Za-z]+";
			String regexMobile = "^[0-9]{10}";
			String regexMail = "^[a-zA-Z.0-9_]+@[a-zA-Z]+.[a-zA-Z]+$";

			String mobileNo = vote.getMobile();
			String Name = vote.getVoterName();
			String dob = vote.getDob();
			int strLength = dob.length(); 
			String year = dob.substring(strLength - 4, strLength);
			int birthYear = Integer.parseInt(year);
			int electionYear = LocalDate.now().getYear();
			vote.setEpic("N/A");
			vote.setStatus("requesting");
			vote.setGender(vote.getGender().toLowerCase());
			if (mobileNo.matches(regexMobile) && mobileNo != null) {
				if (vote.getGender().equals("male") || vote.getGender().equals("female")
						|| vote.getGender().equals("others")) {
					if ((vote.getDob().length() == 10) && (electionYear - birthYear) > 18) {
						return  voterRepository.save(vote);
					
						
					}
					throw new UnderAgeException("Age is insufficient to vote.");
					
				} 
				throw new InvalidGenderException("Invalid Gender");
				
				
			}
			throw new InvalidMobileNumberException("Enter valid mobile number");
			
		}
		 
	 

	 

	 

	
	public List<Voter> viewVoter(){
		return voterRepository.findAll();
	}
	
	public Voter getConstituencyByEpic(String epic)
	{
		Voter vot = voterRepository.findByepic(epic);
		
		return vot;
	}
	



public String viewVoteForAllCandidate()  {
String result = "";
List<Object[]> list = voteRepository.cadidateVoteCount();
if (!list.isEmpty()) {
	for (Object[] obj : list) {
		int candidateId = Integer.parseInt(obj[0].toString());
		String candidateName = candidateRepository.findById(candidateId).get().getCandidateName()+ ", " + partyRepository
				.findById(candidateRepository.findById(candidateId).get().party.getRegd_Id()).get()
				.getPartyName();
		String votes = obj[1].toString();
		result = result + "\n" + candidateName + " has received " + votes + " vote(s)"+ ".";
	}
	
	
}
return result;
} 


	public List<Candidates> viewCandidates() {
		// TODO Auto-generated method stub
		return candidateRepository.findAll();
	}
	public List<Party> viewParties() {
		// TODO Auto-generated method stub
		return partyRepository.findAll();
	}
	public List<Candidates> getCandidatesbyConstituencyID(int constituencyId) {
		
		// TODO Auto-generated method stub
		
		List<Candidates> candie = candidateRepository.findAll();
		List<Candidates> cfinal = null;
		for(Candidates c:candie)
		{
			if(c.getConstituencyId() == constituencyId)
			{
				cfinal.add(c);			}
		}
		
		return cfinal;
	}
	
	
	public String castVote(String epic, String candidateId,String voteId) {


		Vote vote = new Vote();
		vote.setEpic(epic);
		vote.setCandidateId(candidateId);
		vote.setVoteId(voteId);
	
		voteRepository.save(vote);
	    String 	result = "Thanks for Voting "+ candidateRepository.findById(Integer.parseInt(candidateId)).get().getCandidateName();
		return result;

	} 
	
  
} 
 
