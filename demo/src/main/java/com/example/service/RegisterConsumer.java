package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.entity.Register;
import com.example.repository.RegisterRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RegisterConsumer {

    private final RegisterRepository registerRepository;

    public RegisterConsumer(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @KafkaListener(topics = "register-topic", groupId = "cv-group")
    public void registerListen(String message) {
        log.info("Received message: {}", message);
        
        Register register = new Register(message, LocalDateTime.now());
        registerRepository.save(register);
        log.info("Saved register: {}", register);
    }

    public List<Register> findAllRegisters() {
        return registerRepository.findAll();
    }
    
}
