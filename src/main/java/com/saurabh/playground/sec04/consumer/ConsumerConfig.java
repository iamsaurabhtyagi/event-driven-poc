package com.saurabh.playground.sec04.consumer;

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
    public Consumer<String> consumerEvent() {
        return msg -> log.info("Received Event: {}", msg);
    }

    @Bean
    public Consumer<Message<String>> consumerMessage() {
        return message -> {
            var header = message.getHeaders();
            var partition = header.get(KafkaHeaders.RECEIVED_PARTITION);
            var offset = header.get(KafkaHeaders.OFFSET);

            log.info("Event: {} | Partition: {} | Offset: {}",
                    message.getPayload(), partition, offset);

        };
    }
}
