package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {
    

    @GetMapping(value="/hola")
    public void prueba(){
        System.out.println("Hola"); 
    }
}
