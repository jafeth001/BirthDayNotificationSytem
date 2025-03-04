package com.IZSoftware.Birthday.Notification.mapper;

import com.IZSoftware.Birthday.Notification.dto.UserResponse;
import com.IZSoftware.Birthday.Notification.entity.User;

public class UserToUserResponse {
    public static UserResponse mapToUserResponse(User user) {
        var userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setBirthday(user.getBirthday());
        userResponse.setDepartment(user.getDepartment());
        return userResponse;
    }

}
