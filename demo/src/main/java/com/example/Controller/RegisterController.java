package com.example.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Register;
import com.example.service.RegisterConsumer;
import com.example.service.RegisterProducer;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/register")
@Tag(name = "Register API", description = "Endpoints for managing registers")
public class RegisterController {

    private final RegisterProducer registerProducer;
    private final RegisterConsumer registerConsumer;

    public RegisterController(RegisterConsumer registerConsumer, RegisterProducer registerProducer) {
        this.registerProducer = registerProducer;
        this.registerConsumer = registerConsumer;
    }

    @PostMapping()
    public String consumeRegister() {
        registerProducer.sendEvent("Test message from RegisterController");
        return "Register producer is running and sending messages to Kafka topic.";
    }

    @GetMapping()
    public List<Register> getRegisterStatus() {
        return registerConsumer.findAllRegisters();
    }
}
