package com.deloitte.spring.boot.Projectdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ElectoralOfficer_table")
public class ElectoralOfficer {
	@Id // PK
	
	
	@Column(name = "ElectoralOfficer_Id")
	private int electoralOfficerId;

	@Column(name = "ElectoralOfficer_Name")
	
	private String electoralOfficerName;
	@Column(name = "ElectoralOfficer_Password")
	private String  electoralOfficerPassword;
	public ElectoralOfficer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElectoralOfficer(int electoralOfficerId, String electoralOfficerName, String electoralOfficerPassword) {
		super();
		this.electoralOfficerId = electoralOfficerId;
		this.electoralOfficerName = electoralOfficerName;
		this.electoralOfficerPassword = electoralOfficerPassword;
	}
	@Override
	public String toString() {
		return "ElectoralOfficer [electoralOfficerId=" + electoralOfficerId + ", electoralOfficerName="
				+ electoralOfficerName + ", electoralOfficerPassword=" + electoralOfficerPassword + "]";
	}
	
}
