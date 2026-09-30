package com.peterwhitedev.labs.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.peterwhitedev.labs.personas"})
@EnableJpaRepositories(basePackages = "com.peterwhitedev.labs.personas.repository")
@EntityScan(basePackages = "com.peterwhitedev.labs.personas.entity")
public class PersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonasApplication.class, args);
	}

}