package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Inventory;
import com.example.repository.InventoryRepository;
import com.example.repository.ProfileRepository;

@Service
public class InventoryService {
    
    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    private InventoryRepository repository;
    private ProfileRepository profileRepository;

    @Autowired
    public InventoryService(InventoryRepository repository, ProfileRepository profileRepository) {
        this.repository = repository;
        this.profileRepository = profileRepository;
    }

    public void testInventory(){
        Inventory inv = new Inventory();
        inv.setProductName("Producto de prueba");
        repository.save(inv);
        repository.findById(1L).ifPresent(inventory -> {
            log.info("Inventory found: {}", inventory);
        });
        profileRepository.findById(1L).ifPresent(profile -> {
            log.info("Profile found: {}", profile);
            log.info("prueba");
        });
    }

}
