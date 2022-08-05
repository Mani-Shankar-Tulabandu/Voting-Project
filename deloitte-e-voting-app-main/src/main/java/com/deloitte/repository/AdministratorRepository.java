package com.deloitte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, String> {

}
