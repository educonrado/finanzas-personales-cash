package com.first.cash.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.first.cash.entidades.modelo.Categoria;
import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.servicio.ICategoriaServicio;

@Controller
public class ConfiguracionesCategoriaControlador {
	
	@Autowired
	private ICategoriaServicio categoriaServicio;
	
	@GetMapping("/configuraciones/categoria")
    public String obtenerConfiguracionCategoria(Model model) {
		List<Categoria> categoriaIngresos = categoriaServicio.listaPorTipo(TipoEnum.INGRESO);
		List<Categoria> categoriaGastos = categoriaServicio.listaPorTipo(TipoEnum.GASTO);
		model.addAttribute("categoriaIngresos", categoriaIngresos);
		model.addAttribute("categoriaGastos", categoriaGastos);
        return "configuracion/config-categoria";
    }
	
	@GetMapping("/configuraciones/formulario-categoria")
	public String obtenerFormularioCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("tipoCategoria", TipoEnum.values());
		return "configuracion/form-categoria";
	}
	
	@PostMapping("/configuraciones/formulario-categoria/guardar")
	public String guardarCategoria(@ModelAttribute Categoria categoria) {
		categoriaServicio.guardar(categoria);
		return "redirect:/configuraciones/categoria";
		
	}
	
	@GetMapping("/configuraciones/formulario-categoria/editar/{codigo}")
	public String editarCategoria(@PathVariable int codigo, Model model) {
		model.addAttribute("tipoCategoria", TipoEnum.values());
		model.addAttribute("categoria", categoriaServicio.findByCodigo(codigo));
		return "configuracion/form-categoria";
	}
	
	@GetMapping("/configuraciones/eliminar/{codigo}")
	public String editarCategoria(@PathVariable int codigo) {
		categoriaServicio.eliminar(codigo);
		return "redirect:/configuraciones/categoria";
	}
	
}
