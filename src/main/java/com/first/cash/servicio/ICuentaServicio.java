package com.first.cash.servicio;

import java.util.List;
import java.util.Optional;

import com.first.cash.entidades.modelo.Cuenta;

public interface ICuentaServicio {

	public void guardar(Cuenta cuenta);
	public void eliminar(int codigo);
	public List<Cuenta> lista();
	public long count();
	public void guardarTodo(List<Cuenta> cuentas);
	public Optional<Cuenta> findByCodigo(int codigo);
}
