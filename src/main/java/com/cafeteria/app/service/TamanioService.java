package com.cafeteria.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.app.dto.TamanioDTO;
import com.cafeteria.app.model.Tamanio;
import com.cafeteria.app.repo.TamanioRepo;

@Service
public class TamanioService {

    @Autowired
    private TamanioRepo tamanioRepo;

    public List<TamanioDTO> listar() {
        return tamanioRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void guardar(TamanioDTO dto) {
        Tamanio tamanio = new Tamanio();

        tamanio.setUuid(UUID.randomUUID());
        tamanio.setNombre(dto.getNombre());
        tamanio.setCapacidad(dto.getCapacidad());
        tamanio.setUnidad(dto.getUnidad());
        tamanio.setDescripcion(dto.getDescripcion());

        tamanioRepo.save(tamanio);
    }

    public void actualiza(TamanioDTO dto) {
        Tamanio tamanio = new Tamanio();

        tamanio.setIdTamanio(dto.getIdTamanio());
        tamanio.setUuid(dto.getUuid());
        tamanio.setNombre(dto.getNombre());
        tamanio.setCapacidad(dto.getCapacidad());
        tamanio.setUnidad(dto.getUnidad());
        tamanio.setDescripcion(dto.getDescripcion());

        tamanioRepo.save(tamanio);
    }

    public TamanioDTO obtenerTamanioUUID(UUID uuid) {
        Tamanio t = tamanioRepo.findByUuid(uuid);
        return mapToDTO(t);
    }

    public void borrar(UUID uuid) {
        Tamanio t = tamanioRepo.findByUuid(uuid);
        if (t != null) {
            tamanioRepo.delete(t);
        }
    }

    // ---------------- MAPPER ----------------

    private TamanioDTO mapToDTO(Tamanio t) {
        TamanioDTO dto = new TamanioDTO();
        dto.setIdTamanio(t.getIdTamanio());
        dto.setUuid(t.getUuid());
        dto.setNombre(t.getNombre());
        dto.setCapacidad(t.getCapacidad());
        dto.setUnidad(t.getUnidad());
        dto.setDescripcion(t.getDescripcion());
        return dto;
    }
}