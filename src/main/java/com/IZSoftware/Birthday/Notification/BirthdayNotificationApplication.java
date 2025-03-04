package com.IZSoftware.Birthday.Notification;

import com.IZSoftware.Birthday.Notification.entity.Department;
import com.IZSoftware.Birthday.Notification.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class BirthdayNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdayNotificationApplication.class, args);
	}

	@Bean
	CommandLineRunner initDepartments(DepartmentRepository departmentRepository) {
		return args -> {
			List<String> departmentNames = List.of(
					"Engineering", "Marketing", "Human Resources", "Finance", "Customer Support"
			);

			for (String name : departmentNames) {
				if (!departmentRepository.existsByName(name)) {
					Department department = new Department();
					department.setName(name);
					departmentRepository.save(department);
				}
			}
		};
	}


}
