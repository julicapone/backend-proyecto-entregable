package com.capone.clinica.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    T registrar(T t);
    T modificar(T t);
    Optional<T> traerPorId(Long id);
    List<T> traerTodos();
    void eliminar(Long id);
}
