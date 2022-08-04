package com.deloitte.spring.boot.Projectdemo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.Projectdemo.model.Voter;
import com.deloitte.spring.boot.Projectdemo.repository.VoteRepository;
import com.deloitte.spring.boot.Projectdemo.repository.VoterRepository;

import io.swagger.v3.oas.annotations.servers.Server;
@Service
public class ElectoralOfficerService {
	@Autowired
	private VoterRepository voterRepository;
	
	public List<Voter> viewVoters(){
		return voterRepository.findAll();
	}

	public Voter viewVoters(@Valid Voter voter) {
		// TODO Auto-generated method stub
		return voterRepository.save(voter);
	}
	

}
