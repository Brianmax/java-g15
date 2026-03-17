package com.example.api_rest.service;

import com.example.api_rest.dto.request.CreateArticuloDto;
import com.example.api_rest.dto.response.ResponseArticuloDto;
import com.example.api_rest.entity.ArticuloEntity;
import com.example.api_rest.entity.UsuarioEntity;
import com.example.api_rest.repository.ArticuloRespository;
import com.example.api_rest.repository.UsuarioRepository;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArticuloService {
    private final ArticuloRespository articuloRespository;
    private final UsuarioRepository usuarioRepository;

    public ArticuloService(ArticuloRespository articuloRespository, UsuarioRepository usuarioRepository) {
        this.articuloRespository = articuloRespository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseArticuloDto createArticulo(CreateArticuloDto articuloDto) {
        UUID idUsuario = articuloDto.getUsuarioId();
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (usuarioOptional.isEmpty()) {
            return null;
        }
        UsuarioEntity usuario = usuarioOptional.get();

        ArticuloEntity articuloEntity = new ArticuloEntity();
        articuloEntity.setTitulo(articuloDto.getTitulo());
        articuloEntity.setContenido(articuloDto.getContenido());
        articuloEntity.setUrl("www." + articuloDto.getTitulo() + ".com");

        articuloEntity.setUsuario(usuario);
        articuloRespository.save(articuloEntity);

        ResponseArticuloDto responseArticuloDto = new ResponseArticuloDto();
        responseArticuloDto.setId(articuloEntity.getId());
        responseArticuloDto.setTitulo(articuloEntity.getTitulo());
        responseArticuloDto.setContenido(articuloEntity.getContenido());
        responseArticuloDto.setUrl(articuloEntity.getUrl());
        return responseArticuloDto;
    }
}
