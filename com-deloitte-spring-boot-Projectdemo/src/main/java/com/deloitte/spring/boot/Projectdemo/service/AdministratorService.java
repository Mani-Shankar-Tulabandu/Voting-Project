
package com.deloitte.spring.boot.Projectdemo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.Projectdemo.model.Candidates;
import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Election;
import com.deloitte.spring.boot.Projectdemo.model.Party;
import com.deloitte.spring.boot.Projectdemo.model.Vote;
import com.deloitte.spring.boot.Projectdemo.repository.AdministratorRepository;
import com.deloitte.spring.boot.Projectdemo.repository.CandidatesRepository;
import com.deloitte.spring.boot.Projectdemo.repository.ConstituencyRepository;
import com.deloitte.spring.boot.Projectdemo.repository.ElectionRepository;
import com.deloitte.spring.boot.Projectdemo.repository.PartyRepository;
import com.deloitte.spring.boot.Projectdemo.repository.VoteRepository;

@Service
public class AdministratorService {
	@Autowired
	private ElectionRepository electionRepository;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private ConstituencyRepository constituencyRepository;
	@Autowired
	private CandidatesRepository candidatesRepository;
	@Autowired
	private VoteRepository voteRepository;
	
	public Election addElection(Election election) {
		return electionRepository.save(election);
	}
	public Election updateElection(Election election) {
		return electionRepository.save(election);
	}
   
	public List<Election> viewElection() {
		return electionRepository.findAll();
	}
	public Election deleteElection(int electionId) {
		electionRepository.deleteById(electionId);
		return null;
	}
	public Party addParty(Party party) {
		return partyRepository.save(party);
	}
	public Party updateParty(Party party) {
		return partyRepository.save(party);
	}
   
	public List<Party> viewParty() {
		return partyRepository.findAll();
	}
	public Party deleteParty(int regdId) {
		partyRepository.deleteById(regdId);
		return null;
		
	}
	public Constituency addConstituency(Constituency constituency) {
		return constituencyRepository.save(constituency);
	}
	public Constituency updateConstituency(Constituency constituency) {
		return constituencyRepository.save(constituency);
	}
   
	public List<Constituency> viewConstituency() {
		return constituencyRepository.findAll();
	}
	public Constituency deleteConstituency(int constituencyId) {
		constituencyRepository.deleteById(constituencyId);
		return null;
	}
	
	
	public Candidates addCandidate(Candidates candidate) {
		return candidatesRepository.save(candidate);
	}
	public Candidates updateCandidate(Candidates candidate) {
		return candidatesRepository.save(candidate);
	}
   
	public List<Candidates> viewCandidates() {
		return candidatesRepository.findAll();
	}
	public Candidates deleteCandidates (int candidateId) {
		candidatesRepository.deleteById(candidateId);
		return null;
	}
	public List<Vote> viewVotes() {
		// TODO Auto-generated method stub
		return voteRepository.findAll();
	}
	
	

} 
 
