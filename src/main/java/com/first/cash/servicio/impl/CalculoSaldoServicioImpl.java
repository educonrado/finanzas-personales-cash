package com.first.cash.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.cash.entidades.modelo.Cuenta;
import com.first.cash.servicio.ICalculoSaldoServicio;
import com.first.cash.servicio.ICuentaServicio;

@Service
public class CalculoSaldoServicioImpl implements ICalculoSaldoServicio {

	@Autowired
	private ICuentaServicio cuentaServicio;

	@Override
	public void depositar(Cuenta cuenta, double valorDeposito) {
		cuenta.setSaldo(Double.sum(cuenta.getSaldo(), valorDeposito));
		cuentaServicio.guardar(cuenta);
	}

	@Override
	public void retirar(Cuenta cuenta, double valorRetiro) {
		cuenta.setSaldo(cuenta.getSaldo() - valorRetiro);
		cuentaServicio.guardar(cuenta);
	}

}
