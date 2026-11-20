package com.saurabh.playground.sec12.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

@Configuration
public class ConsumerConfig {
    Logger log = LoggerFactory.getLogger(ConsumerConfig.class);

    @Bean
    public Consumer<Message<String>> messageConsumer() {
        return this::handleMessage;
    }

    private void handleMessage(Message<String> message) {
        log.info("message: {}", message);

        var acknowledgement = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if(Objects.isNull(acknowledgement))
            throw new IllegalStateException("Acknowledgment is required with ack mode MANUAL");

        switch (message.getPayload()) {
            case "4", "5", "6" -> simulateNoAcknowledgement(acknowledgement);
            case "7" -> simulateTemporaryFailure();
            default -> acknowledgement.acknowledge();
        }
        
    }

    private void simulateTemporaryFailure() {
        log.info("message processed but not acknowledged");
    }

    private void simulateNoAcknowledgement(Acknowledgment acknowledgment) {
        var random = ThreadLocalRandom.current().nextInt(1, 11);
        log.info("random value: {}", random);
        if(random > 8) {
            log.info("processing succeeded");
            acknowledgment.acknowledge();
        } else {
            log.info("temporary failure, retry after 5 seconds");
            acknowledgment.nack(Duration.ofSeconds(5));
        }
    }
}
