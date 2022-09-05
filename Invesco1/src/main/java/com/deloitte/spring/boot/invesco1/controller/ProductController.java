package com.deloitte.spring.boot.invesco1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.invesco1.model.Product;
import com.deloitte.spring.boot.invesco1.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(path = "/get-all-products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		System.out.println("get-all-products");
		List<Product> productList = productService.viewProducts();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Products displayed successfully!");
		ResponseEntity<List<Product>> response = new ResponseEntity<>(productList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-product", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateDept(@Valid @RequestBody Product product){
		System.out.println("update-products");
		Product productList = productService.updateProducts(product);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated product successfully!");
		ResponseEntity<Product> response = new ResponseEntity<>(productList, headers, status);
		return response;
	}
	
	
	@RequestMapping(path = "/add-product", method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		System.out.println("add-product");
		Product produc = productService.addProduct(product);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "product with id " + product.getProduct_id() + " is added successfully!");
		ResponseEntity<Product> response = new ResponseEntity<>(produc, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteElection(@PathVariable(name = "id") int product_id) {
		System.out.println("delete-product-by-id");
		Product elect = productService.deleteProduct(product_id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Product with id " + product_id + " is deleted successfully!");
		ResponseEntity<Product> response = new ResponseEntity<>(elect, headers, status);
		return response;
	}
	

}
