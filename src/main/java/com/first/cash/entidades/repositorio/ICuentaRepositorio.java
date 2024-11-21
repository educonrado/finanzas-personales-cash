package com.first.cash.entidades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.cash.entidades.modelo.Cuenta;

@Repository
public interface ICuentaRepositorio extends JpaRepository<Cuenta, Integer>{

}
