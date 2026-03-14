package com.example.api_rest.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateArticuloDto {
    private String titulo;
    private String contenido;
    private UUID usuarioId;
}
