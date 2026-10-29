package com.saurabh.playground.sec04.producer;

import com.saurabh.playground.sec04.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
public class ProducerConfig {
    Logger log = LoggerFactory.getLogger(ProducerConfig.class);

    @Bean
    public Supplier<String> producerEvent() {
        var counter = new AtomicInteger(0);

        return () -> {
            var msg = "msg-" + counter.incrementAndGet();
            log.info("Produced Event: {}", msg);
            return msg;
        };
    }

    @Bean
    public Supplier<Message<User>> userMessageSupplierEvent() {
        return () -> {
            var userMessage = userMessageBuilder(UUID.randomUUID().toString());
            log.info("Produced User Event: {}", userMessage);
            return userMessage;
        };
    }

    private Message<User> userMessageBuilder(String id) {
        var user = new User();
        user.setId(id);
        user.setName("Saurabh");
        user.setSalary((int) Math.random());
        return MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.KEY, id)
                .setHeader(KafkaHeaders.TIMESTAMP, Instant.now().toEpochMilli())
                .build();
    }
}
