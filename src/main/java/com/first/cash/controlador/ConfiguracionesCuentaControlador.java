package com.first.cash.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.first.cash.entidades.modelo.Cuenta;
import com.first.cash.servicio.ICuentaServicio;

@Controller
public class ConfiguracionesCuentaControlador {

	@Autowired
	private ICuentaServicio cuentaServicio;
	
	@GetMapping("/configuraciones/cuentas")
    public String obtenerConfiguracionCuenta(Model model) {
		model.addAttribute("cuentas", cuentaServicio.lista());
        return "configuracion/config-cuenta";
    }
	
	@GetMapping("/configuraciones/formulario-cuenta")
	public String obtenerFormularioCuenta(Model model) {
		model.addAttribute("nuevaCuenta", new Cuenta());
		return "configuracion/form-cuenta";
	}
	
	@PostMapping("/configuraciones/cuenta/guardar")
	public String guardarCuenta(@ModelAttribute Cuenta nuevaCuenta) {
		cuentaServicio.guardar(nuevaCuenta);
        return "redirect:/configuraciones/cuentas";
	}
	
	@GetMapping("/configuraciones/cuenta/editar/{codigo}")
	public String editarCuenta(@PathVariable int codigo, Model model) {
		model.addAttribute("nuevaCuenta", cuentaServicio.findByCodigo(codigo));
		return "configuracion/form-cuenta";
	}
	
	@GetMapping("/configuraciones/cuenta/eliminar/{codigo}")
	public String eliminarcuenta(@PathVariable int codigo) {
		cuentaServicio.eliminar(codigo);
		return "redirect:/configuraciones/cuentas";
	}
	
}
