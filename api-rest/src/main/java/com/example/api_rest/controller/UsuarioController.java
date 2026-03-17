package com.example.api_rest.controller;

import com.example.api_rest.dto.request.UsuarioCreateDto;
import com.example.api_rest.dto.response.UsuarioResponseDto;
import com.example.api_rest.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public UsuarioResponseDto saveUsuario(@RequestBody UsuarioCreateDto usuarioCreateDto) {
        return usuarioService.saveUsuario(usuarioCreateDto);
    }

    @GetMapping("/find/{id}")
    public UsuarioResponseDto findById(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    // buscar usuarios por id
    // actualizar un usuario
    // buscar por nombre
}


// implementar la insercion de una categoria. Crear el repository y el controlador