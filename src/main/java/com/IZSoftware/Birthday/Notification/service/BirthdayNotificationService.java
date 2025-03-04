package com.IZSoftware.Birthday.Notification.service;

import com.IZSoftware.Birthday.Notification.entity.User;
import com.IZSoftware.Birthday.Notification.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BirthdayNotificationService {
    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;

    public BirthdayNotificationService(UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Runs every midnight
    public void checkAndSendBirthdayNotifications() {
        LocalDate today = LocalDate.now();
        List<User> usersWithBirthday = userRepository.findByBirthday(today);

        for (User user : usersWithBirthday) {
            String message = "Happy Birthday " + user.getName() + " from " + user.getDepartment().getName() + " department!";
            rabbitTemplate.convertAndSend("birthday.exchange", "birthday.routingKey." + user.getDepartment().getName(), message);
        }
    }
}

