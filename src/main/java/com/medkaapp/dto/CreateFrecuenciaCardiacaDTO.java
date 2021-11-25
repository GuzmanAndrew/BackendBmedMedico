package com.medkaapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
@Setter
public class CreateFrecuenciaCardiacaDTO {

    private String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm", Locale.US));

    private String frecuencia;

    private int pacienteId;
}
