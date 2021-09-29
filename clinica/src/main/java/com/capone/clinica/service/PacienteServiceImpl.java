package com.capone.clinica.service;

import com.capone.clinica.model.Paciente;
import com.capone.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IService<Paciente>{
    private final IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente registrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        Optional<Paciente> paciente1 = traerPorId(paciente.getId());
        paciente1.get().setApellido(paciente.getApellido());
        paciente1.get().setNombre(paciente.getNombre());
        paciente1.get().setDni(paciente.getDni());
        paciente1.get().setDomicilio(paciente.getDomicilio());
        paciente1.get().setFechaIngreso(paciente.getFechaIngreso());
        return pacienteRepository.save(paciente1.get());
    }

    @Override
    public Optional<Paciente> traerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> traerTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<Paciente> traerPorApellido(String apellido) {
        return null;
    }
}
