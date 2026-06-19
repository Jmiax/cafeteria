package com.cafeteria.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.app.dto.CategoriaDTO;
import com.cafeteria.app.model.Categoria;
import com.cafeteria.app.repo.CategoriaRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepo categoriaRepo;

	@Autowired
	ModelMapper mapper;

	public List<CategoriaDTO> listar() {
		return categoriaRepo.findAll().stream()
				.map(categoria -> mapper.map(categoria, CategoriaDTO.class))
				.toList();
	}

	public void guardar(CategoriaDTO categoriaDTO) {
		categoriaRepo.save(mapper.map(categoriaDTO, Categoria.class));
	}

	public void actualiza(CategoriaDTO categoriaDTO) {
		Optional<Categoria> optCategoria = categoriaRepo.findByUuid(categoriaDTO.getUuid());
		if (optCategoria.isPresent()) {
			mapper.map(categoriaDTO, optCategoria.get());
			categoriaRepo.save(optCategoria.get());
		} else {
			throw new EntityNotFoundException("Categoría no encontrada con el UUID: " + categoriaDTO.getUuid());
		}
	}

	public void borrar(UUID uuid) {
		Optional<Categoria> optCategoria = categoriaRepo.findByUuid(uuid);
		if (optCategoria.isPresent()) {
			categoriaRepo.delete(optCategoria.get());
		} else {
			throw new EntityNotFoundException("Categoría no encontrada con el UUID: " + uuid);
		}
	}

	@Transactional
	public void borrar2(UUID uuid) {
		categoriaRepo.deleteByUuid(uuid);
	}

	public CategoriaDTO obtenerCategoriaUUID(UUID uuid) {
		Optional<Categoria> optCategoria = categoriaRepo.findByUuid(uuid);
		if (optCategoria.isPresent()) {
			return mapper.map(optCategoria.get(), CategoriaDTO.class);
		} else {
			throw new EntityNotFoundException("Categoría no encontrada con el UUID: " + uuid);
		}
	}
}
