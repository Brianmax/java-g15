package com.example.api_rest.dto;
import jakarta.persistence.Column;
import java.util.Date;
import java.util.UUID;

public class UsuarioResponseDto {
    private UUID id;
    private String descripcion;
    private String nombres;
    private String apellidos;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private int numComentarios;
}
