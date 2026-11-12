package com.saurabh.playground.sec07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka testing with Processor who is actually both consumer and producer
 * other producer produce event and Processor receive that event and produce
 * another event of another consumer
 */
public class Section07Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(Consumer.class,
                    "--section=sec07",
                    "--config=01-simple-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.processor")
    public static class Processor {
        public static void main(String[] args) {
            SpringApplication.run(Processor.class,
                    "--section=sec07",
                    "--config=05-notification-processor");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec07",
                    "--config=02-simple-producer");
        }
    }

}
