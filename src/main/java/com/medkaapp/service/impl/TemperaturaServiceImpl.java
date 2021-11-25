package com.medkaapp.service.impl;

import com.medkaapp.dao.ITemperaturaDao;
import com.medkaapp.db.Temperatura;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.service.ITemperaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperaturaServiceImpl implements ITemperaturaService {

    @Autowired
    private ITemperaturaDao iTemperaturaDao;

    @Override
    public List<Temperatura> listarTemperatura() {
        return iTemperaturaDao.findAll();
    }

    @Override
    public Temperatura guardarTemperatura(Temperatura presion) {
        return iTemperaturaDao.save(presion);
    }

    @Override
    public Temperatura temperaturaId(Long id) {
        return iTemperaturaDao.findById(id).get();
    }

    @Override
    public Temperatura actualizarTemperatura(Temperatura presion) {
        return iTemperaturaDao.save(presion);
    }

    @Override
    public void eliminarTemperatura(Long id) {
        iTemperaturaDao.deleteById(id);
    }

    @Override
    public List<Temperatura> findByUser(Usuario id) {
        return iTemperaturaDao.findByUser(id);
    }
}
