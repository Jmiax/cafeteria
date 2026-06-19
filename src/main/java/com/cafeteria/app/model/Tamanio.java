package com.cafeteria.app.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tamanios")
public class Tamanio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTamanio;

    private UUID uuid;
    private String nombre;
    private Integer capacidad;
    private String unidad;
    private String descripcion;

    public Long getIdTamanio() {
        return idTamanio;
    }

    public void setIdTamanio(Long idTamanio) {
        this.idTamanio = idTamanio;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}