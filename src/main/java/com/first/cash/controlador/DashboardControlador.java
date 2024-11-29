package com.first.cash.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.first.cash.servicio.ICuentaServicio;
import com.first.cash.servicio.ITransaccionServicio;

@Controller
public class DashboardControlador {

	@Autowired
	private ITransaccionServicio transaccionServicio;
	
	@Autowired
	private ICuentaServicio cuentaServicio;

	@GetMapping("/")
	public String obtenerDashboard(Model model) {
		model.addAttribute("transacciones",
				transaccionServicio.findAllByAnioMes(LocalDate.now().getYear(), LocalDate.now().getMonthValue()));
		model.addAttribute("mes", LocalDate.now());
		model.addAttribute("cuentas", cuentaServicio.lista());
		return "index";
	}
}
