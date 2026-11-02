package com.saurabh.playground.sec06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Section06Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer1 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer1.class,
                    "--section=sec06",
                    "--config=01-simple-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer2 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer2.class,
                    "--section=sec06",
                    "--config=01-simple-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer3 {
        public static void main(String[] args) {
            SpringApplication.run(Consumer3.class,
                    "--section=sec06",
                    "--config=01-simple-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec06",
                    "--config=02-simple-producer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer2 {
        public static void main(String[] args) {
            SpringApplication.run(Producer2.class,
                    "--section=sec06",
                    "--config=03-simple-producer2");
        }
    }
}
