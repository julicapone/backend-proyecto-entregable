package com.capone.clinica.repository;

import com.capone.clinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IOdontologoRepository extends JpaRepository <Odontologo, Long> {
    @Query("from Odontologo s where s.apellido like %:apellido%")
    List<Odontologo> traerPorApellido(@Param("apellido") String apellido);
}
