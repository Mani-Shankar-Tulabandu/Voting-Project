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

import com.deloitte.spring.boot.invesco1.model.User;
import com.deloitte.spring.boot.invesco1.repository.UserRepository;
import com.deloitte.spring.boot.invesco1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/get-all-users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllElections() {
		System.out.println("get-all-elections");
		List<User> usersList = userService.viewUsers();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all users displayed successfully!");
		ResponseEntity<List<User>> response = new ResponseEntity<>(usersList, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/update-user", method = RequestMethod.PUT)
	public ResponseEntity<User> updateDept(@Valid @RequestBody User user){
		System.out.println("update-users");
		User userList = userService.updateElection(user);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated elections  successfully!");
		ResponseEntity<User> response = new ResponseEntity<>(userList, headers, status);
		return response;
	}
	
	
	@RequestMapping(path = "/add-user", method = RequestMethod.POST)
	public ResponseEntity<User> addElection(@Valid @RequestBody User user) {
		System.out.println("add-user");
		User elect = userService.addUser(user);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "user with id " + user.getUser_id() + " is added successfully!");
		ResponseEntity<User> response = new ResponseEntity<>(elect, headers, status);
		return response;
	}
	
	@RequestMapping(path = "/delete-user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable(name = "id") int user_id) {
		System.out.println("delete-user-by-id");
		User elect = userService.deleteUser(user_id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User with id " + user_id + " is deleted successfully!");
		ResponseEntity<User> response = new ResponseEntity<>(elect, headers, status);
		return response;
	}
	

}
