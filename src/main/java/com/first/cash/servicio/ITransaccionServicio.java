package com.first.cash.servicio;

import java.util.List;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;

public interface ITransaccionServicio {

	public void guardar(Transaccion transaccion);
	public void eliminar(int codigo);
	public List<Transaccion> listaPorMes(int mes);
	public List<Transaccion> listaPorTipo(TipoEnum tipo);
}
