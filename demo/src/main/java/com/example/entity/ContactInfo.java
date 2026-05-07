package com.example.entity;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "informacion_contacto", indexes={
    @Index(name = "idx_id_informacion_contacto", columnList = "id_informacion_contacto")})
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacion_contacto")
    private long id;

    @Email(message = "El correo electrónico no es válido")
    @Column(name = "correo_electronico", length=100, nullable = false)
    private String email;

    @Column(name = "numero_telefono", length=20, nullable = false)
    private String phoneNumber;

    @URL(message = "La URL de LinkedIn no es válida")
    @Column(name = "linkedin_url", nullable = false)
    private String linkedin;

    @URL(message = "La URL de GitHub no es válida")
    @Column(name = "github_url", nullable = false)
    private String github;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false)
    private Profile profile;

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id + "," +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", github='" + github + '\'' +
                ", profile=" + profile +
                '}';
    }
    
}
