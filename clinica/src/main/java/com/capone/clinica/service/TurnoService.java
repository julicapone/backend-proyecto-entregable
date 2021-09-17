package com.capone.clinica.service;

import com.capone.clinica.model.Turno;

import java.util.List;

public interface TurnoService {
    void registrar(Turno turno);
    void eliminar(Long id);
    List<Turno> obtenerTodos();
}
