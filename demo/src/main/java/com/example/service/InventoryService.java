package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Inventory;
import com.example.repository.InventoryRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InventoryService {
    
    private InventoryRepository repository;

    @Autowired
    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void testInventory(){
        Inventory inv = new Inventory(1L, "Producto de prueba");
        repository.save(inv);
        repository.findById(1L).ifPresent(inventory -> {
            log.info("Inventory found: {}", inventory);
        });
    }

}
