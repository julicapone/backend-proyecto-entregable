package com.capone.clinica.service;

import com.capone.clinica.model.Paciente;
import com.capone.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void registrar(Paciente paciente) {
        pacienteRepository.save(paciente);
        System.out.println("Paciente registrado" + paciente.toString());
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return null;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
        System.out.println("Paciente eliminado" + id);
    }
}
