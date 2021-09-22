package com.capone.clinica.repository;

import com.capone.clinica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository <Turno, Long> {
}
