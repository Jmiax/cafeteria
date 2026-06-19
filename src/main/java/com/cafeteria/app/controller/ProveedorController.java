package com.cafeteria.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafeteria.app.dto.ProveedorDTO;
import com.cafeteria.app.service.ProveedorService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("rutaProveedores")
public class ProveedorController {

	@Autowired
	ProveedorService proveedorService;

	@GetMapping("listar")
	public String metodoListar(Model model) {
		model.addAttribute("mensaje", "Listado de Proveedores");
		model.addAttribute("proveedores", proveedorService.listar());
		return "carpetaProveedores/paginaProveedores";
	}

	@GetMapping("nuevo")
	public String metodoNuevo(Model model) {
		model.addAttribute("proveedor", new ProveedorDTO());
		return "carpetaProveedores/paginaFormulario";
	}

	@PostMapping("guardar")
	public String metodoGuarda(@Valid @ModelAttribute("proveedor") ProveedorDTO provDto, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "carpetaProveedores/paginaFormulario";
		}
		proveedorService.guardar(provDto);
		return "redirect:/rutaProveedores/listar";
	}

	@PostMapping("actualizar")
	public String metodoActualiza(@Valid @ModelAttribute("proveedor") ProveedorDTO provDto, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "carpetaProveedores/paginaFormulario";
		}
		proveedorService.actualiza(provDto);
		return "redirect:/rutaProveedores/listar";
	}

	@GetMapping("editar/{uuid}")
	public String metodoEditar(Model model, @PathVariable UUID uuid) {
		model.addAttribute("proveedor", proveedorService.obtenerProveedorUUID(uuid));
		return "carpetaProveedores/paginaFormulario";
	}

	@GetMapping("eliminar/{uuid}")
	public String metodoElimina(@PathVariable UUID uuid) {
		proveedorService.borrar2(uuid);
		return "redirect:/rutaProveedores/listar";
	}
}
