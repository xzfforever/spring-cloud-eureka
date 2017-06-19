package com.xzf.spring.cloud.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceOneApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate () {
		return new RestTemplate();
	}
}