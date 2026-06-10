package com.crud.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /** Redirige la raíz de la aplicación hacia el módulo de productos. */
    @GetMapping("/")
    public String home() {
        return "redirect:/productos";
    }
}
