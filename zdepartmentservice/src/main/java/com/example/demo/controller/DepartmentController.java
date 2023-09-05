package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

//	@GetMapping("{id}")
//	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
//		Department department = departmentService.getDepartmentById(departmentId);
//		return ResponseEntity.ok(department);
//	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseDto> getDepartment(@PathVariable("id") Long departmentId) {
		ResponseDto department = departmentServiceImpl.getDepartment(departmentId);
		return ResponseEntity.ok(department);
	}
	
}
