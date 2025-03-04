package com.IZSoftware.Birthday.Notification.controller;

import com.IZSoftware.Birthday.Notification.dto.UserResponse;
import com.IZSoftware.Birthday.Notification.entity.User;
import com.IZSoftware.Birthday.Notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/department/{departmentId}")
    private ResponseEntity<List<UserResponse>> getUsersByDepartment(@PathVariable("departmentId") Long departmentId) {
        return ResponseEntity.ok(userService.getUsersByDepartment(departmentId));
    }
    @GetMapping("/birthday")
    private ResponseEntity<List<UserResponse>> getUsersWithBirthdayToday() {
        return ResponseEntity.ok(userService.getUsersWithBirthdayToday());
    }
    @PutMapping("/{userId}")
    private ResponseEntity<User> updateUserBirthDay(@RequestBody UserResponse userResponse,
                                                    @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.updateUserBirthDay(userResponse,userId));
    }
}
