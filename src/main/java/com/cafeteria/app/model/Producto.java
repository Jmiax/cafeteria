package com.cafeteria.app.model;

import java.util.UUID;

import com.cafeteria.app.enums.Estatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private UUID uuid;
	@PrePersist
    private void inicializarUuid() {
        this.uuid = UUID.randomUUID();
    }
	@Column
	private String descripcion;
	@Column(name = "imagen")
	private String imagen;
	@Column
	private Integer existencia;
	@Column
	private Estatus estatus;
	@Column
	private String gustaDanielGR;
	@Column
	private String gustaJaimeHT;
	@Column
	private String gustaJuanDiegoRV;
	@Column
	private String gustaYisharJB;
	//@ManyToOne
    //@JoinColumn(name = "idCategoria")
    //private Categoria categoria;
    //@ManyToOne
    //@JoinColumn(name = "idTamano")
    //private Tamano tamano;
    //@ManyToOne
    //@JoinColumn(name = "idProveedor")
    //private Proveedor proveedor;
	
	public UUID getUuid() {
		return uuid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
