package com.example.InventoryManagementSystem.controller;

import com.example.InventoryManagementSystem.model.EmployeeModel;
import com.example.InventoryManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{employeeId}")
    public Optional<EmployeeModel> getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    // Get employee by email
    @GetMapping("/email")
    public Optional<EmployeeModel> getEmployeeByEmail(@RequestParam String email) {
        return employeeService.getEmployeeByEmail(email);
    }

    // Save or update an employee
    @PostMapping
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeService.saveEmployee(employeeModel);
    }

    // Delete an employee
    @DeleteMapping("/{employeeId}")
    public boolean deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
