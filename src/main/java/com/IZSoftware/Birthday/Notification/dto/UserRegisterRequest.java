package com.IZSoftware.Birthday.Notification.dto;

import java.time.LocalDate;

public class UserRegisterRequest {
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String name, String email, String password, LocalDate birthday, Long departmentId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
