package com.first.cash.configuracion;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.first.cash.entidades.modelo.Categoria;
import com.first.cash.entidades.modelo.Cuenta;
import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.servicio.ICategoriaServicio;
import com.first.cash.servicio.ICuentaServicio;

@Component
public class DataInicializador implements CommandLineRunner {

	@Autowired
	private ICuentaServicio cuentaServicio;
	@Autowired
	private ICategoriaServicio categoriaServicio;

	@Override
	public void run(String... args) throws Exception {
		if (cuentaServicio.count() == 0) {
			crearCuentasIniciales();
		}
		if (categoriaServicio.count() == 0) {
			crearCategoriasIniciales();
		}

	}

	private void crearCuentasIniciales() {
		List<Cuenta> cuentas = Arrays.asList(
				new Cuenta("Efectivo", 0),
				new Cuenta("Cuenta de Ahorros", 0)
				);
		cuentaServicio.guardarTodo(cuentas);
	}

	private void crearCategoriasIniciales() {
		List<Categoria> categorias = Arrays.asList(
				new Categoria("Ahorro", TipoEnum.GASTO, "icon-wallet"),
				new Categoria("Alimentacion", TipoEnum.GASTO, "icon-cup"),
				new Categoria("Contribucion", TipoEnum.GASTO, "icon-heart"),
				new Categoria("Costos bancarios", TipoEnum.GASTO, "icon-information"),
				new Categoria("Cursos", TipoEnum.GASTO, "icon-flag"),
				new Categoria("Educacion", TipoEnum.GASTO, "icon-calendar"),
				new Categoria("Fondo de inversion", TipoEnum.GASTO, "icon-magnet"),
				new Categoria("Gastos personales", TipoEnum.GASTO, "icon-energy"),
				new Categoria("Inversiones", TipoEnum.GASTO, "icon-target"),
				new Categoria("Otros", TipoEnum.GASTO, "icon-direction"),
				new Categoria("Prestamo", TipoEnum.GASTO, "icon-chart"),
				new Categoria("Regalos", TipoEnum.GASTO, "icon-present"),
				new Categoria("Salud", TipoEnum.GASTO, "icon-chemistry"),
				new Categoria("Tarjeta de credito", TipoEnum.GASTO, "icon-credit-card"),
				new Categoria("Transporte", TipoEnum.GASTO, "icon-rocket"),
				new Categoria("Vestimenta", TipoEnum.GASTO, "icon-star"),
				new Categoria("Vivienda", TipoEnum.GASTO, "icon-home"),

				new Categoria("Arriendos", TipoEnum.INGRESO, "icon-frame"),
				new Categoria("Bonos", TipoEnum.INGRESO, "icon-share-alt"),
				new Categoria("Cobro de prestamos", TipoEnum.INGRESO, "icon-pie-chart"),
				new Categoria("Comisiones", TipoEnum.INGRESO, "icon-size-fullscreen"),
				new Categoria("Fondos de reserva", TipoEnum.INGRESO, "icon-size-actual"),
				new Categoria("Interes", TipoEnum.INGRESO, "icon-shuffle"),
				new Categoria("Prestamos", TipoEnum.INGRESO, "icon-support"),
				new Categoria("Regalos", TipoEnum.INGRESO, "icon-grid"),
				new Categoria("Sueldos", TipoEnum.INGRESO, "icon-loop"),
				new Categoria("Ventas", TipoEnum.INGRESO, "icon-graph"),
				new Categoria("Encargos", TipoEnum.INGRESO, "icon-bulb")				
				);
		categoriaServicio.guardarTodo(categorias);
	}

}
