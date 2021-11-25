package com.medkaapp.controller;

import com.medkaapp.db.PresionArterial;
import com.medkaapp.db.Temperatura;
import com.medkaapp.dto.CreateTemperaturaDTO;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.security.repository.IUsuarioDao;
import com.medkaapp.service.impl.TemperaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TemperaturaController {
    @Autowired
    TemperaturaServiceImpl temperaturaService;

    @Autowired
    IUsuarioDao pacienteDao;

    @GetMapping("/temp/list")
    public List<Temperatura> listarTemperatura(){
        return temperaturaService.listarTemperatura();
    }

    @GetMapping("/temp/user/{id}")
    public List<Temperatura> presionIdUser(@PathVariable(name = "id") Integer id) {
        Usuario usuario = pacienteDao.findById(id).get();
        return temperaturaService.findByUser(usuario);
    }

    @GetMapping("/temp/{id}")
    public Temperatura temperaturaFindId(@PathVariable(name = "id") Long id) {
        Temperatura temperaturaId = new Temperatura();
        temperaturaId = temperaturaService.temperaturaId(id);
        return temperaturaId;
    }

    @PostMapping("/temp/save")
    public ResponseEntity<?> temperaturaSave(@RequestBody CreateTemperaturaDTO temperatura) {
        Temperatura newTemperatura = new Temperatura();
        newTemperatura.setFecha(temperatura.getFecha());
        newTemperatura.setHora(temperatura.getHora());
        newTemperatura.setTemperatura(temperatura.getTemperatura());
        Usuario temp = pacienteDao.findById(temperatura.getPacienteId()).orElse(null);
        newTemperatura.setPaciente(temp);

        return ResponseEntity.status(HttpStatus.CREATED).body(temperaturaService.guardarTemperatura(newTemperatura));
    }

    @PutMapping("/temp/{id}")
    public Temperatura editTemperatura(@PathVariable(name = "id") Long id, @RequestBody Temperatura temperatura) {
        Temperatura temperaturaSelect = new Temperatura();
        Temperatura temperaturaUpdate = new Temperatura();

        temperaturaSelect = temperaturaService.temperaturaId(id);
        temperaturaSelect.setTemperatura(temperatura.getTemperatura());

        temperaturaUpdate = temperaturaService.actualizarTemperatura(temperaturaSelect);

        return temperaturaUpdate;
    }

    @DeleteMapping("temp/{id}")
    public void deleteTemperaturaArterial (@PathVariable(name = "id") Long id) {
        temperaturaService.eliminarTemperatura(id);
    }

}
