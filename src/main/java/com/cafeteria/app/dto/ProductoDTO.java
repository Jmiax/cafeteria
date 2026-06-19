package com.cafeteria.app.dto;

import java.util.UUID;

import com.cafeteria.app.enums.Estatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductoDTO {
	private UUID uuid;
	@NotBlank(message = "¡Este campo es obligatorio!")
	private String descripcion;
	private String imagen;
	@NotNull(message = "¡Este campo es obligatorio!")
	@Min(value = 1, message = "¡La existencia debe ser minimo 1!")
	private Integer existencia;
	private Estatus estatus;
	@NotBlank(message = "¡Este campo es obligatorio!")
	private String gustaDanielGR;
	@NotBlank(message = "¡Este campo es obligatorio!")
	private String gustaJaimeHT;
	@NotBlank(message = "¡Este campo es obligatorio!")
	private String gustaJuanDiegoRV;
	@NotBlank(message = "¡Este campo es obligatorio!")
	private String gustaYisharJB;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getExistencia() {
		return existencia;
	}
	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
	public String getGustaDanielGR() {
		return gustaDanielGR;
	}
	public void setGustaDanielGR(String gustaDanielGR) {
		this.gustaDanielGR = gustaDanielGR;
	}
	public String getGustaJaimeHT() {
		return gustaJaimeHT;
	}
	public void setGustaJaimeHT(String gustaJaimeHT) {
		this.gustaJaimeHT = gustaJaimeHT;
	}
	public String getGustaJuanDiegoRV() {
		return gustaJuanDiegoRV;
	}
	public void setGustaJuanDiegoRV(String gustaJuanDiegoRV) {
		this.gustaJuanDiegoRV = gustaJuanDiegoRV;
	}
	public String getGustaYisharJB() {
		return gustaYisharJB;
	}
	public void setGustaYisharJB(String gustaYisharJB) {
		this.gustaYisharJB = gustaYisharJB;
	} 
}
