package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({ "com.example.demo.repo"})
public class RecepiesServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(RecepiesServiceApplication.class, args);
	}
}
