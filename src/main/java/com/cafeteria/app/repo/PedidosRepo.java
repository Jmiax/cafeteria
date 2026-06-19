package com.cafeteria.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.app.model.Pedidos;

public interface PedidosRepo extends JpaRepository<Pedidos, Long>{

}
