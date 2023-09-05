package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.LogisticsDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Department;
import com.example.demo.repo.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	private RestTemplate restTemplate;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
    
    public ResponseDto getDepartment(Long userId) {

		ResponseDto responseDto = new ResponseDto();
		Department department = departmentRepository.findById(userId).get();
		DepartmentDto departmentDto = mapToDepartment(department);

		ResponseEntity<LogisticsDto> responseEntity = restTemplate
				.getForEntity("http://localhost:7070/api/logistics/" + department.getLogisticsId(), LogisticsDto.class);
													
		LogisticsDto logisticsDto = responseEntity.getBody();

		System.out.println(responseEntity.getStatusCode());

		responseDto.setDepartment(departmentDto);
		responseDto.setLogistics(logisticsDto);

		return responseDto;
	}
    
	private DepartmentDto mapToDepartment(Department department) {
		DepartmentDto userDto = new DepartmentDto();
		userDto.setId(department.getId());
		userDto.setDepartmentAddress(department.getDepartmentAddress());
		userDto.setDepartmentName(department.getDepartmentName());
		return userDto;
	}
}
