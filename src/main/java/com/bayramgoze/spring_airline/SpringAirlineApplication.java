package com.bayramgoze.spring_airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.bayramgoze.entites"})
@ComponentScan(basePackages = {"com.bayramgoze"})
@EnableJpaRepositories(basePackages = {"com.bayramgoze.repository"})
public class SpringAirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAirlineApplication.class, args);
	}

}
