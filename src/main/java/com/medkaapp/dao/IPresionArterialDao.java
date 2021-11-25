package com.medkaapp.dao;

import com.medkaapp.db.PresionArterial;
import com.medkaapp.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPresionArterialDao extends JpaRepository<PresionArterial, Long> {

    @Query(value = "select * from presion_arterial pa where pa.id_paciente = :id", nativeQuery = true)
    List<PresionArterial> findByUser(Usuario id);

}
