package com.deloitte.service;

import java.util.List;

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

public interface AdministratorService {

	public Administrator loginAdmin(String adminId, String password) throws IncorrectLoginCredentialsException;

	public boolean addAdmin(Administrator admin) throws InvalidFieldException;
	
	// Election 

	public boolean addElection(Election election)
			throws InvalidFieldException, NoSuchElectionException, AlreadyExistsException;

	public List<Election> findAllElection() throws NoSuchRecordException;

	public Election findElectionById(int electionId) throws NoSuchElectionException;

	

	public boolean editElectionDate(int electionId, String electionDate) throws NoSuchElectionException;

	public boolean removeElection(int electionId) throws NoSuchElectionException;
	
	// Party

	public boolean addParty(Party party) throws InvalidFieldException, NoSuchPartyRecordException;

	public List<Party> readAllParties() throws NoSuchRecordException;

	public Party readByPartyRegId(String regId) throws NoSuchPartyRecordException;

	
	public boolean removePartyById(String regId) throws NoSuchPartyRecordException;
	
	

	// Candidates
	
	public String addCandidate(Candidates candidate);
			

	public List<Candidates> viewCandidate() throws NoSuchRecordException;

	public Candidates readCandidateId(int candidateId) throws NoSuchCandidateRecordException;
	public boolean updateCandidateNameById(int candidateId, String candidateName) throws NoSuchCandidateRecordException;

	public boolean removeCandidateById(int candidateId) throws NoSuchCandidateRecordException;

	public boolean addConstituency(Constituency constituency);
		
	
	// Constituency

	public List<Constituency> viewConstituency() throws NoSuchRecordException;

	public Constituency readConstituencyById(int constituencyId) throws NoSuchConstituencyException;


	public boolean removeConstituency(int constituencyId) throws NoSuchConstituencyException;
	
	// Voter

	public List<Voter> readAllVoter() throws NoSuchRecordException;

	

	public boolean updateStatusOfVoterByepic(String epic) throws NoSuchVoterException;
	
	

	

}
