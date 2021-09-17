package com.capone.clinica.controller;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping()
    public ResponseEntity<?> registrarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.registrar(odontologo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable("id") Long id) {
        odontologoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
