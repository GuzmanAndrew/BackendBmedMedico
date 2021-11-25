package com.medkaapp.service.impl;

import com.medkaapp.dao.IFrecuenciaCardiacaDao;
import com.medkaapp.db.FrecuenciaCardiaca;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.service.IFrecuenciaCardiacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrecuenciaCardiacaServiceImpl implements IFrecuenciaCardiacaService {

    @Autowired
    private IFrecuenciaCardiacaDao iFrecuenciaCardiacaDao;

    @Override
    public List<FrecuenciaCardiaca> listarFrecuenciaCardiaca() {
        return iFrecuenciaCardiacaDao.findAll();
    }

    @Override
    public FrecuenciaCardiaca guardarFrecuenciaCardiaca(FrecuenciaCardiaca presion) {
        return iFrecuenciaCardiacaDao.save(presion);
    }

    @Override
    public FrecuenciaCardiaca frecuenciaCardiacaId(Long id) {
        return iFrecuenciaCardiacaDao.findById(id).get();
    }

    @Override
    public FrecuenciaCardiaca actualizarFrecuenciaCardiaca(FrecuenciaCardiaca presion) {
        return iFrecuenciaCardiacaDao.save(presion);
    }

    @Override
    public void eliminarFrecuenciaCardiaca(Long id) {
        iFrecuenciaCardiacaDao.deleteById(id);
    }

    @Override
    public List<FrecuenciaCardiaca> findByUser(Usuario id) {
        return iFrecuenciaCardiacaDao.findByUser(id);
    }
}
