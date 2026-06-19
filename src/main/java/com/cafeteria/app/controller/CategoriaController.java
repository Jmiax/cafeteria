package com.cafeteria.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafeteria.app.dto.CategoriaDTO;
import com.cafeteria.app.service.CategoriaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("rutaCategorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping("listar")
	public String metodoListar(Model model) {
		model.addAttribute("mensaje", "Listado de Categorías");
		model.addAttribute("categorias", categoriaService.listar());
		return "carpetaCategorias/paginaCategorias";
	}

	@GetMapping("nuevo")
	public String metodoNuevo(Model model) {
		model.addAttribute("categoria", new CategoriaDTO());
		return "carpetaCategorias/paginaFormulario";
	}

	@PostMapping("guardar")
	public String metodoGuarda(@Valid @ModelAttribute("categoria") CategoriaDTO catDto, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "carpetaCategorias/paginaFormulario";
		}
		categoriaService.guardar(catDto);
		return "redirect:/rutaCategorias/listar";
	}

	@PostMapping("actualizar")
	public String metodoActualiza(@Valid @ModelAttribute("categoria") CategoriaDTO catDto, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "carpetaCategorias/paginaFormulario";
		}
		categoriaService.actualiza(catDto);
		return "redirect:/rutaCategorias/listar";
	}

	@GetMapping("editar/{uuid}")
	public String metodoEditar(Model model, @PathVariable UUID uuid) {
		model.addAttribute("categoria", categoriaService.obtenerCategoriaUUID(uuid));
		return "carpetaCategorias/paginaFormulario";
	}

	@GetMapping("eliminar/{uuid}")
	public String metodoElimina(@PathVariable UUID uuid) {
		categoriaService.borrar2(uuid);
		return "redirect:/rutaCategorias/listar";
	}
}
