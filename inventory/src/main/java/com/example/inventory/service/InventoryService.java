package com.example.inventory.service;

import com.example.inventory.inventoryDto.Dto;
import com.example.inventory.model.InventoryModel;
import com.example.inventory.repo.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<Dto> getAllItems(){
        List<InventoryModel> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList,new TypeToken<List<Dto>>(){}.getType());

    }

    public Dto getItemById(Integer itemId){
        InventoryModel item = inventoryRepo.getItemById(itemId);
        return modelMapper.map(item, Dto.class);
    }


   public Dto saveItem(Dto dto){
        inventoryRepo.save(modelMapper.map(dto,InventoryModel.class));
        return dto;
   }

   public Dto updateItem(Dto dto){
        inventoryRepo.save(modelMapper.map(dto,InventoryModel.class));
        return dto;
   }

    public String deleteItem(Integer itemId) {
        inventoryRepo.deleteById(itemId);
        return "Item deleted";
    }






}
