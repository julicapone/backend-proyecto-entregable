package com.capone.clinica.controller;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final IService<Odontologo> odontologoService;


    @Autowired
    public OdontologoController(IService<Odontologo> odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.registrar(odontologo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) throws Exception {
        ResponseEntity<Odontologo> response = null;
        if (odontologo.getId() != null && odontologoService.traerPorId(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.modificar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> traerOdontologo(@PathVariable Long id) throws Exception {
        Odontologo odontologo = odontologoService.traerPorId(id).orElse(null);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> traerOdontologos(){
        return ResponseEntity.ok(odontologoService.traerTodos());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable("id") Long id) {
        odontologoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/traerOdontólogoPorNombre")
    public List<Odontologo> traerOdontologoporNombre(@RequestParam String apellido) {
        return odontologoService.traerPorApellido(apellido);
    }

}
