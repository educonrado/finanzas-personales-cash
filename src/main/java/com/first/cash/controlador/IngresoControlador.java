package com.first.cash.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;
import com.first.cash.servicio.ICategoriaServicio;
import com.first.cash.servicio.ICuentaServicio;
import com.first.cash.servicio.ITransaccionServicio;

@Controller
public class IngresoControlador {

	@Autowired
	private ITransaccionServicio transaccionServicio;
	
	@Autowired
	private ICategoriaServicio categoriaServicio;
	
	@Autowired
	private ICuentaServicio cuentaServicio;
	
	@GetMapping("/transacciones/ingresos")
    public String obtenerIngreso(Model model) {
		model.addAttribute("ingresos", transaccionServicio.listaPorTipo(TipoEnum.INGRESO));
        return "transacciones/ingresos";
    }
	
	@GetMapping("/transacciones/formulario-ingreso")
    public String obtenerFormularioIngreso(Model model) {
		model.addAttribute("ingreso", new Transaccion());
		model.addAttribute("categorias", categoriaServicio.listaPorTipo(TipoEnum.INGRESO));
		model.addAttribute("cuentas", cuentaServicio.lista());
        return "transacciones/form-ingresos";
    }
	
	@PostMapping("/transacciones/formulario-ingreso/guardar")
	public String guardarTransaccion(@ModelAttribute Transaccion transaccion) {
		transaccionServicio.guardar(transaccion);
		return "redirect:/transacciones/ingresos";
	}
	
	@GetMapping("/transacciones/formulario-ingreso/editar/{codigo}")
    public String obtenerFormularioIngreso(@PathVariable int codigo, Model model) {
		model.addAttribute("ingreso", transaccionServicio.finByCodigo(codigo));
		model.addAttribute("categorias", categoriaServicio.listaPorTipo(TipoEnum.INGRESO));
		model.addAttribute("cuentas", cuentaServicio.lista());
        return "transacciones/form-ingresos";
    }
	
}
