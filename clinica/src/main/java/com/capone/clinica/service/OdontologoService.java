package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;

public interface OdontologoService {
    void registrar(Odontologo odontologo);
    Odontologo modificar(Odontologo odontologo);
    void eliminar(Long id);
}
