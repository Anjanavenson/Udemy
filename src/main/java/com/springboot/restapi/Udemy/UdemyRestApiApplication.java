package com.springboot.restapi.Udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UdemyRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyRestApiApplication.class, args);
	}

}
