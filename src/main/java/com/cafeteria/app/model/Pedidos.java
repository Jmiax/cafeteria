package com.cafeteria.app.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(unique = true)
    private UUID uuid;

    public Pedidos() {
        this.uuid = UUID.randomUUID();
    }

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
