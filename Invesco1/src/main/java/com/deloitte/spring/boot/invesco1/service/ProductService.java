package com.deloitte.spring.boot.invesco1.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.invesco1.model.Product;
import com.deloitte.spring.boot.invesco1.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product updateProducts(@Valid Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product addProduct(@Valid Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public Product deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(product_id);
		return null;
	}
	
	
}
