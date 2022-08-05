package com.deloitte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.model.Constituency;

@Repository
public interface ConstituencyRepository extends JpaRepository<Constituency, Integer> {

	@Transactional
	@Modifying
	@Query(value = "Update Constituency c Set c.constituencyName = :constituencyName Where c.constituencyId = :id")
	public void updateConstituencyNameById(@Param("constituencyName") String constituencyName,
			@Param("id") int constituencyId);

	@Query(value = "Select c From Constituency c Where Lower(c.constituencyName) = :name")
	public Constituency readConstituencyByName(@Param("name") String constituencyName);
}
