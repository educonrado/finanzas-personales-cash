package com.first.cash.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.cash.entidades.modelo.Categoria;
import com.first.cash.entidades.modelo.TipoEnum;
import com.first.cash.entidades.repositorio.ICategoriaRepositorio;
import com.first.cash.servicio.ICategoriaServicio;

@Service
public class CategoriaServicioImpl implements ICategoriaServicio {

	@Autowired
	private ICategoriaRepositorio categoriaRepositorio;
	@Override
	public void guardar(Categoria categoria) {
		categoriaRepositorio.save(categoria);
	}

	@Override
	public void eliminar(int codigo) {
		categoriaRepositorio.deleteById(codigo);
	}

	@Override
	public List<Categoria> listaPorTipo(TipoEnum tipo) {
		return categoriaRepositorio.findAllByTipo(tipo);
	}

	@Override
	public List<Categoria> lista() {
		return categoriaRepositorio.findAll();
	}

}
