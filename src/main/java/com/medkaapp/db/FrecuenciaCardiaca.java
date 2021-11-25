package com.medkaapp.db;

import com.medkaapp.security.entity.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="frecuencia_cardiaca")
public class FrecuenciaCardiaca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    @Column(name = "hora")
    private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

    @Column(name = "frecuencia")
    private String frecuencia;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Usuario paciente;

    public FrecuenciaCardiaca() {
    }

    public FrecuenciaCardiaca(String fecha, String hora, String frecuencia, Usuario paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.frecuencia = frecuencia;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }
}
