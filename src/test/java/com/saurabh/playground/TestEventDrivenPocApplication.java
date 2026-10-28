package com.saurabh.playground;

import org.springframework.boot.SpringApplication;

public class TestEventDrivenPocApplication {

	public static void main(String[] args) {
		SpringApplication.from(EventDrivenPocApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
