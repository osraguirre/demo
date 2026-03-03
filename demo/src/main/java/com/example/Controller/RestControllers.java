package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class RestControllers {

    // logger provided by Lombok via @Log4j2 (no manual declaration needed)

    @GetMapping(value = "/hola")
    public String prueba() {
        log.info("Hola");
        return "Hola";
    }
}
