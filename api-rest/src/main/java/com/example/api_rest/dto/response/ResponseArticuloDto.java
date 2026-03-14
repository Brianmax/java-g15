package com.example.api_rest.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ResponseArticuloDto {
    private UUID id;
    private String titulo;
    private String contenido;
    private String url;
}
