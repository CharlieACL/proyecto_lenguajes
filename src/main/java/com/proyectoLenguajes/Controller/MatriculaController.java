/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyectoLenguajes.Controller;

import com.proyectoLenguajes.Service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatriculaController {
    
    private final MatriculaService matriculaService;
    
    @Autowired
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }
    
    @GetMapping("/matricula")
    public String mostrarMatricula() {
        return "matricula"; 
    }
    
    @PostMapping("/matricular-estudiante")
    public String insertarMatricula(String nombre, String apellido, String telefono, String correo, String direccion,
            String nombreEst, String apellidoEst, String nivelEst , String alegiasEst, String condicionEst, 
            int edadEst, Long idEncargadoEst,Long idEstudianteLi){
        matriculaService.insertarMatricula(nombre, apellido, telefono, correo, direccion, nombreEst, apellidoEst, nivelEst, alegiasEst, 
                condicionEst, edadEst, idEncargadoEst,idEstudianteLi);
        return "redirect:/matricula?exito";
    }
    
}
