package com.medkaapp.service.impl;

import com.medkaapp.dao.IPresionArterialDao;
import com.medkaapp.db.PresionArterial;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.service.IPresionArterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresionArterialServiceImpl implements IPresionArterialService {

    @Autowired
    IPresionArterialDao presionDao;

    @Override
    public List<PresionArterial> listarPresion() {
        return presionDao.findAll();
    }

    @Override
    public PresionArterial guardarPresion(PresionArterial presion) {
        return presionDao.save(presion);
    }

    @Override
    public PresionArterial presionId(Long id) {
        return presionDao.findById(id).get();
    }

    @Override
    public PresionArterial actualizarPresion(PresionArterial presion) {
        return presionDao.save(presion);
    }

    @Override
    public void eliminarPresion(Long id) {
        presionDao.deleteById(id);
    }

    @Override
    public List<PresionArterial> findByUser(Usuario id) {
        return presionDao.findByUser(id);
    }
}
