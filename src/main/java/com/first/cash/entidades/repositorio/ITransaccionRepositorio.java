package com.first.cash.entidades.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;

@Repository
public interface ITransaccionRepositorio extends JpaRepository<Transaccion, Integer>{

	@Query("select t from Transaccion t where YEAR(t.fecha) = ?1 and MONTH(t.fecha) = ?2")
	public List<Transaccion> findAllByAnioMes(int anio, int mes);
	@Query("select t from Transaccion t where t.categoria.tipo = ?1 order by t.fecha desc")
	public List<Transaccion> findAllByTipo(TipoEnum tipo);
}
