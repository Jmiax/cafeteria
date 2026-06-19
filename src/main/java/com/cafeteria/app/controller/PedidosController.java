package com.cafeteria.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.app.model.Pedidos;
import com.cafeteria.app.service.PedidosService;

@RestController
@RequestMapping("Pedidos")
public class PedidosController {

	@Autowired
    private PedidosService pedidosService;

	 @GetMapping
	    public List<Pedidos> listarPedidos() {
	        return pedidosService.listarPedidos();
	    }  
	 
	 @GetMapping("/pedidos")
	    public String pedidos() {
	        return "pedidos";
	    }
}
