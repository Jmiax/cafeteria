package com.cafeteria.app.dto;

import java.time.LocalDate;
import java.util.UUID;

public class PedidosDTO {
	
	private Double total;
	private LocalDate fecha;
	 private UUID uuid;
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

	 
	 
}
