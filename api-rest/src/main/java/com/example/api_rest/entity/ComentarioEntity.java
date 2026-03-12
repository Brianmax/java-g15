package com.example.api_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Table(name = "comentarios")
@Entity
public class ComentarioEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String contenido;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private Date fechaActulizacion;

    @ManyToOne()
    @JoinColumn(name = "usuario_id_fk")
    private UsuarioEntity usuario;

    @ManyToOne()
    @JoinColumn(name = "articulo_id_fk")
    private ArticuloEntity articulo;

}
