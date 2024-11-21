package com.first.cash.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GastosControlador {

	@GetMapping("transacciones/gastos")
    public String obtenerIngreso(Model model) {
        return "transacciones/gastos";
    }
	
	@GetMapping("transacciones/formulario-gasto")
    public String obtenerFormularioIngreso(Model model) {
        return "transacciones/form-gastos";
    }
}
