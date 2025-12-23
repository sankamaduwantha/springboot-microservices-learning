package com.example.inventory.repo;

import com.example.inventory.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepo extends JpaRepository<InventoryModel,Integer> {
    @Query(value = "SELECT * FROM inventory_model WHERE id=?1", nativeQuery = true)
    InventoryModel getItemById(Integer itemId);
}
