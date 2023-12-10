/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoLenguajes.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "profesor")
public class Profesor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq_generator")
    @SequenceGenerator(name = "profesor_seq_generator", sequenceName = "profesor_seq", allocationSize = 1)
    @Column(name="id_profesor")
    private Long idProfesor;
    private int edad;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    public Profesor() {
    }

    public Profesor(int edad, String nombre, String apellido, String correo, String telefono) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
}
