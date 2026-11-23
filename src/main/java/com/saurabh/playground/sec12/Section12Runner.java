package com.saurabh.playground.sec12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * To test manual acknowledgement/offset commit for simple messaging and batch messaging
 */
public class Section12Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(Consumer.class,
                    "--section=sec12",
                    "--config=01-consumer");
        }
    }
}
