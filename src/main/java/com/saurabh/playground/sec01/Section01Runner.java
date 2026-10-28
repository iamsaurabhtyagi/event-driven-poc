package com.saurabh.playground.sec01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Section01Runner {

	public static void main(String[] args) {
		SpringApplication.run(Section01Runner.class,
				"--section=sec01",
				"--config=03-consumer-group");
	}

}
