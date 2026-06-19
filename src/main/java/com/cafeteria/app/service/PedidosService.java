package com.cafeteria.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.app.model.Pedidos;
import com.cafeteria.app.repo.PedidosRepo;

@Service
public class PedidosService {

	@Autowired
    private PedidosRepo pedidosRepo;


    public List<Pedidos> listarPedidos() {
        return pedidosRepo.findAll();
    }
    

}
