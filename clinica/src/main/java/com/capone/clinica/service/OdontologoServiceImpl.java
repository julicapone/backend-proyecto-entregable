package com.capone.clinica.service;

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
}
