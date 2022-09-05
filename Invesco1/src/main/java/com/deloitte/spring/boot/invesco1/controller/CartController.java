package com.deloitte.spring.boot.invesco1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.deloitte.spring.boot.invesco1.model.Cart;
import com.deloitte.spring.boot.invesco1.model.Product;
import com.deloitte.spring.boot.invesco1.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartservice;
	
	@RequestMapping(path = "/get-all-elements-in-cart", method = RequestMethod.GET)
	public ResponseEntity<List<Cart>> getAllElections() {
		System.out.println("get-all-elections");
		List<Cart> cartList = cartservice.viewElements();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Elections displayed successfully!");
		ResponseEntity<List<Cart>> response = new ResponseEntity<>(cartList, headers, status);
		return response;
	}
	
	/*@PostMapping(path = "/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody Product product)  {
		ResponseEntity<String> response = null; 
		String result = cartservice.addToCart(product);
		response = new ResponseEntity<String>(result, HttpStatus.CREATED);
	
		return response;
	}
	*/
	
	@RequestMapping(path = "/add-cart-element-by-product-id/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> addToCart(@PathVariable(name = "id") int product_id) {
		System.out.println("add-elements-by-product-id");
		ResponseEntity<String> response = null; 
		String result = cartservice.addToCarts(product_id);
		response = new ResponseEntity<String>(result, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(path = "/delete-cart-items", method = RequestMethod.DELETE)
	public ResponseEntity<Cart> deleteEmp() {
		Cart em = cartservice.deleteCartItems();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee are deleted sussessfully.");

		ResponseEntity<Cart> response = new ResponseEntity<>(em, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-cart-by-id/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cart> deleteCart(@PathVariable(name = "id") int cart_id) {
		System.out.println("delete-cart-by-id");
		Cart cartuu = cartservice.deleteItemByID(cart_id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Cart with id " + cart_id + " is deleted successfully!");
		ResponseEntity<Cart> response = new ResponseEntity<>(cartuu, headers, status);
		return response;
	}
	 
	@RequestMapping(path = "/total-bill", method = RequestMethod.GET)
	public int getTotalBill() {
		int em = cartservice.getBillOfCartItems();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee are deleted sussessfully.");
		ResponseEntity<Cart> response = new ResponseEntity<>(null, headers, status);
		return em;
	}
	
	

}
