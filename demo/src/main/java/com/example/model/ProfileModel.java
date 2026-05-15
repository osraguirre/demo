package com.example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Modelo de datos para la creación de un perfil")
public class ProfileModel {
    
    @Schema(description = "Nombre del candidato", example = "Ramon")
    private String name;
    @Schema(description = "Apellido del candidato", example = "Martinez")
    private String lastName;
    @Schema(description = "Ubicación del candidato", example = "New York")
    private String location;
    @Schema(description = "Role del candidato", example = "Software Engineer")
    private String role;
}
