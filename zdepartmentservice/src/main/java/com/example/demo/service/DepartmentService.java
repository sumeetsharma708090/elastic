package com.example.demo.service;

import com.example.demo.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	Department getDepartmentById(Long departmentId);
}
