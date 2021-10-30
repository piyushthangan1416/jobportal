package com.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalApplication.class, args);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();		
		System.out.println(passwordEncoder.encode("caio"));//BCryptPasswordEncoder
	}

}
