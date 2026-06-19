package com.cafeteria.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.app.dto.TamanioDTO;
import com.cafeteria.app.model.Tamanio;
import com.cafeteria.app.repo.TamanioRepo;

@Service
public class TamanioService {

    @Autowired
    private TamanioRepo tamanioRepo;

    public List<Tamanio> listar() {
        return tamanioRepo.findAll();
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
}