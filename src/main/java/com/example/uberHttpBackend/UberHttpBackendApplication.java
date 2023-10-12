package com.example.uberHttpBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration

@SpringBootApplication(scanBasePackages = {"com.example.uberHttpBackend"})
public class UberHttpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberHttpBackendApplication.class, args);
	}

}
