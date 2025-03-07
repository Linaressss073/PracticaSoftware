package com.example.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuarios") //Nombre la tabla en la db

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 50)
    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;
}
