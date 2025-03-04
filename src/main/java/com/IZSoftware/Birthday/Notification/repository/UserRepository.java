package com.IZSoftware.Birthday.Notification.repository;

import com.IZSoftware.Birthday.Notification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByDepartmentId(Long departmentId);
    List<User> findByBirthday(LocalDate today);

    User findByEmail(String email);
}
