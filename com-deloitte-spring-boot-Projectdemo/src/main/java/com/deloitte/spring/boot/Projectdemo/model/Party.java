package com.deloitte.spring.boot.Projectdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Party_table")
public class Party {
@Id // PK
	
	
	@Column(name = "Regd_Id")
	private int regd_Id;

	@Column(name = "party_name")
	
	private String partyName;
	@Column(name = "symbol")
	private String  symbol;
	@Column(name = "leader")
	private String  leader;
	public Party(int regd_Id, String partyName, String symbol, String leader) {
		super();
		this.regd_Id = regd_Id;
		this.partyName = partyName;
		this.symbol = symbol;
		this.leader = leader;
	}
	public int getRegd_Id() {
		return regd_Id;
	}
	public void setRegd_Id(int regd_Id) {
		this.regd_Id = regd_Id;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	@Override
	public String toString() {
		return "party [regd_Id=" + regd_Id + ", partyName=" + partyName + ", symbol=" + symbol + ", leader=" + leader
				+ "]";
	}
	
}
