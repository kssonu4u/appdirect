package com.appdirect.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author saurav starting point of the spring boot application
 *
 */
@EnableMongoRepositories("com.appdirect")
@ComponentScan("com.appdirect")
@SpringBootApplication
public class AppDirectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDirectApplication.class, args);
	}
}
