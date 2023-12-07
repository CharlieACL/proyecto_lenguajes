
package com.proyectoLenguajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "libretaEstudiantil")
public class Libreta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libreta_seq_generator")
    @SequenceGenerator(name = "libreta_seq_generator", sequenceName = "libreta_seq", allocationSize = 1)
    @Column(name="id_libreta")
    private Long idLibreta;
    private int asistencia;
    private String observaciones;
    
    @Column(name="id_estudiante")
    private int idEstudiante;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante", insertable = false, updatable = false)
    private Estudiantes estudiante;
    
    public Libreta() {
    }

    public Libreta(int asistencia, String observaciones, int idEstudiante){
        this.asistencia = asistencia;
        this.observaciones = observaciones;
        this.idEstudiante = idEstudiante;
    }
}
