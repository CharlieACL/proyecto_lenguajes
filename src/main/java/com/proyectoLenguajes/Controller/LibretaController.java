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
    
    @PostMapping("/actualizar-libreta")
    public String actualidarLibreta( @RequestParam Long idLibreta, @RequestParam int asistencia, @RequestParam String observaciones){
        libretaService.actualizarLibreta(idLibreta, asistencia, observaciones);
        return "redirect:/libreta";
    }
    
    @PostMapping("/eliminar-libreta/{id}")
    public String eliminarLibreta(@PathVariable Long id){
        libretaService.eliminarLibreta(id);
        return "redirect:/libreta";
    }
}
