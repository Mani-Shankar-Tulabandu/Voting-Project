package com.deloitte.spring.boot.Projectdemo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "candidates_table")
public class Candidates {

	@Id // PK
@Column(name = "candidate_Id")
	
	private int candidateId;
	
	@Column(name = "constituency_Id")
	private int constituencyId;
	
	@ManyToOne
	@JoinColumn(name = "Regd_Id")
	public Party party;
	
	

	
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}


	@Column(name = "candidate_Name")
	private String candidateName;


	public Candidates() {
		super();
		
	}
	public Candidates(int candidateId, int constituencyId,  String candidateName,Party party) {
		super();
		this.candidateId = candidateId;
		this.constituencyId = constituencyId;
		
		this.candidateName = candidateName;
		this.party=party;
	}
	

	public int getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}


	public int getConstituencyId() {
		return constituencyId;
	}


	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}




	public String getCandidateName() {
		return candidateName;
	}


	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}


	
	
	
}