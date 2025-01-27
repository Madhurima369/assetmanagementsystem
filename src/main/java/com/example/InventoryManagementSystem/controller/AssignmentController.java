package com.example.InventoryManagementSystem.controller;

import com.example.InventoryManagementSystem.model.AssetModel;
import com.example.InventoryManagementSystem.model.AssignmentModel;
import com.example.InventoryManagementSystem.model.EmployeeModel;
import com.example.InventoryManagementSystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;


    @PostMapping("/assign")
    public AssignmentModel assignAssetToEmployee(@RequestParam Long assetId, @RequestParam Long employeeId) {
        return assignmentService.assignAssetToEmployee(assetId, employeeId);
    }


//
//    @GetMapping("/employee/{employeeId}")
//    public List<AssetModel> getAssignmentsByEmployee(@PathVariable Long employeeId) {
//        EmployeeModel employee = new EmployeeModel();
//        employee.setId(employeeId);
//        return assignmentService.getAssignmentsByEmployee(employee);
//    }


    @GetMapping("/employee/{employeeId}")
    public List<AssignmentModel> getAssignmentsByEmployee(@PathVariable Long employeeId) {
        EmployeeModel employee = new EmployeeModel();
        employee.setId(employeeId);
        return assignmentService.getAssignmentsByEmployee(employee);
    }


    @PutMapping("/return/{assignmentId}")
    public AssignmentModel returnAsset(@PathVariable Long assignmentId) {
        return assignmentService.returnAsset(assignmentId);
    }
}

