package com.first.cash.entidades.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;
	private String icono = "icon-flag";

	public Categoria(String nombre, TipoEnum tipo, String icono) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.icono = icono;
	}

	public Categoria() {
		super();
	}

	@OneToMany(mappedBy = "categoria")
	private List<Transaccion> transacciones;

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", icono=" + icono + "]";
	}

}
