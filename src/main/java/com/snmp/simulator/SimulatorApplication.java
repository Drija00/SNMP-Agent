package com.snmp.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimulatorApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SimulatorApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
		//SpringApplication.run(SimulatorApplication.class, args);
	}

}
