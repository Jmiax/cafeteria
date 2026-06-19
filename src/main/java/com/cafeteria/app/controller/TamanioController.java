package com.cafeteria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cafeteria.app.dto.TamanioDTO;
import com.cafeteria.app.service.TamanioService;

@Controller
@RequestMapping("/tamanios")
public class TamanioController {

    @Autowired
    private TamanioService tamanioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("tamanios", tamanioService.listar());
        return "carpetaTamanios/paginaTamanios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("tamanio", new TamanioDTO());
        return "carpetaTamanios/paginaFormularioTamanio";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("tamanio") TamanioDTO tamanioDTO) {
        tamanioService.guardar(tamanioDTO);
        return "redirect:/tamanios/listar";
    }
}