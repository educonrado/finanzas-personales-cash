package com.first.cash.servicio;

import java.util.List;

import com.first.cash.entidades.modelo.Cuenta;

public interface ICuentaServicio {

	public void guardar(Cuenta cuenta);
	public void eliminar(int codigo);
	public List<Cuenta> lista();
}
