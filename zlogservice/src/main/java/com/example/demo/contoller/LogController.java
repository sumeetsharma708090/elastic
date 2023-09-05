package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Logistics;
import com.example.demo.repo.LogRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/logistics")
@AllArgsConstructor
@Slf4j
public class LogController {

	@Autowired
	private LogRepo repo;

    @PostMapping
    public ResponseEntity<Logistics> saveLog(@RequestBody Logistics logistics){
        Logistics savedLogistics = repo.save(logistics);
        return new ResponseEntity<>(savedLogistics, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Logistics> getLogisticsById(@PathVariable("id") Long logId){
        Logistics logistics = repo.findById(logId).get();
        return ResponseEntity.ok(logistics);
    }
}
