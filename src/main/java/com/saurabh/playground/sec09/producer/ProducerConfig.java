package com.saurabh.playground.sec09.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
public class ProducerConfig {
    Logger log = LoggerFactory.getLogger(ProducerConfig.class);

    @Bean
    public Supplier<Message<String>> producerEvent() {
        AtomicInteger counter = new AtomicInteger();

        return () -> {
            var msg = messageBuilder("msg-" + counter.incrementAndGet());
            log.info("Produced Message: {}", msg);
            return msg;
        };
    }

    private Message<String> messageBuilder(String msg) {
        return MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.KEY, msg)
                .build();
    }
}
