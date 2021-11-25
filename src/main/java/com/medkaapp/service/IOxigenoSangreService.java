package com.medkaapp.service;

import com.medkaapp.db.OgixenoSangre;
import com.medkaapp.security.entity.Usuario;

import java.util.List;

public interface IOxigenoSangreService {
    public List<OgixenoSangre> listarOxigenoSangre();

    public OgixenoSangre guardarOxigenoSangre(OgixenoSangre presion);

    public OgixenoSangre oxigenoSangreId(Long id);

    public OgixenoSangre actualizarOxigenoSangre(OgixenoSangre presion);

    public void oxigenoSangreDelete(Long id);

    public List<OgixenoSangre> findByUser(Usuario id);
}
