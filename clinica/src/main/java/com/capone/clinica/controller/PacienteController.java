package com.capone.clinica.controller;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.model.Paciente;
import com.capone.clinica.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final IService<Paciente> pacienteService;

    public PacienteController(IService<Paciente> pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        pacienteService.registrar(paciente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        if (paciente.getId() != null && pacienteService.traerPorId(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.modificar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> traerPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.traerPorId(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> traerPacientes(){
        return ResponseEntity.ok(pacienteService.traerTodos());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable("id") Long id) {
        pacienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
