package com.deloitte.spring.boot.Projectdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.Projectdemo.model.Candidates;
import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Election;
import com.deloitte.spring.boot.Projectdemo.model.Voter;
import com.deloitte.spring.boot.Projectdemo.service.AdministratorService;
import com.deloitte.spring.boot.Projectdemo.service.CandidatesService;
import com.deloitte.spring.boot.Projectdemo.service.VoterService;


@RestController
@RequestMapping("/voter")
public class VoterController {
	
	@Autowired
	VoterService voterService;
	
	
	
	@RequestMapping(path = "/get-all-voters", method = RequestMethod.GET)
	public ResponseEntity<List<Voter>> getAllVoters() {
		System.out.println("get-all-voters");
		List<Voter> voterList = voterService.viewVoter();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all voters displayed successfully!");
		ResponseEntity<List<Voter>> response = new ResponseEntity<>(voterList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/add-voter", method = RequestMethod.POST)
	public ResponseEntity<Voter> addVoter(@Valid @RequestBody Voter voter) {
		System.out.println("add-voter");
		Voter vot = voterService.addVoter(voter);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "voter is added successfully!");
		ResponseEntity<Voter> response = new ResponseEntity<>(vot, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/get-constituency-by-epic/{name}", method = RequestMethod.GET)
	public ResponseEntity<Voter> getDeptById(@PathVariable(name = "name") String epic) {
		System.out.println("get-constituency-by-epic");
	    Voter votee = voterService.getConstituencyByEpic(epic);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "constituency with epic "+epic+"is fetched successfully!");
		ResponseEntity<Voter> response = new ResponseEntity<>(votee, headers, status);
		return response;
	}
	
	
	
	
 


}
