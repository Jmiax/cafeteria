package com.cafeteria.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cafeteria.app.dto.TamanioDTO;
import com.cafeteria.app.service.TamanioService;

import jakarta.validation.Valid;

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
    public String guardar(@Valid @ModelAttribute("tamanio") TamanioDTO tamanio,
                          BindingResult result,
                          Model model) {

        if (result.hasErrors()) {
            return "carpetaTamanios/paginaFormularioTamanio";
        }

        tamanioService.guardar(tamanio);
        return "redirect:/tamanios/listar";
    }

    @GetMapping("/editar/{uuid}")
    public String editar(@PathVariable UUID uuid, Model model) {
        model.addAttribute("tamanio", tamanioService.obtenerTamanioUUID(uuid));
        return "carpetaTamanios/paginaFormularioTamanio";
    }

    @PostMapping("/actualizar")
    public String actualizar(@Valid @ModelAttribute("tamanio") TamanioDTO tamanio,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            return "carpetaTamanios/paginaFormularioTamanio";
        }

        tamanioService.actualiza(tamanio);
        return "redirect:/tamanios/listar";
    }

    @GetMapping("/eliminar/{uuid}")
    public String eliminar(@PathVariable UUID uuid) {
        tamanioService.borrar(uuid);
        return "redirect:/tamanios/listar";
    }
}