package com.capone.clinica.service;

import com.capone.clinica.model.Turno;
import com.capone.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {
    private final ITurnoRepository turnoRepository;

    @Autowired
    public TurnoServiceImpl(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public void registrar(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public List<Turno> obtenerTodos() {
        return turnoRepository.findAll();
    }
}
