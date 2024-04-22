package com.botanic.humidity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaRepositories("com.botanic.humidity.repository")
@EntityScan("com.botanic.humidity.model")
public class HumidityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumidityApplication.class, args);
	}

}
