package com.example.demo.service;

import com.example.demo.Modelo.User;
import com.example.demo.repositorio.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositorio userRepositorio;

    public List<User> getAllUsuarios(){
        return userRepositorio.findAll();
    }

    public User saveUsuario(User user){
        return userRepositorio.save(user);
    }

}
