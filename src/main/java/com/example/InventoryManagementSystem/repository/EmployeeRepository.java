package com.example.InventoryManagementSystem.repository;


import com.example.InventoryManagementSystem.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    Optional<EmployeeModel> findByEmail(String email);
}