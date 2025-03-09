package com.example.software.controller;
//Admin controller
import com.example.software.model.Administrador;
import com.example.software.service.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorServicio administradorServicio;

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

    @PostMapping
    public String guardarAdministrador(@ModelAttribute("administrador") Administrador administrador) {
        administradorServicio.saveAdministrador(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/edit/{id}")
    public String showEditAdministradorForm(@PathVariable Long id, Model model) {
        Administrador administrador = administradorServicio.getAdministradorById(id);
        model.addAttribute("administrador", administrador);
        return "administradores/editAdmin";
    }

    @PostMapping("/update/{id}")
    public String updateAdministrador(@PathVariable Long id, @ModelAttribute("administrador") Administrador administrador) {
        administrador.setId(id);
        administradorServicio.saveAdministrador(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdministrador(@PathVariable Long id) {
        administradorServicio.deleteAdministrador(id);
        return "redirect:/administradores";
    }
}