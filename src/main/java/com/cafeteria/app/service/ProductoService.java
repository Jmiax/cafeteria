package com.cafeteria.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.app.dto.ProductoDTO;
import com.cafeteria.app.model.Producto;
import com.cafeteria.app.repo.ProductoRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoService {
	@Autowired
	ProductoRepo productoRepo;
	@Autowired
	ModelMapper mapper;
	
	public List<ProductoDTO> listar(){
		return productoRepo.findAll().stream().map(producto->mapper.map(producto, ProductoDTO.class)).toList();
	}
	
	public void guardar(ProductoDTO producto){
		productoRepo.save(mapper.map(producto, Producto.class));
	}
	
	public ProductoDTO obtenerProductoUUID(UUID uuid) {
		Optional<Producto> OptProducto=productoRepo.findByUuid(uuid);
		if(OptProducto.isPresent()) {
			return mapper.map(OptProducto.get(),ProductoDTO.class);
		}else {
			throw new EntityNotFoundException("Producto no encontrado con el UUID: "+uuid);
		}
	}
	
	public void actualiza(ProductoDTO producto) {
		Optional<Producto> OptProducto=productoRepo.findByUuid(producto.getUuid());
		if(OptProducto.isPresent()) {
			mapper.map(producto, OptProducto.get());
			productoRepo.save(OptProducto.get());
		}else {
			throw new EntityNotFoundException("Producto no encontrado con el UUID: "+producto.getUuid());
		}
	}
	
	public void borrar(UUID uuid) {
		Optional<Producto> OptProducto=productoRepo.findByUuid(uuid);
		if(OptProducto.isPresent()) {
			productoRepo.delete(OptProducto.get());
		}else {
			throw new EntityNotFoundException("Producto no encontrado con el UUID: "+uuid);
		}
	}
}
