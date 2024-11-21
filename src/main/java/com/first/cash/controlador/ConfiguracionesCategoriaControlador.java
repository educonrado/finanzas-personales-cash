package com.first.cash.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfiguracionesCategoriaControlador {
	
	@GetMapping("/configuraciones/categoria")
    public String obtenerConfiguracionCategoria(Model model) {
        return "configuracion/config-categoria";
    }
	
	@GetMapping("/configuraciones/formulario-categoria")
	public String obtenerFormularioCategoria(Model model) {
		return "configuracion/form-categoria";
	}
	
}
