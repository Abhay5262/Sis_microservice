package com.Sis_Eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SisEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisEurekaApplication.class, args);
	}

}
