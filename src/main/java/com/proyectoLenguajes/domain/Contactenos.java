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
@Table(name = "contactenos")
public class Contactenos implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactenos_seq_generator")
    @SequenceGenerator(name = "contactenos_seq_generator", sequenceName = "contactenos_seq", allocationSize = 1)
    @Column(name="id_contactenos")
    private Long id_contactenos;
    private String correo;
    private String telefono;
    private String mensaje;

    public Contactenos() {
    }

    public Contactenos(String correo, String telefono, String mensaje) {
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }
    
    
}
