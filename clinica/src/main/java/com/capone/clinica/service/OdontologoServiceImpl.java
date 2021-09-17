package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OdontologoServiceImpl implements OdontologoService {
    private final IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public void registrar(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
        System.out.println("Odontólogo guardado" + odontologo.toString());
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        Odontologo odontologoExistente = odontologoRepository.findById(odontologo.getId()).orElse(null);
        odontologoExistente.setNombre(odontologo.getNombre());
        odontologoExistente.setApellido(odontologo.getApellido());
        odontologoExistente.setMatricula(odontologo.getMatricula());
        return odontologoRepository.save(odontologoExistente);
    }

    @Override
    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
        System.out.println("Odontólogo eliminado" + id);
    }
}
