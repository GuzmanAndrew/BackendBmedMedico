package com.medkaapp.util;

import com.medkaapp.security.entity.Rol;
import com.medkaapp.security.enums.RolNombre;
import com.medkaapp.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */
@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /*Rol rolMedico = new Rol(RolNombre.ROLE_MEDICO);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolMedico);
        rolService.save(rolUser);*/
    }
}
