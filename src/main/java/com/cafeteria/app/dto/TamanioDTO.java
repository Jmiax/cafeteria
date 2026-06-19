package com.cafeteria.app.dto;

import java.util.UUID;

public class TamanioDTO {

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