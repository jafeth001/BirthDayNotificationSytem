package com.IZSoftware.Birthday.Notification.service;

import com.IZSoftware.Birthday.Notification.entity.Department;
import com.IZSoftware.Birthday.Notification.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
