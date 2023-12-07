
package com.proyectoLenguajes.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiantes implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_seq_generator")
    @SequenceGenerator(name = "estudiante_seq_generator", sequenceName = "estudiante_seq", allocationSize = 1)
    @Column(name="id_estudiante")
    private Long idEstudiante;
    private String nombre;
    private String apellido;
    private String nivel;
    private String alergias;
    private String condicion;
    private int edad;
    
    @Column(name="id_encargado")
    private int idEncargado;

    @ManyToOne
    @JoinColumn(name = "id_encargado", referencedColumnName = "id_encargado", insertable = false, updatable = false)
    private Encargado encargado;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libreta> libretas;
    
    public Estudiantes() {
    }

    public Estudiantes(String nombre, String apellido, String nivel, String alergias, String condicion,int edad, int idEncargado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nivel = nivel;
        this.alergias = alergias;
        this.condicion = condicion;
        this.edad = edad;
        this.idEncargado = idEncargado;
    }
}
