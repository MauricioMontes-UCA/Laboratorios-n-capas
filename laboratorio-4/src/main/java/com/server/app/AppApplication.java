package com.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		System.out.println(">>> DB URL: " + System.getenv("SPRING_DATASOURCE_URL"));
		System.out.println(">>> DB USER: " + System.getenv("SPRING_DATASOURCE_USERNAME"));
		SpringApplication.run(AppApplication.class, args);
	}
}
