package com.saurabh.playground.sec02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Section02Runner {

	public static void main(String[] args) {
		SpringApplication.run(Section02Runner.class,
				"--section=sec02",
				"--config=01-simple-producer");
	}

}
