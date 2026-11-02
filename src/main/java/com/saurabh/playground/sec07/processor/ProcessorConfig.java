package com.saurabh.playground.sec07.processor;

import com.saurabh.playground.sec07.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Configuration
public class ProcessorConfig {
    Logger log = LoggerFactory.getLogger(ProcessorConfig.class);

    @Bean
    public Function<Order, Payment> paymentProcessor() {
        return order -> {
            log.info("Order Received: {}", order);
            return new Payment(order.id(), order.amount(), UUID.randomUUID());
        };
    }

    @Bean
    public Function<Order, Shipment> shipmentProcessor() {
        return order -> {
            if(ProductType.PHYSICAL.equals(order.productType())) {
                return new Shipment(order.id(), "FEDEX-" + order.id());
            }
            return null;
        };
    }

    /**
     *
     * @return NOTE: It is List<Message<Notification>> not List<Notification> and not Message<List<Notification>>
     */
    @Bean
    public Function<Order, List<Message<Notification>>> notificationProcessor() {
        return order -> List.of(
                MessageBuilder.withPayload(createSMSNotification(order)).build(),
                MessageBuilder.withPayload(createEmailNotification(order)).build()
        );
    }

    private Notification createEmailNotification(Order order) {
        return new Notification(order.id(), NotificationChannel.EMAIL,"user.%d@gmail.com".formatted(order.customerId()));
    }

    private Notification createSMSNotification(Order order) {
        return new Notification(order.id(), NotificationChannel.SMS, String.valueOf(9_000_000_000L + order.customerId()));
    }
}
