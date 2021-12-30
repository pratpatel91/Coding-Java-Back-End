package com.codedecode.microservices.VaccinationCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VaccinationCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}
	
	//Rest Template is used to connect Vaccination Center Service to Citizen Service
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
