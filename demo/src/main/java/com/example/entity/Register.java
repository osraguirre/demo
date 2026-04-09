package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "registro", indexes={ @Index(name = "idx_id_registro", columnList = "id_registro") })
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private long id;

    @Column(name = "mensaje", length = 60, nullable = false)
    private String message;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime dateTime;

    public Register(String message, LocalDateTime dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
