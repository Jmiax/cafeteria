package com.cafeteria.app.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProveedor;

	@Column(unique = true)
	private UUID uuid;

	@Column
	private String nombreEmpresa;

	@Column
	private String telefono;

	@Column
	private String correo;

	@Column
	private String direccion;

	@PrePersist
	private void inicializarUuid() {
		this.uuid = UUID.randomUUID();
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

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
