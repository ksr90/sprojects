package com.sboot.io.sproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sboot")
@SpringBootApplication
public class SprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprojectApplication.class, args);
	}

}
