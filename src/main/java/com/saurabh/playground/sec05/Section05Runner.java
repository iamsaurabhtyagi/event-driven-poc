package com.saurabh.playground.sec05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Section05Runner {

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
	public static class Consumer1 {
		public static void main(String[] args) {
			SpringApplication.run(Section05Runner.Consumer1.class,
					"--section=sec04",
					"--config=03-user-consumer");
		}
	}

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
	public static class Consumer2 {
		public static void main(String[] args) {
			SpringApplication.run(Section05Runner.Consumer2.class,
					"--section=sec04",
					"--config=03-user-consumer");
		}
	}

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
	public static class Producer {
		public static void main(String[] args) {
			SpringApplication.run(Section05Runner.Producer.class,
					"--section=sec04",
					"--config=04-user-producer");
		}
	}
}
