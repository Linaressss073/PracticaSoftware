package com.example.software.controller;

import com.example.software.model.Usuario;
import com.example.software.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario()); // Envía un objeto Usuario vacío a la vista
        return "registro"; // Devuelve la vista registro.html
    }

    // Procesar formulario de registro
    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario) {
        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
        return "redirect:/login"; // Redirigir al login después del registro
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Devuelve la vista login.html
    }

    // Procesar formulario de login
    @PostMapping("/login")
    public String iniciarSesion(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        // Buscar usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Verificar credenciales
        if (usuario != null && usuario.getPassword().equals(password)) {
            return "redirect:/dashboard"; // Redirigir al dashboard si las credenciales son correctas
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos"); // Mostrar mensaje de error
            return "login"; // Volver a la página de login
        }
    }

    // Mostrar dashboard
    @GetMapping("/dashboard")
    public String mostrarDashboard() {
        return "dashboard"; // Devuelve la vista dashboard.html
    }

    // Mostrar logout
    @GetMapping("/logout")
    public String mostrarlogout() {
        return "logout"; // Devuelve la vista logout.html
    }
}