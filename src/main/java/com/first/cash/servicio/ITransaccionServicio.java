package com.first.cash.servicio;

import java.util.List;
import java.util.Optional;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;
import com.first.cash.entidades.to.TransaccionAnualTo;

public interface ITransaccionServicio {

	public void guardar(Transaccion transaccion);
	public void eliminar(int codigo);
	public List<Transaccion> findAllByAnioMes(int anio, int mes);
	public List<Transaccion> listaPorTipo(TipoEnum tipo);
	public Optional<Transaccion> finByCodigo(int codigo);
	public List<TransaccionAnualTo> agruparTransaccionesPoAnioYTipo(int anio, TipoEnum tipo);
}
