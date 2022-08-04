package com.deloitte.spring.boot.Projectdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.Projectdemo.model.Voter;
import com.deloitte.spring.boot.Projectdemo.service.ElectoralOfficerService;
@RestController
@RequestMapping("/electoral")
public class ElectoralOfficerController {
	
	@Autowired
	private ElectoralOfficerService electoralOfficerService;
	
	

	@RequestMapping(path = "/get-all-voters", method = RequestMethod.GET)
	public ResponseEntity<List<Voter>> getAllVoters() {
		System.out.println("get-all-voters");
		List<Voter> voterList = electoralOfficerService.viewVoters();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all voters displayed successfully!");
		ResponseEntity<List<Voter>> response = new ResponseEntity<>(voterList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-voter", method = RequestMethod.POST)
	public ResponseEntity<Voter> addVoter(@Valid @RequestBody Voter voter) {
		System.out.println("update-voter");
		Voter vot = electoralOfficerService.viewVoters(voter);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "voter is added successfully!");
		ResponseEntity<Voter> response = new ResponseEntity<>(vot, headers, status);
		return response;
	}
}
