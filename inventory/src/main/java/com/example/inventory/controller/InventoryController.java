package com.example.inventory.controller;

import com.example.inventory.inventoryDto.Dto;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")

public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getallinventory")
    public List<Dto> getItems(){
        return inventoryService.getAllItems();
    }

    @GetMapping(value ="/item/{itemId}")
    public Dto getUserById(@PathVariable Integer itemId){
        return inventoryService.getItemById(itemId);
    }

    @PostMapping(value = "/saveItem")
    public Dto saveItems(@RequestBody Dto dto){
        return inventoryService.saveItem(dto);
    }

    @PutMapping(value = "/updateItem")
    public Dto updateItems(@RequestBody Dto dto){
        return inventoryService.updateItem(dto);
    }

    @DeleteMapping("/deleteitem/{itemId}")
    public String deleteItem(@PathVariable Integer itemId) {
        return inventoryService.deleteItem(itemId);
    }



}
