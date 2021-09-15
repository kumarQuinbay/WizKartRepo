package com.example.inventoryService.repository;

import com.example.inventoryService.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    public Inventory findByProductIdAndMerchantId(long productId, long merchantId);

}
