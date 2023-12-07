
package com.proyectoLenguajes.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UsuarioService {
    void insertarUsuario(String username, String contrasena, String correo, String telefono, int estado,String userRol);
    
    void insertarRol(String nombreRol, Long idUsuario);
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}


