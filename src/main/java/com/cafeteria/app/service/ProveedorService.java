package com.cafeteria.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.app.dto.ProveedorDTO;
import com.cafeteria.app.model.Proveedor;
import com.cafeteria.app.repo.ProveedorRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProveedorService {

	@Autowired
	ProveedorRepo proveedorRepo;

	@Autowired
	ModelMapper mapper;

	public List<ProveedorDTO> listar() {
		return proveedorRepo.findAll().stream()
				.map(proveedor -> mapper.map(proveedor, ProveedorDTO.class))
				.toList();
	}

	public void guardar(ProveedorDTO proveedorDTO) {
		proveedorRepo.save(mapper.map(proveedorDTO, Proveedor.class));
	}

	public void actualiza(ProveedorDTO proveedorDTO) {
		Optional<Proveedor> optProveedor = proveedorRepo.findByUuid(proveedorDTO.getUuid());
		if (optProveedor.isPresent()) {
			mapper.map(proveedorDTO, optProveedor.get());
			proveedorRepo.save(optProveedor.get());
		} else {
			throw new EntityNotFoundException("Proveedor no encontrado con el UUID: " + proveedorDTO.getUuid());
		}
	}

	public void borrar(UUID uuid) {
		Optional<Proveedor> optProveedor = proveedorRepo.findByUuid(uuid);
		if (optProveedor.isPresent()) {
			proveedorRepo.delete(optProveedor.get());
		} else {
			throw new EntityNotFoundException("Proveedor no encontrado con el UUID: " + uuid);
		}
	}

	@Transactional
	public void borrar2(UUID uuid) {
		proveedorRepo.deleteByUuid(uuid);
	}

	public ProveedorDTO obtenerProveedorUUID(UUID uuid) {
		Optional<Proveedor> optProveedor = proveedorRepo.findByUuid(uuid);
		if (optProveedor.isPresent()) {
			return mapper.map(optProveedor.get(), ProveedorDTO.class);
		} else {
			throw new EntityNotFoundException("Proveedor no encontrado con el UUID: " + uuid);
		}
	}
}
