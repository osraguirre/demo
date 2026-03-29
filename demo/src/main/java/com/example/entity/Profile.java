package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "perfil", indexes={@Index(name = "idx_id_perfil", columnList = "id_perfil")})
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private long id;

    @Column(name = "nombre_candidato", length=50, nullable = false)
    private String name;

    @Column(name = "apellido_candidato", length=50, nullable = false)
    private String lastName;

    @Column(name = "ubicacion", length=100, nullable = false)
    private String location;

    @Column(name = "rol", length=100, nullable = false)
    private String role;

    @JsonManagedReference
    @OneToMany(mappedBy="profile", cascade = CascadeType.ALL)
    private List<SkillEntity> skills;

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id + "," +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", role='" + role + '\'' +
                ", skills=" + skills +
                '}';
    }
}