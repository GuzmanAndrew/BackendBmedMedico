package com.medkaapp.controller;

import com.medkaapp.db.FrecuenciaCardiaca;
import com.medkaapp.db.PresionArterial;
import com.medkaapp.dto.CreateFrecuenciaCardiacaDTO;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.security.repository.IUsuarioDao;
import com.medkaapp.service.impl.FrecuenciaCardiacaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FrecuenciaCardiacaController {
    @Autowired
    FrecuenciaCardiacaServiceImpl frecuenciaCardiacaService;

    @Autowired
    IUsuarioDao pacienteDao;

    @GetMapping("/frecuencia/list")
    public List<FrecuenciaCardiaca> listarFrecuenciaCardiaca(){
        return frecuenciaCardiacaService.listarFrecuenciaCardiaca();
    }

    @GetMapping("/frecuencia/user/{id}")
    public List<FrecuenciaCardiaca> frecuenciaCardiacaIdUser(@PathVariable(name = "id") Integer id) {
        Usuario usuario = pacienteDao.findById(id).get();
        return frecuenciaCardiacaService.findByUser(usuario);
    }

    @GetMapping("/frecuencia/{id}")
    public FrecuenciaCardiaca frecuenciaCardiacaFindId(@PathVariable(name = "id") Long id) {
        FrecuenciaCardiaca frecuenciaCardiacaId = new FrecuenciaCardiaca();
        frecuenciaCardiacaId = frecuenciaCardiacaService.frecuenciaCardiacaId(id);
        return frecuenciaCardiacaId;
    }

    @PostMapping("/frecuencia/save")
    public ResponseEntity<?> frecuenciaCardiacaSave(@RequestBody CreateFrecuenciaCardiacaDTO frecuencia) {
        FrecuenciaCardiaca newFrecuencia = new FrecuenciaCardiaca();
        newFrecuencia.setFecha(frecuencia.getFecha());
        newFrecuencia.setHora(frecuencia.getHora());
        newFrecuencia.setFrecuencia(frecuencia.getFrecuencia());
        Usuario temp = pacienteDao.findById(frecuencia.getPacienteId()).orElse(null);
        newFrecuencia.setPaciente(temp);

        return ResponseEntity.status(HttpStatus.CREATED).body(frecuenciaCardiacaService.guardarFrecuenciaCardiaca(newFrecuencia));
    }

    @PutMapping("/frecuencia/{id}")
    public FrecuenciaCardiaca editFrecuenciaCardiaca(@PathVariable(name = "id") Long id, @RequestBody FrecuenciaCardiaca frecuenciaCardiaca) {
        FrecuenciaCardiaca frecuenciaCardiacaSelect = new FrecuenciaCardiaca();
        FrecuenciaCardiaca frecuenciaCardiacaUpdate = new FrecuenciaCardiaca();

        frecuenciaCardiacaSelect = frecuenciaCardiacaService.frecuenciaCardiacaId(id);
        frecuenciaCardiacaSelect.setFrecuencia(frecuenciaCardiaca.getFrecuencia());

        frecuenciaCardiacaUpdate = frecuenciaCardiacaService.actualizarFrecuenciaCardiaca(frecuenciaCardiacaUpdate);

        return frecuenciaCardiacaUpdate;
    }

    @DeleteMapping("frecuencia/{id}")
    public void deleteFrecuenciaCardiaca (@PathVariable(name = "id") Long id) {
        frecuenciaCardiacaService.eliminarFrecuenciaCardiaca(id);
    }
}
