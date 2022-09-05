package com.deloitte.spring.boot.invesco1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.invesco1.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
