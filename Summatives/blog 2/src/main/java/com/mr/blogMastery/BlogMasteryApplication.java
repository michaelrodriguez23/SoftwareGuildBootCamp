package com.mr.blogMastery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogMasteryApplication {

	public static void main(String[] args) {
             System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(BlogMasteryApplication.class, args);
	}

}
