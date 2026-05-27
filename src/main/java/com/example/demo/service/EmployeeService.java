package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.Employeenotfoundexception;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // CREATE (DTO → ENTITY)
    public Employee save(EmployeeDTO dto) {

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setAge(dto.getAge());

        return repository.save(emp);
    }

    // READ ALL
    public List<Employee> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Employee getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new Employeenotfoundexception(
                        "Employee not found with id: " + id));
    }

    // DELETE
    public void delete(int id) {
        repository.deleteById(id);
    }
    public Employee update(int id, EmployeeDTO dto) {

    Employee emp = repository.findById(id)
            .orElseThrow(() -> new Employeenotfoundexception(
                    "Employee not found with id: " + id));

    emp.setName(dto.getName());
    emp.setAge(dto.getAge());

    return repository.save(emp);
}
}