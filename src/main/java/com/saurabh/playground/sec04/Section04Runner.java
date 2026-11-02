package com.saurabh.playground.sec04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Section04Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    static class Consumer1 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer1.class,
                    "--section=sec04",
                    "--config=01-simple-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec04",
                    "--config=02-simple-producer");
        }
    }
}
