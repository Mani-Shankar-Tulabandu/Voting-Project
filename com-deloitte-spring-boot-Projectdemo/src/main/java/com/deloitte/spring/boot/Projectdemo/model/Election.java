package com.deloitte.spring.boot.Projectdemo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "election_table")
public class Election {
	
	@Id
	@Column(name = "election_id")
	//@GenericGenerator(name = "election_seq", strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "election_seq")
	private int electionId;

	@Column(name = "election_name")
	private String electionName;

	@Column(name = "election_type")
	private String election_type;
	@Column(name = "election_date")
	private String electiondate;
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Election(int electionId, String electionName, String election_type, String electiondate) {
		super();
		this.electionId = electionId;
		this.electionName = electionName;
		this.election_type = election_type;
		this.electiondate = electiondate;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
	public String getElection_type() {
		return election_type;
	}
	public void setElection_type(String election_type) {
		this.election_type = election_type;
	}
	public String getElectiondate() {
		return electiondate;
	}
	public void setElectiondate(String electiondate) {
		this.electiondate = electiondate;
	}
	@Override
	public String toString() {
		return "election [electionId=" + electionId + ", electionName=" + electionName + ", election_type="
				+ election_type + ", electiondate=" + electiondate + "]";
	}
	
	
}