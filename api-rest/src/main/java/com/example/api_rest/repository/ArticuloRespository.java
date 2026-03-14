package com.example.api_rest.repository;

import com.example.api_rest.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticuloRespository extends JpaRepository<ArticuloEntity, UUID> {
}
