package com.capone.clinica.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    T registrar(T t);
    T modificar(T t) throws Exception;
    Optional<T> traerPorId(Long id) throws Exception;
    List<T> traerTodos();
    void eliminar(Long id);
    List<T> traerPorApellido(String apellido);
}
