package com.deloitte.spring.boot.Projectdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.Projectdemo.model.Candidates;
import com.deloitte.spring.boot.Projectdemo.model.Constituency;
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
	private ElectionRepository electionRepository;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private ConstituencyRepository constituencyRepository;
	@Autowired
	private CandidatesRepository candidatesRepository;
	@Autowired
	private VoteRepository voteRepository;
  
  
	
	public Voter addVoter(Voter vote) {
		return voterRepository.save(vote);
	}
	public List<Voter> viewVoter(){
		return voterRepository.findAll();
	}
	
	public Voter getConstituencyByEpic(String epic)
	{
		Voter vot = voterRepository.findByepic(epic);
		
		return vot;
	}
	
	
	
	
  
} 
 
