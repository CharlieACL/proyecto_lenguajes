/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoLenguajes.Controller;

import com.proyectoLenguajes.Service.ProfesorService;
import com.proyectoLenguajes.domain.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfesorController {
    private final ProfesorService profesorService;
    
    @Autowired
    public ProfesorController(ProfesorService profesorService){
        this.profesorService=profesorService;
    }
    
    @GetMapping("/profesor")
    public String mostrarProfesor() {
        return "profesor"; 
    }
    
    @PostMapping("/insertar-profesor")
    public String insertarProfesor(int edad, String nombre, String apellido, String correo, String telefono) {
        profesorService.insertarProfesor(edad, nombre, apellido, correo, telefono);
        return "redirect:/profesor";
    }
    
    @GetMapping("/lista-profesor")
    public String listaProfesor(Model model) {
        List<Profesor> profesores= profesorService.obtenerProfesor();
        model.addAttribute("profesores",profesores);
        return "lista-profesor"; 
    }
    
    @GetMapping("/detalle-profesor/{id}")
    public String detalleProfesor(@PathVariable Long id,Model model) {
        Profesor profesor= profesorService.getProfesorById(id);
        model.addAttribute("profesor",profesor);
        return "detalle-profesor"; 
    }
    
    @PostMapping("/actualizar-profesor")
    public String actualizarProfesor(Long idProfesor,int edad, String nombre, String apellido, String correo, String telefono) {
        profesorService.actualizarProfesor(idProfesor, edad, nombre, apellido, correo, telefono);
        return "redirect:/lista-profesor";
    }
    
    @PostMapping("/eliminar-profesor/{id}")
    public String eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
        return "redirect:/lista-profesor";
    }
}
