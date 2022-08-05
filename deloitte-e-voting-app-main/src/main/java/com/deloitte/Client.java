package com.deloitte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Client {

	private static final Logger LOG = LoggerFactory.getLogger(Client.class);

	public static void main(String[] args) {

		LOG.info("App starting...");

		SpringApplication.run(Client.class, args);

		LOG.info("App started.");
	}

}
