package com.first.cash.entidades.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.modelo.Transaccion;

@Repository
public interface ITransaccionRepositorio extends JpaRepository<Transaccion, Integer>{

	@Query("select t from Transaccion t where t.fecha = ?1")
	public List<Transaccion> findAllByMes(int mes);
	@Query("select t from Transaccion t where t.categoria.tipo = ?1")
	public List<Transaccion> findAllByTipo(TipoEnum tipo);
}
