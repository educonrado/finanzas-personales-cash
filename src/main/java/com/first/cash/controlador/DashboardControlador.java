package com.first.cash.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardControlador {

    @GetMapping("/home")
    public String obtenerDashboard(Model model) {
        return "index";
    }
}
