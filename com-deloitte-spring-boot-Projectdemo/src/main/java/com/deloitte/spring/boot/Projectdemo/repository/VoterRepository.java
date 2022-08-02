package com.deloitte.spring.boot.Projectdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Voter;


public interface VoterRepository extends JpaRepository<Voter, Integer>{
	public abstract Voter findByepic(String epic);

}
