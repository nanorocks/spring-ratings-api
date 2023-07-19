package com.api.ratingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class RatingappApplication {
	public static void main(String[] args) {
		SpringApplication.run(RatingappApplication.class, args);
	}

}
