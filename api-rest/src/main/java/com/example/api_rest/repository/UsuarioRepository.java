package com.example.api_rest.repository;

import com.example.api_rest.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    @Query(value = "SELECT * FROM usuario where username = :username", nativeQuery = true)
    Optional<UsuarioEntity> findByUsername(String username);

    @Query(value = "select * from usuario where fecha_nacimiento = :fechaNacimiento", nativeQuery = true)
    List<UsuarioEntity> findByFechaNacimientoAfter(Date fechaNaciemiento);
}
