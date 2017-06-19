package com.xzf.spring.cloud.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurakaServiceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakaServiceTwoApplication.class, args);
	}
}
