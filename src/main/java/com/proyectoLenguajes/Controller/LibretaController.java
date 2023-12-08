/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyectoLenguajes.Controller;

import com.proyectoLenguajes.Service.LibretaService;
import com.proyectoLenguajes.domain.Estudiantes;
import com.proyectoLenguajes.domain.Libreta;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LibretaController {
    
    private final LibretaService libretaService;
    
    @Autowired
    public LibretaController(LibretaService libretaService) {
        this.libretaService = libretaService;
    }
    
    @GetMapping("/listaEstudiantes")
    public String listaEstudiantes(Model model){
        List<Estudiantes> estudiantes = libretaService.obtenerTodosEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";
    }
    
    @GetMapping("/libreta")
    public String mostrarLibretas(Model model) {
        List<Libreta> libretas = libretaService.getAllLibretas();
        model.addAttribute("libretas", libretas);
        return "libreta";
    }
    
    @GetMapping("/detalleLibreta/{id}")
    public String detalleLibreta(@PathVariable Long id, Model model) {
        Libreta libreta = libretaService.getLibretaById(id);
        model.addAttribute("libreta", libreta);
        return "detalleLibreta";
    }
    
    @GetMapping("/detalleEstudiante/{id}")
    public String detalleEstudiante(@PathVariable Long id, Model model) {
        Estudiantes estudiante = libretaService.getEstudiantesById(id);
        model.addAttribute("estudiante", estudiante);
        return "detalleEstudiante";
    }
    
    @PostMapping("/actualizar-libreta")
    public String actualidarLibreta(@RequestParam Long idLibreta, @RequestParam int asistencia, @RequestParam String observaciones){
        libretaService.actualizarLibreta(idLibreta, asistencia, observaciones);
        return "redirect:/libreta";
    }
    
    @PostMapping("/actualizar-estudiante")
    public String actualidarEstudiante(@RequestParam Long idEncargado, @RequestParam String nombreEn, @RequestParam String apellidoEn, @RequestParam String telefono, @RequestParam String correo, @RequestParam String direccion, 
           @RequestParam Long idEstudiante, @RequestParam String nombreEst, @RequestParam String apellidoEst, @RequestParam String nivel, @RequestParam String alergias, @RequestParam String condicion, @RequestParam int edad){ 
        try {
         libretaService.actualizarEstudiante(idEncargado, nombreEn, apellidoEn, telefono, correo, direccion, 
         idEstudiante, nombreEst, apellidoEst, nivel, alergias, condicion, edad);   
         return "redirect:/libreta";
     } catch (Exception e) {
         e.printStackTrace();
         return "redirect:/error";  
     }
    }
    
    @PostMapping("/eliminar-libreta/{id}")
    public String eliminarLibreta(@PathVariable Long id){
        libretaService.eliminarEstudianteMatriculado(id);
        return "redirect:/libreta";
    }
}
