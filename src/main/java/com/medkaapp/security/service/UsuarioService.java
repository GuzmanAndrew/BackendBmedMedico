package com.medkaapp.security.service;

import com.medkaapp.security.entity.Medico;
import com.medkaapp.security.repository.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioDao usuarioRepository;

    public Optional<Medico> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public List<Medico> getListUsuarios(){
        return usuarioRepository.findAll();
    }

    public Medico getByUserId(Integer id){
        return  usuarioRepository.findById(id).get();
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Medico usuario){
        usuarioRepository.save(usuario);
    }

    public Medico findById(Integer id) {
        return usuarioRepository.findById(id).get();
    }
}
