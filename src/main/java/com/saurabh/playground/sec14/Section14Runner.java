package com.saurabh.playground.sec14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

public class Section14Runner {

    @EnableScheduling
    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(Consumer.class,
                    "--section=sec14",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec14",
                    "--config=02-producer");
        }
    }
}
