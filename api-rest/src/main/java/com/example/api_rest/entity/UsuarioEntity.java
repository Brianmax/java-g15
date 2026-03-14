package com.example.api_rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String descripcion;
    private String nombres;
    private String apellidos;
    private String username;
    private String password;
    private String email;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private char sexo;
    private String dni;
    @Column(name = "num_comentarios")
    private int numComentarios = 0;
    private Date fechaCreacion = new Date();
    private Date fechaActualizacion;
}
