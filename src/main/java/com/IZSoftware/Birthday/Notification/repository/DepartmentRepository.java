package com.IZSoftware.Birthday.Notification.repository;

import com.IZSoftware.Birthday.Notification.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByName(String name);
}
