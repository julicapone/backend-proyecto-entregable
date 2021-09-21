package com.capone.clinica.controller;

import com.capone.clinica.model.Turno;
import com.capone.clinica.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final IService<Turno> turnoService;

    public TurnoController(IService<Turno> turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping()
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        turnoService.registrar(turno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;
        if (turno.getId() != null && turnoService.traerPorId(turno.getId()).isPresent())
            response = ResponseEntity.ok(turnoService.modificar(turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> traerTurno(@PathVariable Long id) {
        Turno turno = turnoService.traerPorId(id).orElse(null);
        return ResponseEntity.ok(turno);
    }

    @GetMapping
    public ResponseEntity<List<Turno>> traerTurnos(){
        return ResponseEntity.ok(turnoService.traerTodos());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable("id") Long id) {
        turnoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
