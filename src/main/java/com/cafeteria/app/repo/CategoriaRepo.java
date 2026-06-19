package com.cafeteria.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafeteria.app.model.Categoria;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
	Optional<Categoria> findByUuid(UUID uuid);
	
	void deleteByUuid(UUID uuid);
}
