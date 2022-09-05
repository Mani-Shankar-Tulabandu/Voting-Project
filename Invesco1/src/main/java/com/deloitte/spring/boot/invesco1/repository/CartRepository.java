package com.deloitte.spring.boot.invesco1.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.invesco1.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	
	
	
	@Query(value = "Select e From Cart e Where Lower(e.product_name) = :name")
	public List<Cart> readAllElectionsByName(@Param("name") String product_name);

}
