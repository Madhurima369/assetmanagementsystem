package com.example.InventoryManagementSystem.service;

import com.example.InventoryManagementSystem.model.EmployeeModel;
import com.example.InventoryManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees() {

        return employeeRepository.findAll();
    }


    public Optional<EmployeeModel> getEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId);
    }


    public Optional<EmployeeModel> getEmployeeByEmail(String email) {

        return employeeRepository.findByEmail(email);
    }


    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {

        return employeeRepository.save(employeeModel);
    }


    public boolean deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }
}
