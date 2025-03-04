package com.IZSoftware.Birthday.Notification.controller;

import com.IZSoftware.Birthday.Notification.entity.Department;
import com.IZSoftware.Birthday.Notification.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

}
