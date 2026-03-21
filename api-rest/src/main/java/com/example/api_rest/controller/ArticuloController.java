package com.example.api_rest.controller;

import com.example.api_rest.dto.request.CreateArticuloDto;
import com.example.api_rest.dto.response.ResponseArticuloDto;
import com.example.api_rest.service.ArticuloService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articulo")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @PostMapping("/save")
    public ResponseArticuloDto createArticulo(@RequestBody CreateArticuloDto createArticuloDto) {
        return articuloService.createArticulo(createArticuloDto);
    }

    // implementar la busqueda por id de un articulo
    // implementar el resource not found para este endpoint
}
