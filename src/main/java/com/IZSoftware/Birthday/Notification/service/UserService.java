package com.IZSoftware.Birthday.Notification.service;

import com.IZSoftware.Birthday.Notification.dto.UserResponse;
import com.IZSoftware.Birthday.Notification.entity.Department;
import com.IZSoftware.Birthday.Notification.entity.User;
import com.IZSoftware.Birthday.Notification.mapper.UserToUserResponse;
import com.IZSoftware.Birthday.Notification.repository.DepartmentRepository;
import com.IZSoftware.Birthday.Notification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserToUserResponse::mapToUserResponse)
                .collect(Collectors.toList());
    }

    public List<UserResponse> getUsersByDepartment(Long departmentId) {
        return userRepository.findByDepartmentId(departmentId).stream()
                .map(UserToUserResponse::mapToUserResponse)
                .collect(Collectors.toList());
    }

    public List<UserResponse> getUsersWithBirthdayToday() {
        return userRepository.findByBirthday(LocalDate.now()).stream()
                .map(UserToUserResponse::mapToUserResponse)
                .collect(Collectors.toList());
    }

    public User updateUserBirthDay(UserResponse userResponse, Long userId) {
        var user = userRepository.findById(userId).orElseThrow();
        user.setBirthday(userResponse.getBirthday());
        return userRepository.save(user);
    }
}