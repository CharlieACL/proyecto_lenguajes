
package com.proyectoLenguajes.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq_generator")
    @SequenceGenerator(name = "usuario_seq_generator", sequenceName = "usuarios_seq", allocationSize = 1)
    @Column(name="id_usuario")
    private Long idUsuario;
    private String username;
    private String contrasena;
    private String correo;
    private String telefono;
    private int estado;
    
    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(String username, String contrasena, String correo, String telefono, int estado, List<Rol> roles) {
        this.username = username;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
        this.roles = roles;
    }   
}
