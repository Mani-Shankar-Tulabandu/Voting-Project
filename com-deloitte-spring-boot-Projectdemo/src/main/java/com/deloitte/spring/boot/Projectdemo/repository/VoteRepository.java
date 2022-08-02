package com.deloitte.spring.boot.Projectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.Projectdemo.model.Constituency;
import com.deloitte.spring.boot.Projectdemo.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{

}
