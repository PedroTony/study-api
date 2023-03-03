package com.github.pedrotony.study_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	static Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Olá");
	}

	
	public void run(String... args) throws Exception {
		System.out.println("Among us sussy wussy baka");
		LOG.info("baka");
	}

}
