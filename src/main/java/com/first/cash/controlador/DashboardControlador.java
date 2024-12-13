package com.first.cash.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.to.TransaccionAnualTo;
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
		cargarInformacionDashboard(model);
		return "index";
	}
	
	@Async
	private Model cargarInformacionDashboard(Model model) {
		List<TransaccionAnualTo> ingresosAnualesMensual = transaccionServicio.agruparTransaccionesPoAnioYTipo(2024, TipoEnum.INGRESO);
		List<TransaccionAnualTo> gastosAnualesMensual = transaccionServicio.agruparTransaccionesPoAnioYTipo(2024, TipoEnum.GASTO);
		System.out.println("--->"+ingresosAnualesMensual.size());
		model.addAttribute("ingresosAnualesMensual", ingresosAnualesMensual);
		model.addAttribute("gastosAnualesMensual", gastosAnualesMensual);
		return model;
	}
}
