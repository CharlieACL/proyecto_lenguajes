/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoLenguajes.Controller;

import com.proyectoLenguajes.Service.ContactenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ContactenosController {
    private final ContactenosService contactenosService;
    
    @Autowired
    public ContactenosController(ContactenosService contactenosService){
        this.contactenosService=contactenosService;
    }
    
    @GetMapping("/contactenos")
    public String mostrarContactenos() {
        return "contactenos"; 
    }
    
    @PostMapping("/insertar-contactenos")
    public String insertarContactenos(String correo, String telefono, String mensaje) {
        contactenosService.insertarContactos(correo, telefono, mensaje);
        return "redirect:/contactenos";
    }
}
