package com.first.cash.entidades.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private double saldoInicial;
	private String color;
	
	public Cuenta() {
		
	}
	public Cuenta(String nombre, double saldoInicial, String color) {
		super();
		this.nombre = nombre;
		this.saldoInicial = saldoInicial;
		this.color = color;
	}

	@OneToMany(mappedBy = "cuenta")
	private List<Transaccion> transacciones;
}
