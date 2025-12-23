package com.example.inventory.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class InventoryModel {
    @Id
    private int id;
    private int itemId;
    private int productId;
    private int quantity;
}
