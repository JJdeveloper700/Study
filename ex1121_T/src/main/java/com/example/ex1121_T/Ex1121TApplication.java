package com.example.ex1121_T;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex1121TApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex1121TApplication.class, args);
	}

}
