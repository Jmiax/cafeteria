package com.cafeteria.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DetallePedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	

}
