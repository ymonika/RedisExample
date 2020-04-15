package com.example.redis.controller;


import com.example.redis.entity.Employee;
import com.example.redis.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("Calling getAllEmployees_____XXXXXXXXXXXXX_______");
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeRepo.findById(id).get();
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
