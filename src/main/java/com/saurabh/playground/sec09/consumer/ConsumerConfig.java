package com.saurabh.playground.sec09.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class ConsumerConfig {
    Logger log = LoggerFactory.getLogger(ConsumerConfig.class);

    @Bean
    public Consumer<Message<String>> consumerEvent() {
        return message -> {
            var headers = message.getHeaders();
            var key = headers.get(KafkaHeaders.RECEIVED_KEY);
            var partition = headers.get(KafkaHeaders.RECEIVED_PARTITION);
            var offset = headers.get(KafkaHeaders.OFFSET);
            log.info("------------------------");
            log.info("Key Received: {}", key);
            log.info("Partition Received: {}", partition);
            log.info("Offset Received: {}", offset);
            log.info("Message Received: {}", message);
            log.info("------------------------");
        };
    }
}
