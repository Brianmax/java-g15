package com.example.api_rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "numero_documento", unique = true)
    private String numeroDocumento;

    private String estado;

    private String condicion;

    private String direccion;

    private String ubigeo;

    @Column(name = "via_tipo")
    private String viaTipo;

    @Column(name = "via_nombre")
    private String viaNombre;

    @Column(name = "zona_codigo")
    private String zonaCodigo;

    @Column(name = "zona_tipo")
    private String zonaTipo;

    private String numero;

    private String interior;

    private String lote;

    private String dpto;

    private String manzana;

    private String kilometro;

    private String distrito;

    private String provincia;

    private String departamento;

    @Column(name = "es_agente_retencion")
    private boolean esAgenteRetencion;

    @Column(name = "es_buen_contribuyente")
    private boolean esBuenContribuyente;

    private String tipo;

    @Column(name = "actividad_economica")
    private String actividadEconomica;

    @Column(name = "numero_trabajadores")
    private String numeroTrabajadores;

    @Column(name = "tipo_facturacion")
    private String tipoFacturacion;

    @Column(name = "tipo_contabilidad")
    private String tipoContabilidad;

    @Column(name = "comercio_exterior")
    private String comercioExterior;
}
