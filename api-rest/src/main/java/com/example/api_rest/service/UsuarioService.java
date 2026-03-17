package com.example.api_rest.service;

import com.example.api_rest.dto.request.UsuarioCreateDto;
import com.example.api_rest.dto.response.ResponseArticuloDto;
import com.example.api_rest.dto.response.UsuarioResponseDto;
import com.example.api_rest.entity.ArticuloEntity;
import com.example.api_rest.entity.UsuarioEntity;
import com.example.api_rest.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public UsuarioResponseDto saveUsuario(UsuarioCreateDto usuario) {
        // guardar los nombres en mayusculas
        // numero de comentarios a 0
        // dni de 8 digitos
        // validar email
        // password mas de 8 digitos, un caracter numerico y una mayuscula
        // verificar dni
        usuario.setNombres(usuario.getNombres().toUpperCase());
        usuario.setApellidos(usuario.getApellidos().toUpperCase());
        // una vez las reglas se cumplen

        // de usuario create dto ---> Usuario entity
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        modelMapper.map(usuario, usuarioEntity);
        usuarioRepository.save(usuarioEntity);

        // de usuario entity a ---> Usuario response dto
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        modelMapper.map(usuarioEntity, usuarioResponseDto);
        return usuarioResponseDto;
    }

    public UsuarioResponseDto findById(UUID idUsuario) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(idUsuario);

        if(usuarioOptional.isEmpty()) {
            return null;
        }

        // de usuario entity ---> Usuario response dto
        UsuarioEntity usuario = usuarioOptional.get();
        List<ArticuloEntity> articulos = usuario.getArticulos();

        List<ResponseArticuloDto> responseArticuloDtos
                = articulos.stream().map(articuloEntity -> {
                    ResponseArticuloDto responseArticuloDto = new ResponseArticuloDto();
                    modelMapper.map(articuloEntity, responseArticuloDto);
                    return responseArticuloDto;
                }).toList();

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        modelMapper.map(usuario, usuarioResponseDto);
        usuarioResponseDto.setArticulos(responseArticuloDtos);
        return usuarioResponseDto;
    }
}
