package com.saurabh.playground.sec11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Section11Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(Consumer.class,
                    "--section=sec11",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec11",
                    "--config=02-producer");
        }
    }
}
