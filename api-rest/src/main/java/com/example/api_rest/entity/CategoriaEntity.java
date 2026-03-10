package com.example.api_rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nombre;
    private String descripcion;
    private double popularidad;


    public CategoriaEntity() {
    }

    public CategoriaEntity(UUID id, String nombre, String descripcion, double popularidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.popularidad = popularidad;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }
}
