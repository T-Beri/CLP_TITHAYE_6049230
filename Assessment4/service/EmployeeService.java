package com.example.assessment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment4.entity.Employee;
import com.example.assessment4.repository.EmpRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmpRepository repo;

    public List<Employee> getAll() {
    	
        return repo.findAll();
    }

    public Employee getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Employee save(Employee e) {
        return repo.save(e);
    }
}