package com.deloitte.service;

import java.util.List;

import com.deloitte.exception.IncorrectLoginCredentialsException;
import com.deloitte.exception.InvalidAadhaarException;
import com.deloitte.exception.InvalidFieldException;
import com.deloitte.exception.NoSuchRecordException;
import com.deloitte.exception.NoSuchVoterException;
import com.deloitte.model.ElectoralOfficer;
import com.deloitte.model.Voter;

public interface ElectoralOfficerService {

	

	public Voter viewRequestById(long aadhaar) throws NoSuchRecordException;


	public boolean rejectVoterRequestById(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException;

	public boolean acceptVoterRequestById(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException;
	public List<Voter> viewAllVoters() throws NoSuchRecordException;
}
