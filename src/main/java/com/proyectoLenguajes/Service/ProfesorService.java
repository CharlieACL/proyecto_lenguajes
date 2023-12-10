/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoLenguajes.Service;

import com.proyectoLenguajes.domain.Profesor;
import java.util.List;


public interface ProfesorService {
    void insertarProfesor(int edad, String nombre, String apellido, String correo, String telefono);
    
    List<Profesor> obtenerProfesor();
    
    Profesor getProfesorById(Long id);
    
    void actualizarProfesor(Long idProfesor,int edad, String nombre, String apellido, String correo, String telefono);
    
    void eliminarProfesor(Long idProfesor);
}
