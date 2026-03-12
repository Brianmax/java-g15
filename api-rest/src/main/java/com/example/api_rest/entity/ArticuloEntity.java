package com.example.api_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "articulos")
@Entity
@Getter
@Setter
public class ArticuloEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String titulo;
    private String contenido;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    private String url;

    @ManyToOne()
    @JoinColumn(name = "usuario_id_fk")
    private UsuarioEntity usuario;
}
