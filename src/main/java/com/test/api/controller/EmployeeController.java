package com.test.api.controller;

import com.test.api.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final List<Employee> employees = new ArrayList<>();

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);
        return employee;
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {

    }

    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {

    }

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
