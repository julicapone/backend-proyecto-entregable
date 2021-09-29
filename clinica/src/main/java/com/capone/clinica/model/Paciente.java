package com.capone.clinica.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Paciente.class)
@Entity
@Table
@Getter
@Setter
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private String domicilio;
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Set<Turno> turnos;
}
