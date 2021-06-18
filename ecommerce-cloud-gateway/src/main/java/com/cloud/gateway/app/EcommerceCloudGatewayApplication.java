package com.cloud.gateway.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class EcommerceCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceCloudGatewayApplication.class, args);
	}

}
