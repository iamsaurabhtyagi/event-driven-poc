package com.saurabh.playground.sec08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Section08Runner {

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class DigitalDeliveryConsumer {
        public static void main(String[] args) {
            SpringApplication.run(DigitalDeliveryConsumer.class,
                    "--section=sec08",
                    "--config=01-digital-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.consumer")
    public static class PhysicalDeliveryConsumer {
        public static void main(String[] args) {
            SpringApplication.run(PhysicalDeliveryConsumer.class,
                    "--section=sec08",
                    "--config=02-physical-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.processor")
    public static class Processor {
        public static void main(String[] args) {
            SpringApplication.run(Processor.class,
                    "--section=sec08",
                    "--config=03-processor");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.saurabh.playground.${section}.producer")
    public static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(Producer.class,
                    "--section=sec08",
                    "--config=04-producer");
        }
    }
}
