package com.cafeteria.app.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.app.model.Tamanio;

public interface TamanioRepo extends JpaRepository<Tamanio, Long> {

	Tamanio findByUuid(UUID uuid);

}