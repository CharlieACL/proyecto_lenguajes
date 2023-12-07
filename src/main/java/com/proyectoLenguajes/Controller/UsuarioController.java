
package com.proyectoLenguajes.Controller;

import com.proyectoLenguajes.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro"; 
    }

    @PostMapping("/crear-usuario")
    public String insertarUsuario(String username, String contrasena, String correo, String telefono, int estado,String userRol) {
        usuarioService.insertarUsuario(username, contrasena, correo, telefono, estado,userRol);
        return "redirect:/registro?exito";
    }
    
}
