package com.example.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RegisterProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public RegisterProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String message) {
        log.info("Sending message: {}", message);
        kafkaTemplate.send("register-topic", message);
        log.info("Message sent to Kafka topic: {}", message);
    }
    
}
