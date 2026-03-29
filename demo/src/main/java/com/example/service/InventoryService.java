package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Inventory;
import com.example.repository.InventoryRepository;
import com.example.repository.ProfileRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InventoryService {
    
    private InventoryRepository repository;
    private ProfileRepository profileRepository;

    @Autowired
    public InventoryService(InventoryRepository repository, ProfileRepository profileRepository) {
        this.repository = repository;
        this.profileRepository = profileRepository;
    }

    public void testInventory(){
        Inventory inv = new Inventory(1L, "Producto de prueba");
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
