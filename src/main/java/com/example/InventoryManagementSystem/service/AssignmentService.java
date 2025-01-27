package com.example.InventoryManagementSystem.service;

import com.example.InventoryManagementSystem.model.AssetModel;
import com.example.InventoryManagementSystem.model.AssignmentModel;
import com.example.InventoryManagementSystem.model.EmployeeModel;
import com.example.InventoryManagementSystem.repository.AssetRepository;
import com.example.InventoryManagementSystem.repository.AssignmentRepository;
import com.example.InventoryManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

@Transactional
    public AssignmentModel assignAssetToEmployee(Long assetId, Long employeeId) {
        Optional<AssetModel> asset = assetRepository.findById(assetId);
        Optional<EmployeeModel> employee = employeeRepository.findById(employeeId);

        if (asset.isPresent() && employee.isPresent()) {
            AssignmentModel assignment = new AssignmentModel();
            assignment.setAsset(asset.get());
            assignment.setEmployee(employee.get());
            assignment.setAssignedDate(LocalDate.now());

            //-------------------------------------------------------
            AssetModel assetModel = asset.get();
            assetModel.setAvailable(false); // Set available to false because it's assigned
            assetRepository.save(assetModel); // Save the updated asset
            //-------------------------------------------------------------


            return assignmentRepository.save(assignment);
        }

        return null;
    }



    public List<AssignmentModel> getAssignmentsByEmployee(EmployeeModel employee) {
        return assignmentRepository.findByEmployee(employee);
    }


    public AssignmentModel returnAsset(Long assignmentId) {
        Optional<AssignmentModel> assignment = assignmentRepository.findById(assignmentId);
        if (assignment.isPresent()) {
            AssignmentModel assignmentModel = assignment.get();
            assignmentModel.setReturnDate(LocalDate.now());
            assignmentRepository.save(assignmentModel);


            AssetModel asset = assignmentModel.getAsset();
            asset.setAvailable(true);
            assetRepository.save(asset);

            return assignmentModel;
        }
        return null;
    }
}
