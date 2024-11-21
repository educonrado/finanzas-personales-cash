package com.first.cash.entidades.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.cash.entidades.modelo.Categoria;
import com.first.cash.entidades.modelo.TipoEnum;

@Repository
public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer>{

	public List<Categoria> findAllByTipo(TipoEnum tipo);
}
