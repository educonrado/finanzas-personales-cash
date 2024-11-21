package com.first.cash.entidades.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transaccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private LocalDate fecha;
	private float valor;
	private String detalles;
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "codigo_cuenta")
	private Cuenta cuenta;
	
}
