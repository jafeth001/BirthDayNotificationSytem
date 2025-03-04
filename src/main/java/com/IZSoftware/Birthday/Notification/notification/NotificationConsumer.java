package com.IZSoftware.Birthday.Notification.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveNotification(String message) {
        System.out.println("Received notification: " + message);
    }
}
