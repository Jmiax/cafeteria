package com.cafeteria.app.dto;

import java.util.UUID;

import com.cafeteria.app.enums.Estatus;



public class ProductoDTO {
	private UUID uuid;
	private String descripcion;
	private String imagen;
	private Integer existencia;
	private Estatus estatus;
	private String gustaDanielGR;
	
	private String gustaJaimeHT;
	
	private String gustaJuanDiegoRV;

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
