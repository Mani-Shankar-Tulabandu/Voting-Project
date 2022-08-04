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
@Table(name = "constituency_table")
public class Constituency {

	@Id // PK
	
	@Column(name = "constituency_id")
	private int constituencyId;

	@Column(name = "state")
	@NotNull(message = "state can not be null.")
	
	private String state;
	@Column(name = "election_id")
	private String  electionId;
	
	


	@Column(name = "district")
	private String district;
	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}
	@Column(name = "constituency_name")
	private String constituencyName;
	public int getConstituencyId() {
		return constituencyId;
	}


	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getElectionId() {
		return electionId;
	}


	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}


	public String getConstituencyName() {
		return constituencyName;
	}





	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}


	public Constituency() {
		super();
		
	}


	public Constituency(int constituencyId, @NotNull(message = "state can not be null.") String state,
			String electionId, String constituencyName,String district,Candidates candidate) {
		super();
		this.district=district;
		this.constituencyId = constituencyId;
		this.state = state;
		this.electionId = electionId;
		this.constituencyName = constituencyName;
		
		
	}


	@Override
	public String toString() {
		return "Constituency [constituencyId=" + constituencyId + ", state=" + state + ", electionId=" + electionId
				+ ", district=" + district + ", constituencyName=" + constituencyName + "]";
	}
	

}