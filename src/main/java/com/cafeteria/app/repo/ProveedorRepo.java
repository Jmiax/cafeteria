package com.cafeteria.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafeteria.app.model.Proveedor;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, Long> {
	Optional<Proveedor> findByUuid(UUID uuid);
	
	void deleteByUuid(UUID uuid);
}
