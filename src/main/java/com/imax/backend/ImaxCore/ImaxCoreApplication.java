package com.imax.backend.ImaxCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImaxCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImaxCoreApplication.class, args);
	}

}
