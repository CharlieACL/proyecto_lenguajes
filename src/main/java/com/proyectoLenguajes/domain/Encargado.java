
package com.proyectoLenguajes.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "encargado")
public class Encargado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encargado_seq_generator")
    @SequenceGenerator(name = "encargado_seq_generator", sequenceName = "encargado_seq", allocationSize = 1)
    @Column(name="id_encargado")
    private Long idEncargado;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    
    @OneToMany(mappedBy = "encargado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estudiantes> estudiantes;

    public Encargado() {
    }

    public Encargado(String nombre, String apellido, String correo, String telefono, String direccion, List<Estudiantes> estudiantes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estudiantes = estudiantes;
    }

    
    
    
}
