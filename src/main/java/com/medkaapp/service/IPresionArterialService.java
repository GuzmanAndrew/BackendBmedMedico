package com.medkaapp.service;

import com.medkaapp.db.PresionArterial;
import com.medkaapp.security.entity.Usuario;

import java.util.List;

public interface IPresionArterialService {

    public List<PresionArterial> listarPresion();

    public PresionArterial guardarPresion(PresionArterial presion);

    public PresionArterial presionId(Long id);

    public PresionArterial actualizarPresion(PresionArterial presion);

    public void eliminarPresion(Long id);

    public List<PresionArterial> findByUser(Usuario id);
}
