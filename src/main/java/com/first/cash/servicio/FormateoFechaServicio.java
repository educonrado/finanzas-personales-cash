package com.first.cash.servicio;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class FormateoFechaServicio {

	public String format(LocalDate fecha, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return fecha.format(formatter);
	}
	
	public String formatMes(LocalDate fecha) {
		Month mes = fecha.getMonth();
		return mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
	}
}
