package com.example.assessment4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment4.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}