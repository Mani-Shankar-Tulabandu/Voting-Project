package com.deloitte.spring.boot.invesco1;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;



@SpringBootApplication
public class App {

	private final static Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("Starting INVESCO app...");

		SpringApplication.run(App.class, args);

		LOG.info("Started INVESCO app...");

	}

}
