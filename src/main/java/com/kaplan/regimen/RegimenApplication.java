package com.kaplan.regimen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RegimenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegimenApplication.class, args);

	}

}
