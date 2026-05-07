package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.entity.Register;
import com.example.repository.RegisterRepository;

@Service
public class RegisterConsumer {

    private static final Logger log = LoggerFactory.getLogger(RegisterConsumer.class);

    private final RegisterRepository registerRepository;

    public RegisterConsumer(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @KafkaListener(topics = "register-topic", groupId = "backend-consumer")
    public void registerListen(String message) {
        log.debug("Consumer method called");
        log.info("Received message: {}", message);
        
        Register register = new Register(message, LocalDateTime.now());
        registerRepository.save(register);
        log.info("Saved register: {}", register);
    }

    public List<Register> findAllRegisters() {
        return registerRepository.findAll();
    }
    
}
