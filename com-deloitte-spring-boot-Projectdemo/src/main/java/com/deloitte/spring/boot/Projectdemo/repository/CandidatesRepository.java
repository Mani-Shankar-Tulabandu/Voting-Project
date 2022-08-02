package com.deloitte.spring.boot.Projectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.Projectdemo.model.Candidates;

public interface CandidatesRepository extends JpaRepository<Candidates, Integer>{

}
