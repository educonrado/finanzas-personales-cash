package com.first.cash.entidades.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;
import com.first.cash.entidades.to.TransaccionAnualTo;

@Repository
public interface ITransaccionRepositorio extends JpaRepository<Transaccion, Integer> {

	@Query("select t from Transaccion t where YEAR(t.fecha) = ?1 and MONTH(t.fecha) = ?2")
	public List<Transaccion> findAllByAnioMes(int anio, int mes);

	@Query("select t from Transaccion t where t.categoria.tipo = ?1 order by t.fecha desc")
	public List<Transaccion> findAllByTipo(TipoEnum tipo);

	@Query("select new com.first.cash.entidades.to.TransaccionAnualTo(MONTH(t.fecha), sum(t.valor)) "
			+ "from Transaccion t where YEAR(t.fecha) = ?1 and t.categoria.tipo = ?2 group by MONTH(t.fecha) ")
	public List<TransaccionAnualTo> agruparTransaccionesPoAnioYTipo(int anio, TipoEnum tipo);
}
