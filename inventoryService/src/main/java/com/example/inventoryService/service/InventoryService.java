package com.example.inventoryService.service;

import com.example.inventoryService.entity.Inventory;

import java.util.List;

public interface InventoryService {

    public Inventory get(Long id);
    public Inventory save(Inventory inventory);
    public Inventory update(Inventory inventory);
    public void delete(Long id);
    public Inventory findByProductIdAndMerchantId(long productId, long merchantId);
}
