package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
public class ZDepartmentServiceApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(ZDepartmentServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
