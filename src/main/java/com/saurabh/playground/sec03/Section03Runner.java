package com.saurabh.playground.sec03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka consumer and producer testing with Key to achieve message/event order
 */
public class Section03Runner {

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.sec03.consumer")
	public static class Consumer {
		public static void main(String[] args) {
			SpringApplication.run(Consumer.class,
					"--section=sec03",
					"--config=03-message-consumer");
		}
	}

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.sec03.producer")
	public static class Producer {
		public static void main(String[] args) {
			SpringApplication.run(Producer.class,
					"--section=sec03",
					"--config=04-message-producer");
		}
	}
}
