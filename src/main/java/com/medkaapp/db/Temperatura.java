package com.medkaapp.db;

import com.medkaapp.security.entity.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="temperatura")
public class Temperatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    @Column(name = "hora")
    private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

    @Column(name = "temperatura")
    private int temperatura;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Usuario paciente;

    public Temperatura() {
    }

    public Temperatura(String fecha, String hora, int temperatura, Usuario paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.temperatura = temperatura;
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

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }
}
