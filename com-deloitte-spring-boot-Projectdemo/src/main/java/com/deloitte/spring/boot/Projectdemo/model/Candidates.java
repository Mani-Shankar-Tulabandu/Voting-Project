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

@Entity
@Table(name = "candidates_table")
public class Candidates {

	@Id // PK
@Column(name = "candidate_Id")
	
	private int candidateId;
	
	@Column(name = "constituency_Id")
	private int constituencyId;

	
	@Column(name = "party_Reg_Id")
	private int partyRegId;

	
	@Column(name = "candidate_Name")
	private String candidateName;


	public Candidates() {
		super();
		
	}
	public Candidates(int candidateId, int constituencyId, int partyRegId, String candidateName) {
		super();
		this.candidateId = candidateId;
		this.constituencyId = constituencyId;
		this.partyRegId = partyRegId;
		this.candidateName = candidateName;
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


	public int getPartyRegId() {
		return partyRegId;
	}


	public void setPartyRegId(int partyRegId) {
		this.partyRegId = partyRegId;
	}


	public String getCandidateName() {
		return candidateName;
	}


	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}


	
	
	
}