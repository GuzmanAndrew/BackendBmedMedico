package com.medkaapp.service;

import com.medkaapp.db.FrecuenciaCardiaca;
import com.medkaapp.security.entity.Usuario;

import java.util.List;

public interface IFrecuenciaCardiacaService {
    public List<FrecuenciaCardiaca> listarFrecuenciaCardiaca();

    public FrecuenciaCardiaca guardarFrecuenciaCardiaca(FrecuenciaCardiaca presion);

    public FrecuenciaCardiaca frecuenciaCardiacaId(Long id);

    public FrecuenciaCardiaca actualizarFrecuenciaCardiaca(FrecuenciaCardiaca presion);

    public void eliminarFrecuenciaCardiaca(Long id);

    public List<FrecuenciaCardiaca> findByUser(Usuario id);
}
