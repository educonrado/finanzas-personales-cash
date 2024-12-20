package com.first.cash.servicio;

import java.util.List;
import java.util.Optional;

import com.first.cash.entidades.modelo.Categoria;
import com.first.cash.entidades.modelo.TipoEnum;

public interface ICategoriaServicio {

	public void guardar(Categoria categoria);
	public void eliminar(int codigo);
	public List<Categoria> listaPorTipo(TipoEnum tipo);
	public List<Categoria> lista();
	public long count();
	public void guardarTodo(List<Categoria> categorias);
	public Optional<Categoria> findByCodigo(int codigo);
}
