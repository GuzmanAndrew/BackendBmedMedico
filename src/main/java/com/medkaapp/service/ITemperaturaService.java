package com.medkaapp.service;

import com.medkaapp.db.Temperatura;
import com.medkaapp.security.entity.Usuario;

import java.util.List;

public interface ITemperaturaService {
    public List<Temperatura> listarTemperatura();

    public Temperatura guardarTemperatura(Temperatura presion);

    public Temperatura temperaturaId(Long id);

    public Temperatura actualizarTemperatura(Temperatura presion);

    public void eliminarTemperatura(Long id);

    public List<Temperatura> findByUser(Usuario id);
}
