package com.example.api_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nombre;
    private String descripcion;
    private double popularidad;

    @ManyToMany
    @JoinTable(
            name = "categoria_articulo",
            joinColumns = @JoinColumn(name = "id_categoria_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_articulo_fk")
    )
    private ArrayList<ArticuloEntity> articulos;
}
