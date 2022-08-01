package com.deloitte.spring.boot.Projectdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "vote_table")
	public class Vote {
		@Id // PK
		
		
		@Column(name = "vote_Id")
		private String voteId;

		@Column(name = "candidate_Id")
		
		private String candidateId;
		@Column(name = "epic")
		private String  epic;


	
}
