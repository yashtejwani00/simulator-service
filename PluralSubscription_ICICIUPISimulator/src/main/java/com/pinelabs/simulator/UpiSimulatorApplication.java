package com.pinelabs.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class UpiSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpiSimulatorApplication.class, args);
	}

}
