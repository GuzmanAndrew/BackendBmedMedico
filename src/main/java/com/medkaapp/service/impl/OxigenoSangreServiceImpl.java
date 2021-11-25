package com.medkaapp.service.impl;

import com.medkaapp.dao.IOxigenoSangreDao;
import com.medkaapp.db.OgixenoSangre;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.service.IOxigenoSangreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OxigenoSangreServiceImpl implements IOxigenoSangreService {

    @Autowired
    private IOxigenoSangreDao iOxigenoSangreDao;

    @Override
    public List<OgixenoSangre> listarOxigenoSangre() {
        return iOxigenoSangreDao.findAll();
    }

    @Override
    public OgixenoSangre guardarOxigenoSangre(OgixenoSangre presion) {
        return iOxigenoSangreDao.save(presion);
    }

    @Override
    public OgixenoSangre oxigenoSangreId(Long id) {
        return iOxigenoSangreDao.findById(id).get();
    }

    @Override
    public OgixenoSangre actualizarOxigenoSangre(OgixenoSangre presion) {
        return iOxigenoSangreDao.save(presion);
    }

    @Override
    public void oxigenoSangreDelete(Long id) {
        iOxigenoSangreDao.deleteById(id);
    }

    @Override
    public List<OgixenoSangre> findByUser(Usuario id) {
        return iOxigenoSangreDao.findByUser(id);
    }
}
