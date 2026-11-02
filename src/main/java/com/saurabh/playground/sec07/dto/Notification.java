package com.saurabh.playground.sec07.dto;

public record Notification(int orderId,
                           NotificationChannel channel,
                           String recipient) {
}
