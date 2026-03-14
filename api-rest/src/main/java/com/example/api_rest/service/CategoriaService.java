package com.example.api_rest.service;

import com.example.api_rest.dto.request.CategoriaCreateDto;
import com.example.api_rest.dto.response.CategoriaResponseDto;
import com.example.api_rest.entity.CategoriaEntity;
import com.example.api_rest.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponseDto crearCategoria(CategoriaCreateDto categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre(categoria.getNombre());
        categoriaEntity.setDescripcion(categoria.getDescripcion());
        categoriaRepository.save(categoriaEntity);

        return new CategoriaResponseDto(
                categoriaEntity.getId(),
                categoriaEntity.getNombre(),
                categoriaEntity.getDescripcion(),
                categoriaEntity.getPopularidad()
        );
    }
}
