package com.saurabh.playground.sec04;

import com.saurabh.playground.sec03.Section03Runner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Section04Runner {

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
	public static class Consumer1 {
		public static void main(String[] args) {
			SpringApplication.run(Section04Runner.Consumer1.class,
					"--section=sec04",
					"--config=01-sample-consumer");
		}
	}

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
	public static class Consumer2 {
		public static void main(String[] args) {
			SpringApplication.run(Section04Runner.Consumer2.class,
					"--section=sec04",
					"--config=01-sample-consumer");
		}
	}

	@SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
	public static class Producer {
		public static void main(String[] args) {
			SpringApplication.run(Section04Runner.Producer.class,
					"--section=sec04",
					"--config=02-sample-producer");
		}
	}
}
