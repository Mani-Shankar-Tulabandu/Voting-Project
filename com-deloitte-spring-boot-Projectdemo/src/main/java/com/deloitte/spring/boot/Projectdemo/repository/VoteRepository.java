package com.deloitte.spring.boot.Projectdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{
	

	@Query(value = "Select v From Vote v Where v.epic = :epic")
	public Vote existEpicInVote(@Param("epic") String epic);

	@Query(value = "Select v.candidateId, Count(v) From Vote v Group By v.candidateId")
	public List<Object[]> cadidateVoteCount(); 
 


}
