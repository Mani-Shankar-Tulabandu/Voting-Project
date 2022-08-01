package com.deloitte.spring.boot.Projectdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Administrator_table")
public class Administrator {
@Id // PK
	
	
	@Column(name = "Admin_Id")
	private int admin_Id;

	@Column(name = "Admin_name")
	
	private String adminName;
	@Column(name = "Admin_Password")
	private String  adminPassword;
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(int admin_Id, String adminName, String adminPassword) {
		super();
		this.admin_Id = admin_Id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public int getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "administrator [admin_Id=" + admin_Id + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ "]";
	}
	
}
