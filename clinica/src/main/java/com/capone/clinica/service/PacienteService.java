package com.capone.clinica.service;

import com.capone.clinica.model.Paciente;

public interface PacienteService {
    void registrar(Paciente paciente);
    Paciente modificar(Paciente paciente);
    void eliminar(Long id);
}
