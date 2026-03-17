package com.example.api_rest.service;

import com.example.api_rest.dto.request.UsuarioCreateDto;
import com.example.api_rest.dto.response.UsuarioResponseDto;
import com.example.api_rest.entity.UsuarioEntity;
import com.example.api_rest.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ResourceUrlProvider resourceUrlProvider;

    public UsuarioService(UsuarioRepository usuarioRepository, ResourceUrlProvider resourceUrlProvider) {
        this.usuarioRepository = usuarioRepository;
        this.resourceUrlProvider = resourceUrlProvider;
    }

    public UsuarioResponseDto saveUsuario(UsuarioCreateDto usuario) {
        // guardar los nombres en mayusculas
        // numero de comentarios a 0
        // dni de 8 digitos
        // validar email
        // password mas de 8 digitos, un caracter numerico y una mayuscula
        // verificar dni
        String nombres = usuario.getNombres().toUpperCase();
        String apellido = usuario.getApellidos().toUpperCase();
        // una vez las reglas se cumplen

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombres(nombres);
        usuarioEntity.setApellidos(apellido);
        usuarioEntity.setDescripcion(usuario.getDescripcion());
        usuarioEntity.setUsername(usuario.getUsername());
        usuarioEntity.setPassword(usuario.getPassword());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioEntity.setSexo(usuario.getSexo());
        usuarioEntity.setDni(usuario.getDni());
        usuarioRepository.save(usuarioEntity);

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setId(usuarioEntity.getId());
        usuarioResponseDto.setDescripcion(usuarioEntity.getDescripcion());
        usuarioResponseDto.setNombres(usuarioEntity.getNombres());
        usuarioResponseDto.setApellidos(usuarioEntity.getApellidos());
        usuarioResponseDto.setUsername(usuarioEntity.getUsername());
        usuarioResponseDto.setEmail(usuarioEntity.getEmail());
        usuarioResponseDto.setFechaNacimiento(usuarioEntity.getFechaNacimiento());
        usuarioResponseDto.setNumComentarios(usuarioEntity.getNumComentarios());
        return usuarioResponseDto;
    }

    public UsuarioResponseDto findById(UUID idUsuario) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(idUsuario);

        if(usuarioOptional.isEmpty()) {
            return null;
        }
        UsuarioEntity usuario = usuarioOptional.get();
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setId(usuario.getId());
        usuarioResponseDto.setDescripcion(usuario.getDescripcion());
        usuarioResponseDto.setNombres(usuario.getNombres());
        usuarioResponseDto.setApellidos(usuario.getApellidos());
        usuarioResponseDto.setUsername(usuario.getUsername());
        usuarioResponseDto.setEmail(usuario.getEmail());
        usuarioResponseDto.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioResponseDto.setNumComentarios(usuario.getNumComentarios());
        return usuarioResponseDto;
    }
}
