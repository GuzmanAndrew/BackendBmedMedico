package com.medkaapp.db;

import com.medkaapp.security.entity.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="presion_arterial")
public class PresionArterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    @Column(name = "hora")
    private String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

    @Column(name = "sistolica")
    private String sistolica;

    @Column(name = "diastolica")
    private String diastolica;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Usuario paciente;

    public PresionArterial() {
    }

    public PresionArterial(String fecha, String hora, String sistolica, String diastolica, Usuario paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.sistolica = sistolica;
        this.diastolica = diastolica;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSistolica() {
        return sistolica;
    }

    public void setSistolica(String sistolica) {
        this.sistolica = sistolica;
    }

    public String getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(String diastolica) {
        this.diastolica = diastolica;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }
}
