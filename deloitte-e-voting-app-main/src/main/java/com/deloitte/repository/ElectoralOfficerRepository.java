package com.deloitte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.model.ElectoralOfficer;

public interface ElectoralOfficerRepository extends JpaRepository<ElectoralOfficer, String> {

}
