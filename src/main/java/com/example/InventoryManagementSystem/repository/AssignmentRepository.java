package com.example.InventoryManagementSystem.repository;

import com.example.InventoryManagementSystem.model.AssetModel;
import com.example.InventoryManagementSystem.model.AssignmentModel;
import com.example.InventoryManagementSystem.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//public interface AssignmentRepository extends JpaRepository<AssignmentModel, Long> {
//    List<AssetModel> findByEmployee(EmployeeModel employee);
//}


// Change this in AssignmentRepository
public interface AssignmentRepository extends JpaRepository<AssignmentModel, Long> {
    List<AssignmentModel> findByEmployee(EmployeeModel employee);
}
