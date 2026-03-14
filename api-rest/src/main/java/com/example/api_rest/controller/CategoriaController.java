package com.example.api_rest.controller;

import com.example.api_rest.dto.request.CategoriaCreateDto;
import com.example.api_rest.dto.response.CategoriaResponseDto;
import com.example.api_rest.service.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/save")
    public CategoriaResponseDto createCategoria(@RequestBody CategoriaCreateDto categoriaCreateDto) {
        return categoriaService.crearCategoria(categoriaCreateDto);
    }
}
