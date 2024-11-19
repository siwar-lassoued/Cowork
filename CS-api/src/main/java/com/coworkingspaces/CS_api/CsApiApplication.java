package com.coworkingspaces.CS_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.coworkingspaces.CS_api.user")
@EntityScan(basePackages = "com.coworkingspaces.CS_api.user")
@EnableJpaAuditing
@EnableAsync
public class CsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsApiApplication.class, args);
	}

}