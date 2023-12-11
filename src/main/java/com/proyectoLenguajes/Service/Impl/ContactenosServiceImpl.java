/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoLenguajes.Service.Impl;

import com.proyectoLenguajes.Service.ContactenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContactenosServiceImpl implements ContactenosService{
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public ContactenosServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    
    @Override
    public void insertarContactos(String correo, String telefono, String mensaje) {
        try{
            jdbcTemplate.update("CALL insertar_contactenos(?, ?, ?)",correo,telefono,mensaje);
            System.out.println("Mensaje enviado exitosamente");
        }
        catch (Exception e) {
            System.err.println("Error al enviar el mensaje");
            e.printStackTrace();
        }
        
    }
    
}
