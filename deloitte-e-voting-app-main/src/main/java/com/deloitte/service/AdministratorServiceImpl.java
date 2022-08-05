package com.deloitte.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.exception.AlreadyExistsException;
import com.deloitte.exception.IncorrectLoginCredentialsException;
import com.deloitte.exception.InvalidFieldException;
import com.deloitte.exception.NoSuchCandidateRecordException;
import com.deloitte.exception.NoSuchConstituencyException;
import com.deloitte.exception.NoSuchElectionException;
import com.deloitte.exception.NoSuchPartyRecordException;
import com.deloitte.exception.NoSuchRecordException;
import com.deloitte.exception.NoSuchVoterException;
import com.deloitte.model.Administrator;
import com.deloitte.model.Candidates;
import com.deloitte.model.Constituency;
import com.deloitte.model.Election;
import com.deloitte.model.Party;
import com.deloitte.model.Pincode;
import com.deloitte.model.Voter;
import com.deloitte.repository.AdministratorRepository;
import com.deloitte.repository.CandidatesRepository;
import com.deloitte.repository.ConstituencyRepository;
import com.deloitte.repository.ElectionRepository;
import com.deloitte.repository.PartyRepository;
import com.deloitte.repository.PincodeRepository;
import com.deloitte.repository.VoterRepository;

@Service("adminService")
public class AdministratorServiceImpl implements AdministratorService {

	private final Logger Logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AdministratorRepository adminRepository;
	@Autowired
	private ElectionRepository electionRepository;
	@Autowired
	private CandidatesRepository candidatesRepository;
	@Autowired
	private ConstituencyRepository constituencyRepository;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private VoterRepository voterRepository;
	@Autowired
	private PincodeRepository pincodeRepository;

	// Administrator Functionalities

	@Override
	@Transactional
	public boolean addAdmin(Administrator admin) throws InvalidFieldException {
		if (admin.getAdminId() != null && admin.getAdminName() != null && admin.getAdminPassword() != null) {
			boolean result = false;
			String name = admin.getAdminName();
			String regex = "^[A-Za-z ]+";
			if (name.matches(regex)) {
				admin = adminRepository.save(admin);
				result = true;
				if (!admin.getAdminId().isEmpty()) {
					Logger.info("Admin is added successfully");
					return result;
				}
			}
			Logger.error("incorrect details");
			throw new InvalidFieldException("Not able to add admin record");
		}
		throw new InvalidFieldException("Fields are empty");
	}

	@Override
	public Administrator loginAdmin(String adminId, String password) throws IncorrectLoginCredentialsException {
		Administrator admin = null;

		if (adminRepository.existsById(adminId)
				&& adminRepository.findById(adminId).get().getAdminPassword().equals(password)) {
			admin = adminRepository.findById(adminId).get();
			Logger.info("Admin login is  successfull");
			return admin;
		}
		Logger.error("Admin details are incorrect");
		throw new IncorrectLoginCredentialsException("Invalid Credentials");
	}

	// Election Functionalities

	@Override
	@Transactional
	public boolean addElection(Election election)
			throws InvalidFieldException, NoSuchElectionException, AlreadyExistsException {
		boolean result = false;

		if (election.getElectionDate() != null && election.getElectionName() != null
				&& election.getElectionType() != null) {

			if (electionRepository.findElectionsByName(election.getElectionName().toLowerCase()) == null) {

				election = electionRepository.save(election);
				result = true;
				if (election.getElectionId() != 0) {
					Logger.info("Election is added");
					return result;
				}
				Logger.error("Not able to add Election record");
				throw new NoSuchElectionException("Not able to add Election record");
			}
			Logger.error("Election Name Already Exists");
			throw new AlreadyExistsException("Election Name Already Exists");
		}
		Logger.error("Field is Empty");
		throw new InvalidFieldException("Field is Empty");
	}

	@Override
	public Election findElectionById(int electionId) throws NoSuchElectionException {
		if (electionRepository.existsById(electionId)) {
			Logger.info("findElectionById");
			return electionRepository.findById(electionId).get();
		}
		Logger.error("Given Election id is not found");
		throw new NoSuchElectionException("Given Election id is not found");
	}

	
	@Override
	public List<Election> findAllElection() throws NoSuchRecordException {
		List<Election> list = electionRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("findAllElection");
			return list;
		}
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

	

	@Override
	@Transactional
	public boolean editElectionDate(int electionId, String electionDate) throws NoSuchElectionException {
		if (electionRepository.existsById(electionId)) {
			electionRepository.editElectionDate(electionId, electionDate);
			Logger.info("editElectionDate");
			return true;
		}
		Logger.error("Given id does not exist to update electionDate");
		throw new NoSuchElectionException("Given id does not exist to update electionDate");
	}

	@Override
	@Transactional
	public boolean removeElection(int electionId) throws NoSuchElectionException {
		if (electionRepository.existsById(electionId)) {
			electionRepository.deleteById(electionId);
			Logger.info("removeElection");
			return true;
		}
		Logger.error("Given id does not exist to remove Election");
		throw new NoSuchElectionException("Given id does not exist to remove Election");
	}

	// Party Functionalities

	@Override
	@Transactional
	public boolean addParty(Party party) throws InvalidFieldException, NoSuchPartyRecordException {
		if (party.getRegId() != null && party.getPartyName() != null && party.getLeader() != null
				&& party.getSymbol() != null) {
			if (partyRepository.readPartyByName(party.getPartyName().toLowerCase()) == null) {
				party = partyRepository.save(party);
				if (!party.getRegId().isEmpty()) {
					Logger.info("addParty");
					return true;
				}
				Logger.error("Not able to add Party");
				throw new NoSuchPartyRecordException("Not able to add Party");
			}
			Logger.error("Party Already Exists");
			throw new AlreadyExistsException("Party Already Exists");
		}
		Logger.error("Field is Empty");
		throw new InvalidFieldException("Field is Empty");
	}

	@Override
	public List<Party> readAllParties() throws NoSuchRecordException {
		List<Party> list = partyRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("readAllParties");
			return list;
		}
		Logger.error("No Parties present");
		throw new NoSuchRecordException("No Parties present");
	}

	@Override
	public Party readByPartyRegId(String regId) throws NoSuchPartyRecordException {
		if (partyRepository.existsById(regId)) {
			Logger.info("readByPartyRegId");
			return partyRepository.findById(regId).get();
		}
		Logger.error("Party whith this id is not found");
		throw new NoSuchPartyRecordException("Party whith this id is not found");
	}

	

	@Override
	public boolean removePartyById(String regId) throws NoSuchPartyRecordException {
		if (partyRepository.existsById(regId)) {
			partyRepository.deleteById(regId);
			Logger.info("removePartyById");
			return true;
		}
		Logger.error("Party whith id is not found to delete");
		throw new NoSuchPartyRecordException("Party whith this id is not found to delete");
	}



	// Candidate Functionalities

	@Override
	@Transactional
	public String addCandidate(Candidates candidate) {
			
					candidatesRepository.save(candidate);
					String result = "Candidate Created";
					Logger.info("addCandidate");
					return result;
				
				
	}

	@Override
	public List<Candidates> viewCandidate() throws NoSuchRecordException {
		List<Candidates> list = candidatesRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("viewCandidate");
			return list;
		}
		Logger.error("No Candidates found");
		throw new NoSuchRecordException("No Candidates found");
	}

	@Override
	public Candidates readCandidateId(int candidateId) throws NoSuchCandidateRecordException {
		Candidates result = null;
		if (candidatesRepository.existsById(candidateId)) {
			result = candidatesRepository.findById(candidateId).get();
			Logger.info("readCandidateId");
			return result;
		}
		Logger.error("Candidate with this id not found");
		throw new NoSuchCandidateRecordException("Candidate with this id not found");
	}

	

	@Override
	@Transactional
	public boolean updateCandidateNameById(int candidateId, String candidateName)
			throws NoSuchCandidateRecordException {
		if (candidatesRepository.existsById(candidateId)) {
			candidatesRepository.updateCandidateNameById(candidateName, candidateId);
			Logger.info("updateCandidateNameById");
			return true;
		}
		Logger.error("Given id does not exist to update CandidateName");
		throw new NoSuchCandidateRecordException("Given id does not exist to update CandidateName");
	}

	@Override
	public boolean removeCandidateById(int candidateId) throws NoSuchCandidateRecordException {
		if (candidatesRepository.existsById(candidateId)) {
			candidatesRepository.deleteById(candidateId);
			Logger.info("removeCandidateById");
			return true;
		}
		Logger.error("Candidate with this id not found to delete");
		throw new NoSuchCandidateRecordException("Candidate with this id not found to delete");
	}

	// Constituency Functionalities

	@Override
	@Transactional
	public boolean addConstituency(Constituency constituency) {
			
					constituency = constituencyRepository.save(constituency);
					if (constituency.getConstituencyId() != 0) {
						Logger.info("addConstituency");
						return true;
					}
					Logger.error("Not able to add constituency");
					return false;
					
	}

	@Override
	public List<Constituency> viewConstituency() throws NoSuchRecordException {
		List<Constituency> list = constituencyRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("viewConstituency");
			return list;
		}
		Logger.error("No Such Constituency exist");
		throw new NoSuchRecordException("No Such Constituency exist");
	}

	@Override
	public Constituency readConstituencyById(int constituencyId) throws NoSuchConstituencyException {
		if (constituencyRepository.existsById(constituencyId)) {
			Logger.info("readConstituencyById");
			return constituencyRepository.findById(constituencyId).get();
		}
		Logger.error("No Such id found");
		throw new NoSuchConstituencyException("No Such id found");
	}

	

	@Override
	public boolean removeConstituency(int constituencyId) throws NoSuchConstituencyException {
		if (constituencyRepository.existsById(constituencyId)) {
			constituencyRepository.deleteById(constituencyId);
			Logger.info("removeConstituency");
			return true;
		}
		Logger.error("No Such id exist");
		throw new NoSuchConstituencyException("No Such id exist");
	}

	// Voter Functionalities

	@Override
	public List<Voter> readAllVoter() throws NoSuchRecordException {
		List<Voter> result = voterRepository.findAll();
		if (!result.isEmpty()) {
			Logger.info("readAllVoter");
			return result;
		}
		Logger.error("No voter list is found.");
		throw new NoSuchRecordException("No voter list is found.");
	}

	
	@Override
	public boolean updateStatusOfVoterByepic(String epic) throws NoSuchVoterException {
		Voter result = new Voter();
		result = voterRepository.findVoterByEpic(epic);
		if (result != null) {
			voterRepository.handleRequestbyepic("approved", epic);
			Logger.info("updateStatusOfVoterByepic");
			return true;
		}
		Logger.error("voter does not exists for updation");
		throw new NoSuchVoterException("voter does not exists for updation");
	}

	


}
