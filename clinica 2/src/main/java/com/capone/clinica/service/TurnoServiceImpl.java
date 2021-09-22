package com.capone.clinica.service;

import com.capone.clinica.model.Turno;
import com.capone.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements IService<Turno>{
    private final ITurnoRepository turnoRepository;

    @Autowired
    public TurnoServiceImpl(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Turno registrar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno modificar(Turno turno) {
        Optional<Turno> turno1 = traerPorId(turno.getId());
        turno1.get().setDate(turno.getDate());
        return turnoRepository.save(turno1.get());
    }

    @Override
    public Optional<Turno> traerPorId(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public List<Turno> traerTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }
}
