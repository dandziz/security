package com.duydan.mysecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class MySecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecurityApplication.class, args);
	}

}
