package com.first.cash.entidades.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TransaccionAnualTo {

	private int mes;
	private double valor;
}
