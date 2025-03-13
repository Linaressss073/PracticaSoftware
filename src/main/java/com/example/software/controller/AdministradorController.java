package com.example.software.controller;

import com.example.software.model.Administrador;
import com.example.software.service.AdministradorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorServicio administradorServicio;

    public AdministradorController(AdministradorServicio administradorServicio) {
        this.administradorServicio = administradorServicio;
    }

    @GetMapping
    public String listarAdministradores(Model model) {
        model.addAttribute("administradores", administradorServicio.getAllAdministradores());
        return "administradores/list";
    }

    @GetMapping("/new")
    public String showNewAdministrador(Model model) {
        model.addAttribute("administrador", new Administrador());
        return "administradores/newAdmin";
    }

    @PostMapping("/save")
    public String guardarAdministrador(@ModelAttribute("administrador") Administrador administrador,
                                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("administrador", administrador);
            return "administradores/newAdmin";
        }
        administradorServicio.saveAdministrador(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/edit/{id}")
    public String showEditAdministradorForm(@PathVariable Long id, Model model) {
        Administrador administrador = administradorServicio.getAdministradorById(id);
        if (administrador == null) {
            return "redirect:/administradores";
        }
        model.addAttribute("administrador", administrador);
        return "administradores/editAdmin";
    }

    @PostMapping("/update/{id}")
    public String actualizarAdministrador(@PathVariable Long id,
                                          @ModelAttribute("administrador") Administrador administrador,
                                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("administrador", administrador);
            return "administradores/editAdmin";
        }
        administradorServicio.updateAdministrador(id, administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/delete/{id}")
    public String eliminarAdministrador(@PathVariable Long id) {
        administradorServicio.deleteAdministrador(id);
        return "redirect:/administradores";
    }
}