package com.example.demo.repositorio;

import com.example.demo.Modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<User, Integer> {
}
