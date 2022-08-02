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
@Table(name = "Voter_table")
public class Voter {
	//private String voterName,gender,district,voterPassword,status,dob,address,epic,mobile;
	@Id // PK
	
	
	@Column(name = "epic")
	private String epic;

	@Column(name = "voter_name")
	
	private String voterName;
	@Column(name = "gender")
	private String  gender;

	@Column(name="constituency_id")
	private int constituencyId;

	public int getConstituencyId() {
		return constituencyId;
	}
	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}
	@Column(name = "district")
	private String district;
	@Column(name = "voter_password")
	private String voterPassword;
	@Column(name = "status")
	private String status;
	@Column(name = "dob")
	private String dob;
	@Column(name = "address")
	private String address;
	@Column(name = "mobile")
	private String mobile;
	
	public Voter() {
		super();
	}
	public Voter(String epic, String voterName, String gender, String district, String voterPassword, String status,
			String dob, String address, String mobile,int constituencyId) {
		super();
		this.epic = epic;
		this.voterName = voterName;
		this.gender = gender;
		this.district = district;
		this.voterPassword = voterPassword;
		this.status = status;
		this.dob = dob;
		this.address = address;
		this.mobile = mobile;
		this.constituencyId=constituencyId;
	}
	public String getEpic() {
		return epic;
	}
	public void setEpic(String epic) {
		this.epic = epic;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getVoterPassword() {
		return voterPassword;
	}
	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
