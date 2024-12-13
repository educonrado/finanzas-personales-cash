package com.first.cash.entidades.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private double saldo;
	private String color = generarColorAleatorio();

	public Cuenta() {

	}

	public Cuenta(String nombre, double saldo) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
	}

	private String generarColorAleatorio() {
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return String.format("#%02x%02x%02x", r, g, b);
	}

	@OneToMany(mappedBy = "cuenta")
	private List<Transaccion> transacciones;

	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", nombre=" + nombre + ", saldoInicial=" + saldo + ", color=" + color + "]";
	}

}
