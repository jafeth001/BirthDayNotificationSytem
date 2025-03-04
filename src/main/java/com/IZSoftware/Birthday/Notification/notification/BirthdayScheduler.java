package com.IZSoftware.Birthday.Notification.notification;

import com.IZSoftware.Birthday.Notification.dto.UserResponse;
import com.IZSoftware.Birthday.Notification.entity.User;
import com.IZSoftware.Birthday.Notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BirthdayScheduler {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationProducer notificationProducer;

    @Scheduled(cron = "0 0 9 * * ?") // Runs every day at 9 AM
    public void checkBirthdays() {
        List<UserResponse> usersWithBirthday = userService.getUsersWithBirthdayToday();
        for (UserResponse user : usersWithBirthday) {
            List<UserResponse> departmentMembers = userService.getUsersByDepartment(user.getDepartment().getId());
            String message = "Today is " + user.getName() + "'s birthday!";
            notificationProducer.sendNotification(message);
        }
    }
}
