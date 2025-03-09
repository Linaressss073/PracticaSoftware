package com.example.software.service;

import com.example.software.model.Administrador;
import com.example.software.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServicio {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    public Administrador getAdministradorById(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    public Administrador saveAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public void deleteAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}