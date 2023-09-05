package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Logistics;

public interface LogRepo extends JpaRepository<Logistics, Long>{

}
