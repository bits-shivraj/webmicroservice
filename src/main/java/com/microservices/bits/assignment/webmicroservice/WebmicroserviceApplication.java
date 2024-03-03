package com.microservices.bits.assignment.webmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WebmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmicroserviceApplication.class, args);
	}

}
