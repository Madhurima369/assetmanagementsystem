package com.example.InventoryManagementSystem.controller;

import com.example.InventoryManagementSystem.model.AssetModel;
import com.example.InventoryManagementSystem.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;


    @GetMapping
    public List<AssetModel> getAllAssets() {
        return assetService.getAllAssets();
    }


    @GetMapping("/type")
    public List<AssetModel> getAssetsByType(@RequestParam String type) {
        return assetService.getAssetsByType(type);
    }

    @GetMapping("/serial-number")
    public AssetModel getAssetBySerialNumber(@RequestParam String serialNumber) {
        return assetService.getAssetBySerialNumber(serialNumber).orElse(null);
    }


    @PostMapping
    public AssetModel saveAsset(@RequestBody AssetModel assetModel) {

        return assetService.saveAsset(assetModel);
    }


    @DeleteMapping("/{assetId}")
    public boolean deleteAsset(@PathVariable Long assetId) {
        assetService.deleteAsset(assetId);
        return true;
    }

    @PostMapping("/add")
    public AssetModel addAsset(@RequestBody AssetModel assetModel) {
        return assetService.saveAsset(assetModel);
    }
}
