package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // CREATE (DTO → Service handles mapping)
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    // READ ALL
    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // DELETE
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.delete(id);
        return "employee deleted successfully";
    }

    // UPDATE (still Entity version for now)
    @PutMapping("/employee/{id}")
public Employee updateEmployee(@PathVariable int id,
                               @RequestBody EmployeeDTO dto) {
    return service.update(id, dto);
}
}