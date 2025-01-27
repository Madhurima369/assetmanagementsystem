package com.example.InventoryManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Table
public class AssetModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String serialNumber;
    private String type;
    private boolean available;

    public AssetModel() {}

}

