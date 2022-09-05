package com.deloitte.spring.boot.invesco1.repository;
import com.deloitte.spring.boot.invesco1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
