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

		public Vote() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Vote [voteId=" + voteId + ", candidateId=" + candidateId + ", epic=" + epic + "]";
		}
		public Vote(String voteId, String candidateId, String epic) {
			super();
			this.voteId = voteId;
			this.candidateId = candidateId;
			this.epic = epic;
		}
		public String getVoteId() {
			return voteId;
		}
		public void setVoteId(String voteId) {
			this.voteId = voteId;
		}
		public String getCandidateId() {
			return candidateId;
		}
		public void setCandidateId(String candidateId) {
			this.candidateId = candidateId;
		}
		public String getEpic() {
			return epic;
		}
		public void setEpic(String epic) {
			this.epic = epic;
		}
		@Column(name = "candidate_Id")
		
		private String candidateId;
		@Column(name = "epic")
		private String  epic;


	
}
