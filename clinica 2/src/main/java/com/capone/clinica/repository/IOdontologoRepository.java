package com.capone.clinica.repository;

import com.capone.clinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository <Odontologo, Long> {
}
