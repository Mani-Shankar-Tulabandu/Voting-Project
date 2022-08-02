package com.deloitte.spring.boot.Projectdemo.controller;

import java.util.List;

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
import com.deloitte.spring.boot.Projectdemo.model.Party;
import com.deloitte.spring.boot.Projectdemo.service.AdministratorService;




@RestController
@RequestMapping("/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorService adminService;
	
	@RequestMapping(path = "/get-all-elections", method = RequestMethod.GET)
	public ResponseEntity<List<Election>> getAllElections() {
		System.out.println("get-all-elections");
		List<Election> electionList = adminService.viewElection();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Elections displayed successfully!");
		ResponseEntity<List<Election>> response = new ResponseEntity<>(electionList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-elections", method = RequestMethod.PUT)
	public ResponseEntity<Election> updateDept(@Valid @RequestBody Election election){
		System.out.println("update-elections");
		Election electionList = adminService.updateElection(election);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated elections  successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(electionList, headers, status);
		return response;
	}
	
	
	@RequestMapping(path = "/add-election", method = RequestMethod.POST)
	public ResponseEntity<Election> addElection(@Valid @RequestBody Election election) {
		System.out.println("add-election");
		Election elect = adminService.addElection(election);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "election with id " + election.getElectionId() + " is added successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(elect, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-election/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Election> deleteElection(@PathVariable(name = "id") int electionId) {
		System.out.println("delete-election-by-id");
		Election elect = adminService.deleteElection(electionId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Election with id " + electionId + " is deleted successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(elect, headers, status);
		return response;
	}
	
	//-------------------------------------------------------------------
	
	@RequestMapping(path = "/get-all-parties", method = RequestMethod.GET)
	public ResponseEntity<List<Party>> getAllParties() {
		System.out.println("get-all-parties");
		List<Party> partiesList = adminService.viewParties();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Parties displayed successfully!");
		ResponseEntity<List<Party>> response = new ResponseEntity<>(partiesList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-parties", method = RequestMethod.PUT)
	public ResponseEntity<Party> updateParties(@Valid @RequestBody Party party){
		System.out.println("update-parties");
		Party partiesList = adminService.updateParty(party);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated parties successfully!");
		ResponseEntity<Party> response = new ResponseEntity<>(partiesList, headers, status);
		return response;
	}
	
	
	@RequestMapping(path = "/add-parties", method = RequestMethod.POST)
	public ResponseEntity<Party> addParty(@Valid @RequestBody Party party) {
		System.out.println("add-party");
		Party part = adminService.addParty(party);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "election with id " + party.getRegd_Id() + " is added successfully!");
		ResponseEntity<Party> response = new ResponseEntity<>(part, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-party/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Party> deleteParty(@PathVariable(name = "id") int regd_Id) {
		System.out.println("delete-party-by-id");
		Party part = adminService.deleteParty(regd_Id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Party with id " + regd_Id + " is deleted successfully!");
		ResponseEntity<Party> response = new ResponseEntity<>(part, headers, status);
		return response;
	}

	
	//-------------------------------------------------------------------------
	
	@RequestMapping(path = "/get-all-Constituencies", method = RequestMethod.GET)
	public ResponseEntity<List<Constituency>> getAllConstituencies() {
		System.out.println("get-all-Constituencies");
		List<Constituency> constituencyList = adminService.viewConstituency();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Constituencies displayed successfully!");
		ResponseEntity<List<Constituency>> response = new ResponseEntity<>(constituencyList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-constituency", method = RequestMethod.PUT)
	public ResponseEntity<Constituency> updateConstituency(@Valid @RequestBody Constituency constituency){
		System.out.println("update-constituency");
		Constituency constituencyList = adminService.updateConstituency(constituency);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated Constituencies successfully!");
		ResponseEntity<Constituency> response = new ResponseEntity<>(constituencyList, headers, status);
		return response;
	}
	
	
	@RequestMapping(path = "/add-constituency", method = RequestMethod.POST)
	public ResponseEntity<Constituency> addConstituency(@Valid @RequestBody Constituency constituency) {
		System.out.println("add-constituency");
		Constituency consta = adminService.addConstituency(constituency);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "constituency with id " + consta.getConstituencyId() + " is added successfully!");
		ResponseEntity<Constituency> response = new ResponseEntity<>(consta, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-constituency/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Constituency> deleteConstituency(@PathVariable(name = "id") int constituencyId) {
		System.out.println("delete-party-by-constituencyId");
		Constituency consta = adminService.deleteConstituency(constituencyId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Constituency with id " + constituencyId + " is deleted successfully!");
		ResponseEntity<Constituency> response = new ResponseEntity<>(consta, headers, status);
		return response;
	}
	
	//------------------------------------------------------------------------
	
	@RequestMapping(path = "/get-all-candidates", method = RequestMethod.GET)
	public ResponseEntity<List<Candidates>> getAllCandidates() {
		System.out.println("get-all-Candidates");
		List<Candidates> candidatesList = adminService.viewCandidates();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Candidates displayed successfully!");
		ResponseEntity<List<Candidates>> response = new ResponseEntity<>(candidatesList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-candidates", method = RequestMethod.PUT)
	public ResponseEntity<Candidates> updateCandidates(@Valid @RequestBody Candidates candidates){
		System.out.println("update-Candidates");
		Candidates candidatesList = adminService.updateCandidate(candidates);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated Constituencies successfully!");
		ResponseEntity<Candidates> response = new ResponseEntity<>(candidatesList, headers, status);
		return response;
	}
	
	
	@RequestMapping(path = "/add-candidates", method = RequestMethod.POST)
	public ResponseEntity<Candidates> addCandidates(@Valid @RequestBody Candidates candidates) {
		System.out.println("add-Candidates");
		Candidates candid = adminService.addCandidate(candidates);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Candidate with id " + candid.getCandidateId() + " is added successfully!");
		ResponseEntity<Candidates> response = new ResponseEntity<>(candid, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-candidates/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Candidates> deleteCandidates(@PathVariable(name = "id") int candidatesId) {
		System.out.println("delete-party-by-constituencyId");
		Candidates candid = adminService.deleteCandidates(candidatesId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Constituency with id " + candidatesId+ " is deleted successfully!");
		ResponseEntity<Candidates> response = new ResponseEntity<>(candid, headers, status);
		return response;
	}

	

}
