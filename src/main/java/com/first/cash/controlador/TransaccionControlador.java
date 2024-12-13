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
import com.first.cash.servicio.ICalculoSaldoServicio;
import com.first.cash.servicio.ICategoriaServicio;
import com.first.cash.servicio.ICuentaServicio;
import com.first.cash.servicio.ITransaccionServicio;

@Controller
public class TransaccionControlador {

	@Autowired
	private ITransaccionServicio transaccionServicio;

	@Autowired
	private ICategoriaServicio categoriaServicio;

	@Autowired
	private ICuentaServicio cuentaServicio;

	@Autowired
	private ICalculoSaldoServicio calculoSaldoServicio;

	@GetMapping("/transacciones/ingresos")
	public String obtenerIngreso(Model model) {
		model.addAttribute("ingresos", transaccionServicio.listaPorTipo(TipoEnum.INGRESO));
		return "transacciones/ingresos";
	}

	@GetMapping("transacciones/gastos")
	public String obtenerGastos(Model model) {
		model.addAttribute("gastos", transaccionServicio.listaPorTipo(TipoEnum.GASTO));
		return "transacciones/gastos";
	}

	@GetMapping("/transacciones/formulario-ingreso")
	public String obtenerFormularioIngreso(Model model) {
		model.addAttribute("ingreso", new Transaccion());
		model.addAttribute("categorias", categoriaServicio.listaPorTipo(TipoEnum.INGRESO));
		model.addAttribute("cuentas", cuentaServicio.lista());
		return "transacciones/form-ingresos";
	}

	@GetMapping("transacciones/formulario-gasto")
	public String obtenerFormularioGasto(Model model) {
		model.addAttribute("gasto", new Transaccion());
		model.addAttribute("categorias", categoriaServicio.listaPorTipo(TipoEnum.GASTO));
		model.addAttribute("cuentas", cuentaServicio.lista());
		return "transacciones/form-gastos";
	}

	/**
	 * Guarda ingreso y gastos
	 * 
	 * @param transaccion
	 * @return
	 */
	@PostMapping("/transacciones/formulario/guardar")
	public String guardarTransaccion(@ModelAttribute Transaccion transaccion) {
		transaccionServicio.guardar(transaccion);
		if (TipoEnum.INGRESO.equals(transaccion.getCategoria().getTipo())) {
			calculoSaldoServicio.depositar(transaccion.getCuenta(), transaccion.getValor());
			return "redirect:/transacciones/ingresos";
		} else {
			calculoSaldoServicio.retirar(transaccion.getCuenta(), transaccion.getValor());
			return "redirect:/transacciones/gastos";
		}
	}

	@GetMapping("/transacciones/formulario-ingreso/editar/{codigo}")
	public String obtenerFormularioIngreso(@PathVariable int codigo, Model model) {
		model.addAttribute("ingreso", transaccionServicio.finByCodigo(codigo));
		model.addAttribute("categorias", categoriaServicio.listaPorTipo(TipoEnum.INGRESO));
		model.addAttribute("cuentas", cuentaServicio.lista());
		return "transacciones/form-ingresos";
	}

	@GetMapping("/transacciones/formulario-gasto/editar/{codigo}")
	public String obtenerFormularioGasto(@PathVariable int codigo, Model model) {
		model.addAttribute("gasto", transaccionServicio.finByCodigo(codigo));
		model.addAttribute("categorias", categoriaServicio.listaPorTipo(TipoEnum.GASTO));
		model.addAttribute("cuentas", cuentaServicio.lista());
		return "transacciones/form-gastos";
	}

	/**
	 * Elimina ingresos y gastos
	 * 
	 * @param codigo
	 * @return
	 */
	@GetMapping("/transacciones/eliminar/{codigo}")
	public String eliminarTransaccion(@PathVariable int codigo) {
		Transaccion transaccion = transaccionServicio.finByCodigo(codigo).get();
		calculoSaldoServicio.retirar(transaccion.getCuenta(), transaccion.getValor());
		transaccionServicio.eliminar(codigo);
		return "redirect:/transacciones/ingresos";
	}

}
