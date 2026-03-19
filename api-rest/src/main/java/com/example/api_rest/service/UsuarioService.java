package com.example.api_rest.service;

import com.example.api_rest.dto.request.UsuarioCreateDto;
import com.example.api_rest.dto.response.ReniecResponse;
import com.example.api_rest.dto.response.ResponseArticuloDto;
import com.example.api_rest.dto.response.UsuarioResponseDto;
import com.example.api_rest.entity.ArticuloEntity;
import com.example.api_rest.entity.UsuarioEntity;
import com.example.api_rest.feignClient.ReniecClient;
import com.example.api_rest.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.*;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final ReniecClient reniecClient;
    @Value("${api.token}")
    private String apiToken;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper, ReniecClient reniecClient) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.reniecClient = reniecClient;
    }

    public UsuarioResponseDto saveUsuario(UsuarioCreateDto usuario) {
        // validar email
        // password mas de 8 digitos, un caracter numerico y una mayuscula
        String dni = usuario.getDni();
        if(dni.length() != 8 || !dni.matches("^\\d+$")) {
            return null;
        }
        ReniecResponse response = reniecClient.getPersonaInfo(dni, apiToken);

        String username = response
                .getFirstName()
                .split("\\s+")[0]
                .toLowerCase() + "." +
                response.getFirstLastName().toLowerCase();
        // de usuario create dto ---> Usuario entity
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        modelMapper.map(usuario, usuarioEntity);
        usuarioEntity.setNombres(response.getFirstName());
        usuarioEntity.setApellidos(response.getFirstLastName() + " " + response.getSecondLastName());
        usuarioEntity.setUsername(username);
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
