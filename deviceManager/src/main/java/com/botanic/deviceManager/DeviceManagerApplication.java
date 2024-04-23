package com.botanic.deviceManager;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableJpaRepositories("com.botanic.deviceManager.repository")
@EntityScan("com.botanic.deviceManager.model")
public class DeviceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManagerApplication.class, args);
	}

}
