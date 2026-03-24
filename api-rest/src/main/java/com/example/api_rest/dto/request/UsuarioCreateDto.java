package com.example.api_rest.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioCreateDto {
    private String descripcion;
    @NotBlank(message = "La contrasenia es obligatoria")
    @Size(min = 8, message = "La contrasenia debe tener al menos 8 caracteres")
    private String password;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato de email no es valido")
    private String email;
    @NotNull(message = "Fecha de nacimiento obligatoria")
    @Past(message = "La fecha de nacimiento debe de ser una fecha pasada")
    private Date fechaNacimiento;

    private char sexo;
    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "^\\d+$", message = "El DNI debe contener exactamente 8 digitos numericos")
    private String dni;
}
