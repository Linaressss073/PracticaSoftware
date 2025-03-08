package com.example.software.service;

import com.example.software.model.Usuario;
import com.example.software.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar un usuario
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar un usuario por email
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}