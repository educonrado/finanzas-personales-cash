package com.first.cash.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.cash.entidades.modelo.Cuenta;
import com.first.cash.entidades.repositorio.ICuentaRepositorio;
import com.first.cash.servicio.ICuentaServicio;

@Service
public class CuentaServicioImpl implements ICuentaServicio {

	@Autowired
	private ICuentaRepositorio cuentaRepositorio;

	@Override
	public void guardar(Cuenta cuenta) {
		cuentaRepositorio.save(cuenta);
	}

	@Override
	public void eliminar(int codigo) {
		cuentaRepositorio.deleteById(codigo);
	}

	@Override
	public List<Cuenta> lista() {
		return cuentaRepositorio.findAll();
	}

	@Override
	public long count() {
		return cuentaRepositorio.count();
	}

	@Override
	public void guardarTodo(List<Cuenta> cuentas) {
		cuentaRepositorio.saveAll(cuentas);
	}

	@Override
	public Optional<Cuenta> findByCodigo(int codigo) {
		return cuentaRepositorio.findById(codigo);
	}

}
