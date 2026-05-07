package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegisterProducer {

    private static final Logger log = LoggerFactory.getLogger(RegisterProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public RegisterProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String message) {
        log.info("Sending message: {}", message);
        kafkaTemplate.send("register-topic", message).whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Kafka send failed", ex);
            } else {
                log.info("Kafka send success: topic={}, partition={}, offset={}",
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
        });
    }
    
}
