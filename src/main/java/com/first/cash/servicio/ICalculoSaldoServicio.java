package com.first.cash.servicio;

import com.first.cash.entidades.modelo.Cuenta;

public interface ICalculoSaldoServicio {
	
	void depositar(Cuenta cuenta, double valorDeposito);
	void retirar(Cuenta cuenta, double valorRetiro);

}
