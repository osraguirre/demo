package com.example.entity;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habilidad", indexes={@Index(name = "idx_id_habilidad", columnList = "id_habilidad")})
public class SkillEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad")
    private long id;

    @Column(name = "tecnologia", length=100, nullable = false)
    private String technology;

    @Column(name = "nivel", length=50, nullable = false)
    private String level;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false)
    private Profile profile;

        public SkillEntity(String technology, String level, Profile profile) {
            this.technology = technology;
            this.level = level;
            this.profile = profile;
        }

    @Override
    public String toString() {
        return "SkillEntity{" +
                "id=" + id +
                ", technology='" + technology + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
