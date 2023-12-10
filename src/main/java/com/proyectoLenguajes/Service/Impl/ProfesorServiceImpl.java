/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoLenguajes.Service.Impl;

import com.proyectoLenguajes.Service.ProfesorService;
import com.proyectoLenguajes.dao.ProfesorDao;
import com.proyectoLenguajes.domain.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    private final JdbcTemplate jdbcTemplate;
    
    private final ProfesorDao profesorDao;
    
    @Autowired
    public ProfesorServiceImpl(JdbcTemplate jdbcTemplate, ProfesorDao profesorDao){
        this.jdbcTemplate = jdbcTemplate; 
        this.profesorDao=profesorDao;
    }

    @Override
    public void insertarProfesor(int edad, String nombre, String apellido, String correo, String telefono) {
        try{
            jdbcTemplate.update("CALL insertar_profesor(?, ?, ?, ?, ?)",edad, nombre, apellido,correo,telefono);
            System.out.println("Datos agregados correctamente en la tabla de profesor");
        }
        catch (Exception e) {
            System.err.println("Error al insertar los datos en la tabla de profesor");
            e.printStackTrace();
        }   
    }

    @Override
    public List<Profesor> obtenerProfesor() {
       return profesorDao.findAll();
    }

    @Override
    public Profesor getProfesorById(Long id) {
        return profesorDao.findById(id).orElse(null);
    }

    @Override
    public void actualizarProfesor(Long idProfesor,int edad, String nombre, String apellido, String correo, String telefono) {
        try{
            jdbcTemplate.update("CALL actualizar_profesor(?, ?, ?, ?, ?, ?)",idProfesor, edad, nombre, apellido,correo,telefono);
            System.out.println("Datos agregados correctamente en la tabla de profesor");
        }
        catch (Exception e) {
            System.err.println("Error al insertar los datos en la tabla de profesor");
            e.printStackTrace();
        }  
    }

    @Transactional
    @Override
    public void eliminarProfesor(Long idProfesor) {
        try{    
        jdbcTemplate.update("CALL  eliminar_profesor(?)",idProfesor);
            System.out.println("Profesor eliminado exitosamente");
        }
        catch (Exception e) {
        System.err.println("Error al eliminar los datos en la tabla de estudiantes");
        e.printStackTrace();
        } 
    }
}
