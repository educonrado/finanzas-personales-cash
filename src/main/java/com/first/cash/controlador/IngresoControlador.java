package com.first.cash.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngresoControlador {

	@GetMapping("transacciones/ingresos")
    public String obtenerIngreso(Model model) {
        return "transacciones/ingresos";
    }
	
	@GetMapping("transacciones/formulario-ingreso")
    public String obtenerFormularioIngreso(Model model) {
        return "transacciones/form-ingresos";
    }
}
