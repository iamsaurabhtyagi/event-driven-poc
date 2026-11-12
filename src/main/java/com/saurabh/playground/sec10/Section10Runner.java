package com.saurabh.playground.sec10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * To test batch processing using Kafka where producer will produce messages in batch and
 * consumer will also consume messages in batch, but
 * it doesn't mean consumer will poll exact same size batch which was produced
 */
public class Section10Runner {
    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(Consumer.class,
                    "--section=sec10",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec10",
                    "--config=02-producer");
        }
    }
}
