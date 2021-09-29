package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IServiceTest {

    @Autowired
    IService<Odontologo> odontologoIService;

    @Test
    void registrar() {
        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Almaraz");
        odontologo.setNombre("Amanda");
        odontologo.setMatricula(44);
        odontologoIService.registrar(odontologo);

        List<Odontologo> odontologos = odontologoIService.traerPorApellido("Almaraz");

        boolean odontologoPresente = odontologos.size() > 0;
        assertTrue(odontologoPresente);
    }
}