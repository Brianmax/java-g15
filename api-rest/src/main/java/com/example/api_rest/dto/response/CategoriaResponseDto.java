package com.example.api_rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaResponseDto {
    private UUID id;
    private String nombre;
    private String descripcion;
    private double popularidad;

    // articulos en los que la categoria esta presente
}
