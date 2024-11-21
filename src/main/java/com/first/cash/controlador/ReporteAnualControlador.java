package com.first.cash.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteAnualControlador {

	@GetMapping("reportes/reporte-anual")
    public String obtenerReporteAnual(Model model) {
        return "reportes/reporte-anual";
    }
	
	@GetMapping("reportes/reporte-categoria")
    public String obtenerReporteCategoria(Model model) {
		 return "reportes/reporte-categoria";
    }
}
