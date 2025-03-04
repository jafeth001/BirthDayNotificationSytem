package com.IZSoftware.Birthday.Notification.dto;

import com.IZSoftware.Birthday.Notification.entity.Department;

import java.time.LocalDate;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private Department department;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email, LocalDate birthday, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
