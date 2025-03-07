package com.example.demo.Controlador;

import com.example.demo.Modelo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserControlador {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsuarios(){
        return userService.getAllUsuarios();
    }

    @PostMapping
    public User saveUsuario(@RequestBody User user){
        return userService.saveUsuario(user);
    }
}
