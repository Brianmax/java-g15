package com.example.api_rest.dto.response;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
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
