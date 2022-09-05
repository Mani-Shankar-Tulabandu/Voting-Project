package com.deloitte.spring.boot.invesco1.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.invesco1.model.User;
import com.deloitte.spring.boot.invesco1.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

	public User updateElection(@Valid User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public User addUser(@Valid User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public User deleteUser(int user_id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(user_id);
		return null;
	}

}
