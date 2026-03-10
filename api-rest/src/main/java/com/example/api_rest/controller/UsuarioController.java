package com.example.api_rest.controller;

import com.example.api_rest.entity.UsuarioEntity;
import com.example.api_rest.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping("/save")
    public UsuarioEntity saveUsuario(@RequestBody UsuarioEntity usuarioPayload) {
        return usuarioRepository.save(usuarioPayload);
    }
}
