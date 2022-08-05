package com.deloitte.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.exception.AlreadyExistsException;
import com.deloitte.exception.AlreadyVotedException;
import com.deloitte.exception.IncorrectLoginCredentialsException;
import com.deloitte.exception.InvalidAadhaarException;
import com.deloitte.exception.InvalidEmailException;
import com.deloitte.exception.InvalidGenderException;
import com.deloitte.exception.InvalidMobileNumberException;
import com.deloitte.exception.InvalidNameException;
import com.deloitte.exception.InvalidPincodeException;
import com.deloitte.exception.NoSuchCandidateRecordException;
import com.deloitte.exception.NoSuchConstituencyException;
import com.deloitte.exception.NoSuchRecordException;
import com.deloitte.exception.NoSuchVoterException;
import com.deloitte.exception.NotScheduledException;
import com.deloitte.exception.UnauthorisedVoterException;
import com.deloitte.exception.UnderAgeException;
import com.deloitte.model.Candidates;
import com.deloitte.model.Election;
import com.deloitte.model.Party;
import com.deloitte.model.Pincode;
import com.deloitte.model.Vote;
import com.deloitte.model.Voter;
import com.deloitte.repository.CandidatesRepository;
import com.deloitte.repository.ConstituencyRepository;
import com.deloitte.repository.ElectionRepository;
import com.deloitte.repository.PartyRepository;
import com.deloitte.repository.PincodeRepository;
import com.deloitte.repository.VoteRepository;
import com.deloitte.repository.VoterRepository;

import logging.GlobalResources;

@Service("voterService")
public class VoterServiceImpl implements VoterService {

	private Logger Logger = GlobalResources.getLogger(AdministratorServiceImpl.class);

	@Autowired
	private VoterRepository voterRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private CandidatesRepository candidatesRepository;

	@Autowired
	private ConstituencyRepository constituencyRepository;

	@Autowired
	private PincodeRepository pincodeRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@Transactional
	public boolean addVoter(Voter voter)
			throws InvalidEmailException, UnderAgeException, InvalidNameException, InvalidPincodeException,
			InvalidMobileNumberException, InvalidAadhaarException, AlreadyExistsException, InvalidGenderException {
		boolean result = false;
		String regexName = "^[A-Za-z]+";
		String regexMobile = "^[0-9]{10}";
		String regexMail = "^[a-zA-Z.0-9_]+@[a-zA-Z]+.[a-zA-Z]+$";

		long aadhaarno = voter.getAadhaarId();
		long mobileNo = voter.getMobile();
		String fName = voter.getVoterFirstName();
		String mName = voter.getVoterMiddleName();
		String lName = voter.getVoterLastName();
		String email = voter.getVoterEmail();
		String dob = voter.getDob();
		
		voter.setGender(voter.getGender().toLowerCase());

		int strLength = dob.length();
		String year = dob.substring(strLength - 4, strLength);
		int birthYear = Integer.parseInt(year);
		int electionYear = 2022;
		String mobile = String.valueOf(mobileNo);
		String aadhaar = String.valueOf(aadhaarno);

		if (aadhaar.matches("^[0-9]{12}")) {
			if (voterRepository.existsById(voter.getAadhaarId()) == false) {
				if (mobile.matches(regexMobile) && voterRepository.findVoterByMobile(mobileNo) == null) {
					if (voter.getPincode()>0) {
						if ((fName.matches(regexName)) && (mName.matches(regexName) || mName.isEmpty())
								&& (lName.matches(regexName))) {
							if (  (electionYear - birthYear) > 18) {
								if (voter.getGender().equals("male") || voter.getGender().equals("female")
										|| voter.getGender().equals("others")) {
									if (email.matches(regexMail) && voterRepository.findVoterByEmail(email) == null) {
										voter = voterRepository.save(voter);
										result = true;
										Logger.info("Voter is added successfully");
										return result;
									}
									Logger.error("Invalid Email");
									throw new InvalidEmailException("Invalid Email");
								}
								Logger.error("Invalid Gender");
								throw new InvalidGenderException("Invalid Gender");
							}
							Logger.error("Under-age user");
							throw new UnderAgeException("Age is insufficient to vote.");
						}
						Logger.error("User name is invalid");
						throw new InvalidNameException("User name is invalid");
					}
					Logger.error("Invalid Pincode");
					throw new InvalidPincodeException("Invalid Pincode");
				}
				Logger.error("Enter valid mobile number");
				throw new InvalidMobileNumberException("Enter valid mobile number");
			}
			Logger.error("Aadhaar already exists");
			throw new AlreadyExistsException("Aadhaar already exists");
		}
		Logger.error("Invalid aadhaar number");
		throw new InvalidAadhaarException("Invalid aadhaar number");
	}

	

	
	@Override
	public Voter viewVoter(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException {
		String aadhaarStr = String.valueOf(aadhaar);
		String regex = "^[0-9]{12}";
		if (aadhaarStr.matches(regex)) {
			if (voterRepository.existsById(aadhaar)) {
				Logger.info("viewVoter");
				return voterRepository.findById(aadhaar).get();
			}
			Logger.error("Unregistered aadhaar number");
			throw new NoSuchVoterException("Voter with aadhaar number" + aadhaar + "is not registered.");
		}
		Logger.error("Invalid aadhaar number");
		throw new InvalidAadhaarException("Please enter a valid aadhaar number");
	}


	@Override
	public String voteCasting(String epic, int candidateId)
	{

								Vote vote = new Vote();
								vote.setEpic(epic);
								vote.setCandidate(candidateId);
								voteRepository.save(vote);
								String result = "Thanks for Voting "
										+ candidatesRepository.findById(candidateId).get().getCandidateName();
										

							
								Logger.info("castVote");
								return result;
							
					
					
			
	}

	@Override
	public List<Candidates> viewCandidatesByConstituency(long aadhaar)
			throws NoSuchRecordException, InvalidAadhaarException {
		if (voterRepository.existsById(aadhaar)) {
			List<Candidates> result = null;
			int voterConstituency = voterRepository.findById(aadhaar).get().getConstituencyId();
			result = candidatesRepository.findCandidatesByConstituency(voterConstituency);
			if (!result.isEmpty()) {
				Logger.info("viewCandidatesByConstituency");
				return result;
			}
			Logger.error("No candidates present in voter's constituency");
			throw new NoSuchRecordException("No record present");
		}
		Logger.error("Invalid aadhaar or Voter not registered");
		throw new InvalidAadhaarException("Invalid aadhaar or Voter not registered");
	}
	@Override
	public List<Party> viewParty() throws NoSuchRecordException {
		List<Party> result = null;
		result = partyRepository.findAll();
		if (!result.isEmpty()) {
			Logger.info("viewParty");
			return result;
		}
		Logger.error("No Party is found.");
		throw new NoSuchRecordException("No Party is found.");
	}

	@Override
	public List<Candidates> viewCandidates() throws NoSuchRecordException {
		List<Candidates> result = null;
		result = candidatesRepository.findAll();
		if (!result.isEmpty()) {
			Logger.info("viewCandidates");
			return result;
		}
		Logger.error("No Candidates are found.");
		throw new NoSuchRecordException("No Candidates are found.");
	}

	// View Results

	

	@Override
	public String viewVoteForAllParty() {
		String result = "";
		List<Object[]> list = voteRepository.partyVoteCount();
		
			for (Object[] obj : list) {
				String partyId = obj[0].toString();
				String partyName = partyRepository.findById(partyId).get().getPartyName();
				String votes = obj[1].toString();
				result = result + "\n" + partyName + " has received " + votes + " vote(s)"+ ".";
			}
			Logger.info("viewVoteForAllParty");
			return result;
		
	}



	
	

}
