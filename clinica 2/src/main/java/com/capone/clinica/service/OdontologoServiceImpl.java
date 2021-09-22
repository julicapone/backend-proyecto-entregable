package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IService<Odontologo> {
    private final IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        Optional<Odontologo> odontologo1 = traerPorId(odontologo.getId());
        odontologo1.get().setApellido(odontologo.getApellido());
        odontologo1.get().setNombre(odontologo.getNombre());
        odontologo1.get().setMatricula(odontologo.getMatricula());
        return odontologoRepository.save(odontologo1.get());
    }

    @Override
    public Optional<Odontologo> traerPorId(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public List<Odontologo> traerTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }
}
