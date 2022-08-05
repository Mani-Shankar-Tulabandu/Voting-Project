package com.deloitte.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.exception.IncorrectLoginCredentialsException;
import com.deloitte.exception.InvalidAadhaarException;
import com.deloitte.exception.InvalidFieldException;
import com.deloitte.exception.NoSuchRecordException;
import com.deloitte.exception.NoSuchVoterException;
import com.deloitte.model.ElectoralOfficer;
import com.deloitte.model.Voter;
import com.deloitte.repository.ElectoralOfficerRepository;
import com.deloitte.repository.PincodeRepository;
import com.deloitte.repository.VoterRepository;

import logging.GlobalResources;

@Service("eoService")
public class ElectoralOfficerServiceImpl implements ElectoralOfficerService {
	
	private Logger Logger = GlobalResources.getLogger(AdministratorServiceImpl.class);
	
	@Autowired
	private ElectoralOfficerRepository eoRepository;

	@Autowired
	private VoterRepository voterRepository;

	@Autowired
	private PincodeRepository pincodeRepository;

	@Transactional
	@Override
	public boolean acceptVoterRequestById(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException {
		String regex = "^[0-9]{12}";
		String aadhaarStr = String.valueOf(aadhaar);
		System.out.print(aadhaar);
		if ((aadhaarStr.matches(regex))) {
			if (voterRepository.existsById(aadhaar)) {
				Voter voter = voterRepository.findById(aadhaar).get();
				
				voter.setStatus("ACCEPT");
				voterRepository.updatestatus("Accept",voter.getAadhaarId());
				Logger.info("acceptVoterRequestById");
				return true;
			}
			Logger.error("Voter not found");
			throw new NoSuchVoterException("Voter not found");
		}
		Logger.error("Please enter valid aadhaar number");
		throw new InvalidAadhaarException("Please enter valid aadhaar number");
	}

	

	@Override
	public Voter viewRequestById(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException {
		String regex = "^[0-9]{12}";
		String aadhaarStr = String.valueOf(aadhaar);
		if ((aadhaarStr.matches(regex))) {
			if (voterRepository.existsById(aadhaar)) {
				Voter voter = voterRepository.findById(aadhaar).get();
				Logger.info("viewRequestById");
				return voter;
			}
			Logger.error("Voter with Id not found");
			throw new NoSuchVoterException("Voter with Id is not found");
		}
		Logger.error("Voter not found");
		throw new InvalidAadhaarException("Please enter valid aadhaar number");
	}

	@Override
	public List<Voter> viewAllVoters() throws NoSuchRecordException {
		List<Voter> result = voterRepository.findAll();
		if (!result.isEmpty()) {
			Logger.info("viewAllVoters");
			return result;
		}
		Logger.error("No voter list is found");
		throw new NoSuchRecordException("No voter list is found.");
	}



	
	@Override
	public boolean rejectVoterRequestById(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException {
		String regex = "^[0-9]{12}";
		String aadhaarStr = String.valueOf(aadhaar);
		if ((aadhaarStr.matches(regex))) {
			if (voterRepository.existsById(aadhaar)) {
				voterRepository.handleRequestbyId("rejected", aadhaar);
				Logger.info("rejectVoterRequestById");
				return true;
			}
			Logger.error("Voter not found");
			throw new NoSuchVoterException("Voter not found");
		}
		Logger.error("Please enter valid aadhaar number");
		throw new InvalidAadhaarException("Please enter valid aadhaar number");
	}


	

}
