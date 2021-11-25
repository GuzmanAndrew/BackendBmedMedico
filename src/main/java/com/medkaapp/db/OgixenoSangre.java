package com.medkaapp.db;

import com.medkaapp.security.entity.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="oxigeno_sangre")
public class OgixenoSangre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    @Column(name = "hora")
    private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

    @Column(name = "oxigeno")
    private int oxigeno;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Usuario paciente;

    public OgixenoSangre() {
    }

    public OgixenoSangre(String fecha, String hora, int oxigeno, Usuario paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.oxigeno = oxigeno;
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

    public int getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(int oxigeno) {
        this.oxigeno = oxigeno;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }
}
