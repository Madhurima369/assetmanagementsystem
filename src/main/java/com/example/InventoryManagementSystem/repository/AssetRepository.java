package com.example.InventoryManagementSystem.repository;

import com.example.InventoryManagementSystem.model.AssetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssetRepository extends JpaRepository<AssetModel, Long> {
        List<AssetModel> findByType(String type);
        Optional<AssetModel> findBySerialNumber(String serialNumber);
    }


