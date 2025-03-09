package com.example.software.repository;

import com.example.software.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}