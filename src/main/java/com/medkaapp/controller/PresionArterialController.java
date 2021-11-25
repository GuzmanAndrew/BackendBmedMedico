package com.medkaapp.controller;

import com.medkaapp.db.PresionArterial;
import com.medkaapp.dto.CreatePresionArterialDTO;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.security.repository.IUsuarioDao;
import com.medkaapp.service.impl.PresionArterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PresionArterialController {

    @Autowired
    PresionArterialServiceImpl presionService;

    @Autowired
    IUsuarioDao pacienteDao;

    @GetMapping("/presion/list")
    public List<PresionArterial> listarHipertension(){
        return presionService.listarPresion();
    }

    @GetMapping("/presion/user/{id}")
    public List<PresionArterial> presionIdUser(@PathVariable(name = "id") Integer id) {
        Usuario usuario = pacienteDao.findById(id).get();
        return presionService.findByUser(usuario);
    }

    @GetMapping("/presion/{id}")
    public PresionArterial presionId(@PathVariable(name = "id") Long id) {
        PresionArterial presionId = new PresionArterial();
        presionId = presionService.presionId(id);
        return presionId;
    }

    @PostMapping("/presion/save")
    public ResponseEntity<?> presionArterialSave(@RequestBody CreatePresionArterialDTO presion) {
        PresionArterial newPresionArterial = new PresionArterial();
        newPresionArterial.setFecha(presion.getFecha());
        newPresionArterial.setHora(presion.getHora());
        newPresionArterial.setSistolica(presion.getSistolica());
        newPresionArterial.setDiastolica(presion.getDiastolica());
        Usuario paciente = pacienteDao.findById(presion.getPacienteId()).orElse(null);
        newPresionArterial.setPaciente(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(presionService.guardarPresion(newPresionArterial));
    }

    @PutMapping("/edit/{id}")
    public PresionArterial editPresionArterial(@PathVariable(name = "id") Long id, @RequestBody PresionArterial presion) {
        PresionArterial presionSelect = new PresionArterial();
        PresionArterial presionUpdate = new PresionArterial();

        presionSelect = presionService.presionId(id);
        presionSelect.setSistolica(presion.getSistolica());
        presionSelect.setDiastolica(presion.getDiastolica());

        presionUpdate = presionService.actualizarPresion(presionSelect);

        return presionUpdate;
    }

    @DeleteMapping("deleted/{id}")
    public void deletePresionArterial (@PathVariable(name = "id") Long id) {
        presionService.eliminarPresion(id);
    }
}
