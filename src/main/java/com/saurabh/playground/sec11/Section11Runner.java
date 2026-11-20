package com.saurabh.playground.sec11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * To test concurrency in Kafka where I will have only one consumer, one producer
 * I have 3 partition in a topic and concurrency is also 3,
 * Because of enabled concurrency we will have 3 tread of consumer and each will associate with one partition
 * Point here is we didn't have to run multiple consumer instead created 3 thread of one consumer and one partition
 * assigned to one consumer thread.
 */
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
