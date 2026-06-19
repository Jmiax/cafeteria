package com.cafeteria.app.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafeteria.app.dto.ProductoDTO;
import com.cafeteria.app.enums.Estatus;
import com.cafeteria.app.service.ProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("rutaProductos")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@GetMapping("listar")
	public String metodoListar(Model model) {
		model.addAttribute("productos", productoService.listar()); 
		return "/carpetaProductos/paginaProductos";
	}
	
	@GetMapping("nuevo")
	public String metodoNuevo(Model model){
		model.addAttribute("estados",Estatus.values());
		model.addAttribute("producto",new ProductoDTO());
		return "/carpetaProductos/paginaFormulario";
	}
	
	@PostMapping("guardar")
	public String metodoGuardar(
	        @Valid @ModelAttribute("producto") ProductoDTO producto,
	        BindingResult result,
	        @RequestParam("archivo") MultipartFile archivo,
	        Model model) throws IOException {

	    if(result.hasErrors()) {
	        model.addAttribute("estados", Estatus.values());
	        return "/carpetaProductos/paginaFormulario";
	    }

	    if(!archivo.isEmpty()){

	        String nombreArchivo = archivo.getOriginalFilename();

	        Path ruta = Paths.get("src/main/resources/static/img/" + nombreArchivo);

	        Files.copy(
	                archivo.getInputStream(),
	                ruta,
	                StandardCopyOption.REPLACE_EXISTING);

	        producto.setImagen(nombreArchivo);
	    }

	    productoService.guardar(producto);

	    return "redirect:/rutaProductos/listar";
	}
	
	@GetMapping("editar/{uuid}")
	public String metodoEditar(Model model, @PathVariable UUID uuid) {
		model.addAttribute("estados",Estatus.values());
		model.addAttribute("producto",productoService.obtenerProductoUUID(uuid));
		return "/carpetaProductos/paginaFormulario";
	}
	
	@PostMapping("actualizar")
	public String metodoActualiza(
	        @Valid @ModelAttribute("producto") ProductoDTO producto,
	        BindingResult result,
	        @RequestParam("archivo") MultipartFile archivo,
	        Model model) throws IOException {

	    if(result.hasErrors()) {
	        model.addAttribute("estados", Estatus.values());
	        return "/carpetaProductos/paginaFormulario";
	    }

	    if(!archivo.isEmpty()){

	        String nombreArchivo = archivo.getOriginalFilename();

	        Path ruta = Paths.get("src/main/resources/static/img/" + nombreArchivo);

	        Files.copy(
	                archivo.getInputStream(),
	                ruta,
	                StandardCopyOption.REPLACE_EXISTING);

	        producto.setImagen(nombreArchivo);
	    }

	    productoService.actualiza(producto);

	    return "redirect:/rutaProductos/listar";
	}
	@GetMapping("eliminar/{uuid}")
	public String metodoElimina(@PathVariable UUID uuid) {
	    productoService.borrar(uuid);
	    return "redirect:/rutaProductos/listar";
	}
}
