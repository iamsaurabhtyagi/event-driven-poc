package com.saurabh.playground.sec09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Section09Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer1 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer1.class,
                    "--section=sec09",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer2 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer2.class,
                    "--section=sec09",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer3 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer3.class,
                    "--section=sec09",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec09",
                    "--config=02-producer");
        }
    }
}