package com.example.InventoryManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Data
@Getter
@Setter
@Table
public class AssignmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EmployeeModel employee;
    @Getter
    @ManyToOne
    private AssetModel asset;

    private LocalDate assignedDate;
    private LocalDate returnDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    public void setAsset(AssetModel asset) {
        this.asset = asset;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    public AssignmentModel() {
    }


}
