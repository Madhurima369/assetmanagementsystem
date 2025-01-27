
package com.example.InventoryManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class EmployeeModel {

    public EmployeeModel() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}



