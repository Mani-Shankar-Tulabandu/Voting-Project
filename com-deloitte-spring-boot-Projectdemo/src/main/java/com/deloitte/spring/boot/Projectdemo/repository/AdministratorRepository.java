package com.deloitte.spring.boot.Projectdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.Projectdemo.model.Election;


public interface AdministratorRepository extends JpaRepository<Election, Integer>{
	
}
