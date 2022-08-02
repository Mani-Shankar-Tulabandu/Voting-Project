
package com.deloitte.spring.boot.Projectdemo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.Projectdemo.model.Candidates;
import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Election;
import com.deloitte.spring.boot.Projectdemo.model.Party;
import com.deloitte.spring.boot.Projectdemo.repository.AdministratorRepository;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorRepository adminRepository;
	public Election addElection(Election election) {
		return adminRepository.save(election);
	}
	public Election updateElection(Election election) {
		return adminRepository.save(election);
	}
   
	public List<Election> viewElection() {
		return adminRepository.findAll();
	}
	public Election deleteElection(int electionId) {
		adminRepository.deleteById(electionId);
		return null;
	}
	public Election addParty(Party party) {
		return adminRepository.save(party);
	}
	public Election updateParty(Party party) {
		return adminRepository.save(party);
	}
   
	public List<Party> viewParty() {
		return adminRepository.findAll();
	}
	public Election deleteParty(int regdId) {
		adminRepository.deleteById(regdId);
		return null;
	}
	public Constituency addConstituency(Constituency constituency) {
		return adminRepository.save(constituency);
	}
	public Constituency updateConstituency(Constituency constituency) {
		return adminRepository.save(constituency);
	}
   
	public List<Constituency> viewConstituency() {
		return adminRepository.findAll();
	}
	public Constituency deleteConstituency(int constituencyId) {
		adminRepository.deleteById(constituencyId);
		return null;
	}
	
	
	public Candidates addCandidate(Candidates candidate) {
		return adminRepository.save(candidate);
	}
	public Candidates updateCandidate(Candidates candidate) {
		return adminRepository.save(candidate);
	}
   
	public List<Candidates> viewCandidates() {
		return adminRepository.findAll();
	}
	public Candidates deleteCandidates (int candidateId) {
		adminRepository.deleteById(candidateId);
		return null;
	}
	
	

} 
 
