package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.InventoryService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class RestControllers {

    private InventoryService inventoryService;

    @Autowired
    public RestControllers(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    // logger provided by Lombok via @Log4j2 (no manual declaration needed)

    @GetMapping(value = "/hola")
    public String prueba() {
        log.info("Hola");
        inventoryService.testInventory();
        return "Hola";
    }
}
