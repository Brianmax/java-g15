package com.example.api_rest.service;

import com.example.api_rest.dto.UsuarioCreateDto;
import com.example.api_rest.entity.UsuarioEntity;
import com.example.api_rest.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity saveUsuario(UsuarioCreateDto usuario) {
        // guardar los nombres en mayusculas
        // numero de comentarios a 0
        // dni de 8 digitos
        // validar email
        // password mas de 8 digitos, un caracter numerico y una mayuscula
        // verificar dni
        String nombres = usuario.getNombres().toUpperCase();
        String apellido = usuario.getApellidos().toUpperCase();
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
        return usuarioRepository.save(usuarioEntity);
    }
}
