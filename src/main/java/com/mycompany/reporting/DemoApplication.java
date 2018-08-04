package com.mycompany.reporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ComponentScan(basePackages = { "com.mycompany.reporting.config", "com.mycompany.reporting.web.dto",
		"com.mycompany.reporting.web.controller", "com.mycompany.reporting.service" })
@ActiveProfiles({ "dev", "local" })
public class DemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
