package com.deloitte.spring.boot.Projectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.Projectdemo.model.Candidates;
import com.deloitte.spring.boot.Projectdemo.model.Constituency;

public interface ConstituencyRepository extends JpaRepository<Constituency, Integer>{

}

