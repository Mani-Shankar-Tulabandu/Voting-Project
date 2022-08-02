package com.deloitte.spring.boot.Projectdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Voter;
import com.deloitte.spring.boot.Projectdemo.repository.ConstituencyRepository;
import com.deloitte.spring.boot.Projectdemo.repository.VoterRepository;


@Service
public class VoterService {
  @Autowired
  private VoterRepository voterRepository;

  @Autowired
  private ConstituencyRepository constituencyRepository;
	
	public Voter addVoter(Voter vote) {
		return voterRepository.save(vote);
	}
	public List<Voter> viewVoter(){
		return voterRepository.findAll();
	}
	
	public Constituency getConstituencyByEpic(String epic)
	{
		Voter vot = voterRepository.findByepic(epic);
		int constituencyID = vot.getConstituencyId();
		Optional<Constituency> contOptional = constituencyRepository.findById(constituencyID);
		return contOptional.get();
	}
	
  
} 
 
