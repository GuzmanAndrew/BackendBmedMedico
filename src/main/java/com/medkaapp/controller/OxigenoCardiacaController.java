package com.medkaapp.controller;

import com.medkaapp.db.OgixenoSangre;
import com.medkaapp.db.PresionArterial;
import com.medkaapp.dto.CreateOxigenoSangreDTO;
import com.medkaapp.security.entity.Usuario;
import com.medkaapp.security.repository.IUsuarioDao;
import com.medkaapp.service.impl.OxigenoSangreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OxigenoCardiacaController {

    @Autowired
    OxigenoSangreServiceImpl oxigenoSangreService;

    @Autowired
    IUsuarioDao pacienteDao;

    @GetMapping("/oxi/list")
    public List<OgixenoSangre> listarOxigenoSangre(){
        return oxigenoSangreService.listarOxigenoSangre();
    }

    @GetMapping("/oxi/user/{id}")
    public List<OgixenoSangre> presionIdUser(@PathVariable(name = "id") Integer id) {
        Usuario usuario = pacienteDao.findById(id).get();
        return oxigenoSangreService.findByUser(usuario);
    }

    @GetMapping("/oxi/{id}")
    public OgixenoSangre oxigenoSangreFindId(@PathVariable(name = "id") Long id) {
        OgixenoSangre oxigenoId = new OgixenoSangre();
        oxigenoId = oxigenoSangreService.oxigenoSangreId(id);
        return oxigenoId;
    }

    @PostMapping("/oxi/save")
    public ResponseEntity<?> oxigenoSangreSave(@RequestBody CreateOxigenoSangreDTO oxigeno) {
        OgixenoSangre newOxigeno = new OgixenoSangre();
        newOxigeno.setFecha(oxigeno.getFecha());
        newOxigeno.setHora(oxigeno.getHora());
        newOxigeno.setOxigeno(oxigeno.getOxigeno());
        Usuario temp = pacienteDao.findById(oxigeno.getPacienteId()).orElse(null);
        newOxigeno.setPaciente(temp);

        return ResponseEntity.status(HttpStatus.CREATED).body(oxigenoSangreService.guardarOxigenoSangre(newOxigeno));
    }

    @PutMapping("/oxi/{id}")
    public OgixenoSangre editOxigenoSangre(@PathVariable(name = "id") Long id, @RequestBody OgixenoSangre oxigeno) {
        OgixenoSangre ogixenoSangreSelect = new OgixenoSangre();
        OgixenoSangre ogixenoSangreUpdate = new OgixenoSangre();

        ogixenoSangreSelect = oxigenoSangreService.oxigenoSangreId(id);
        ogixenoSangreSelect.setOxigeno(oxigeno.getOxigeno());

        ogixenoSangreUpdate = oxigenoSangreService.actualizarOxigenoSangre(ogixenoSangreSelect);

        return ogixenoSangreUpdate;
    }

    @DeleteMapping("oxi/{id}")
    public void deleteOxigenoSangre (@PathVariable(name = "id") Long id) {
        oxigenoSangreService.oxigenoSangreDelete(id);
    }
}
