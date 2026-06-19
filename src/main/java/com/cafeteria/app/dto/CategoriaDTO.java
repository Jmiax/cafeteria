package com.cafeteria.app.dto;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {

	private UUID uuid;

	@NotBlank(message = "¡Este campo es obligatorio!")
	private String nombre;

	@NotBlank(message = "¡Este campo es obligatorio!")
	private String descripcion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
