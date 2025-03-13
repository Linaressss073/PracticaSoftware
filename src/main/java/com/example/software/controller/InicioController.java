package com.example.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class InicioController {

    @GetMapping("/")
    public RedirectView redirectViewToHome(){
        return new RedirectView("/interfaces");
    }
}
