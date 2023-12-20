package com.test.api.controller;

import com.test.api.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final List<Employee> employees = new ArrayList<>();

    // Endpoint to retrieve all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Endpoint to retrieve details of a specific employee
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null; // Employee with the specified ID not found
    }

    // Endpoint to add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);
        return employee;
    }

    // Endpoint to update information of an existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setPosition(updatedEmployee.getPosition());
                employee.setSalary(updatedEmployee.getSalary());
                return employee;
            }
        }

        return null; // Employee with the specified ID not found
    }

    // Endpoint to remove specific information of an existing employee
    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                if (updatedEmployee.getName() != null) {
                    employee.setName(updatedEmployee.getName());
                }
                if (updatedEmployee.getPosition() != null) {
                    employee.setPosition(updatedEmployee.getPosition());
                }
                if (updatedEmployee.getSalary() != 0) {
                    employee.setSalary(updatedEmployee.getSalary());
                }
                return employee;
            }
        }

        return null; // Employee with the specified ID not found
    }

    // Endpoint to remove an existing employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return "Employee removed successfully";
            }
        }

        return "Employee with the specified ID not found";
    }
}
