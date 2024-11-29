package com.first.cash.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;
import com.first.cash.entidades.repositorio.ITransaccionRepositorio;
import com.first.cash.entidades.to.TransaccionAnualTo;
import com.first.cash.servicio.ITransaccionServicio;

@Service
public class TransaccionServicioImpl implements ITransaccionServicio {

	@Autowired
	private ITransaccionRepositorio transaccionRepositorio;
	@Override
	public void guardar(Transaccion transaccion) {
		transaccionRepositorio.save(transaccion);
	}

	@Override
	public void eliminar(int codigo) {
		transaccionRepositorio.deleteById(codigo);
	}

	@Override
	public List<Transaccion> findAllByAnioMes(int anio, int mes) {
		return transaccionRepositorio.findAllByAnioMes(anio, mes);
	}

	@Override
	public List<Transaccion> listaPorTipo(TipoEnum tipo) {
		return transaccionRepositorio.findAllByTipo(tipo);
	}

	@Override
	public Optional<Transaccion> finByCodigo(int codigo) {
		return transaccionRepositorio.findById(codigo);
	}

	@Override
	public List<TransaccionAnualTo> agruparTransaccionesPoAnioYTipo(int anio, TipoEnum tipo) {
		return transaccionRepositorio.agruparTransaccionesPoAnioYTipo(anio, tipo);
	}

}
