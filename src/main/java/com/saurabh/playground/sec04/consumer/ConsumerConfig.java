package com.saurabh.playground.sec04.consumer;

import com.saurabh.playground.sec04.dto.User;
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

    @Bean
    public Consumer<Message<User>> userMessageConsumer() {
        return userMessage -> {
            var user = userMessage.getPayload();
            var header = userMessage.getHeaders();
            var key = header.get(KafkaHeaders.RECEIVED_KEY);
            var partition = header.get(KafkaHeaders.RECEIVED_PARTITION);
            var offset = header.get(KafkaHeaders.OFFSET);

            log.info("User: '\\n\\t User ID: {} \\n\\t User Name: {}", user.getId(), user.getName());
            log.info("Partition: {} | Offset: {} | Key: {}", partition, offset, key);
        };
    }
}
