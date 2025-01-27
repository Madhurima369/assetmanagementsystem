package com.example.InventoryManagementSystem.service;

import com.example.InventoryManagementSystem.model.AssetModel;
import com.example.InventoryManagementSystem.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<AssetModel> getAllAssets() {
        return assetRepository.findAll();
    }

    public List<AssetModel> getAssetsByType(String type) {
        return assetRepository.findByType(type);
    }

    public Optional<AssetModel> getAssetBySerialNumber(String serialNumber) {
        return assetRepository.findBySerialNumber(serialNumber);
    }

    public AssetModel saveAsset(AssetModel assetModel) {
        //assetModel.setAvailable();
        return assetRepository.save(assetModel);
    }

    public void deleteAsset(Long assetId) {
        assetRepository.deleteById(assetId);
    }

}
