package com.example.redis.controller;


import com.example.redis.entity.Employee;
import com.example.redis.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        Employee employeeDb = employeeRepo.save(employee);
        return "Employee Added with EmployeeId : " + employeeDb.getId() + ".";
    }

    @GetMapping
    @Cacheable("getAllEmployees")
    public List<Employee> getAllEmployees() {
        System.out.println("GET-ALL Employees____________");
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "employee", key = "#id")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        System.out.println("GET Employee____________");
        Employee employee = employeeRepo.findById(id).get();
        return employee;
    }

    @PatchMapping("/{id}")
    @CachePut(value = "employee", key = "#id")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        System.out.println("PATCH Employee____________");
        Optional<Employee> employeeDb = employeeRepo.findById(id);
        if (employeeDb.isPresent()) {
            if (null != employee.getFirstName()) {
                employeeDb.get().setFirstName(employee.getFirstName());
            }
            if (null != employee.getLastName()) {
                employeeDb.get().setLastName(employee.getLastName());
            }
            employeeRepo.save(employeeDb.get());
        }
        return employeeDb.get();
    }

    @DeleteMapping
    public String deleteAllEmployees() {
        employeeRepo.deleteAll();
        return "All employees are deleted.";
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) {

    }
}
