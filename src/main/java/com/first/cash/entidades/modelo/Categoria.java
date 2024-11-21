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
import lombok.Data;

	@Data
	@Entity
	public class Categoria implements Serializable {
	
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int codigo;
		private String nombre;
		@Enumerated(EnumType.STRING)
		private TipoEnum tipo;
		private String icono;
		
		public Categoria(String nombre, TipoEnum tipo, String icono) {
			super();
			this.nombre = nombre;
			this.tipo = tipo;
			this.icono = icono;
		}

		@OneToMany(mappedBy = "categoria")
		private List<Transaccion> transacciones;
	
	}
