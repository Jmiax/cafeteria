package com.cafeteria.app.dto;

import java.util.UUID;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ProveedorDTO {

	private UUID uuid;

	@NotBlank(message = "¡Este campo es obligatorio!")
	private String nombreEmpresa;

	@NotBlank(message = "¡Este campo es obligatorio!")
	private String telefono;

	@NotBlank(message = "¡Este campo es obligatorio!")
	@Email(message = "¡Debe ingresar un correo electrónico válido!")
	private String correo;

	@NotBlank(message = "¡Este campo es obligatorio!")
	private String direccion;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
