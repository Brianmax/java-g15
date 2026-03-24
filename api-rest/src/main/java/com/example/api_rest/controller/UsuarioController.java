package com.example.api_rest.controller;

import com.example.api_rest.dto.request.UsuarioCreateDto;
import com.example.api_rest.dto.response.ApiResponse;
import com.example.api_rest.dto.response.UsuarioResponseDto;
import com.example.api_rest.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> saveUsuario(@Valid @RequestBody UsuarioCreateDto usuarioCreateDto) {
        UsuarioResponseDto usuarioResponse = usuarioService.saveUsuario(usuarioCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Usuario Creado", usuarioResponse));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDto>> findById(@PathVariable UUID id) {
        UsuarioResponseDto response = usuarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(true, "Usuario encontrado", response));
    }

    @GetMapping("/find/nombre/{nombre}")
    public ResponseEntity<ApiResponse<List<UsuarioResponseDto>>> findByNombre(@PathVariable String nombre) {
        List<UsuarioResponseDto> response = usuarioService.findByNombre(nombre);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(true, "Usuarios encontrados", response));
    }
}


// implementar la insercion de una categoria. Crear el repository y el controlador