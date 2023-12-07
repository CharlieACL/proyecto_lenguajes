
package com.proyectoLenguajes.Service.Impl;

import com.proyectoLenguajes.Service.MatriculaService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MatriculaServiceImpl implements MatriculaService{

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public MatriculaServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;        
    }
    
    @Override
    public void insertarMatricula(String nombre, String apellido, String telefono, String correo, String direccion,
            String nombreEst, String apellidoEst, String nivelEst , String alegiasEst, String condicionEst,
            int edadEst, Long idEncargadoEst,Long idEstudianteLi) {
        try{
            jdbcTemplate.update("CALL insertar_encargado(?,?,?,?,?)",nombre,apellido,telefono,correo,direccion);
            System.out.println("Encargados agregados exitosamente");
            
            idEncargadoEst = jdbcTemplate.queryForObject("SELECT id_encargado FROM encargado WHERE correo = ?", Long.class, correo);
            insertarEstudiante(nombreEst,apellidoEst,nivelEst,alegiasEst,condicionEst,edadEst,idEncargadoEst,
                    idEstudianteLi);
        
        }
        catch (Exception e) {
            System.err.println("Error al insertar los datos en la tabla de encargados");
            e.printStackTrace();
        }
    }

    @Override
    public void insertarEstudiante(String nombre, String apellido, String nivel, String alegias, String condicion, int edad, Long idEncargado,Long idEstudianteLi) {
        try{    
        jdbcTemplate.update("CALL  insertar_estudiantes(?,?,?,?,?,?,?)",nombre,apellido,nivel,alegias,condicion,edad,idEncargado);
            System.out.println("estudiantes matriculados exitosamente");
        
        idEstudianteLi = jdbcTemplate.queryForObject("SELECT id_estudiante FROM estudiantes WHERE apellido = ?", Long.class, apellido);
        
        insertarLibreta(0, "vacio", idEstudianteLi);
        }
        catch (Exception e) {
        System.err.println("Error al insertar los datos en la tabla de estudiantes");
        e.printStackTrace();
        }       
    }   

    @Override
    public void insertarLibreta(int asistencia, String observaciones, Long idEstudiante) {
        try{    
        jdbcTemplate.update("CALL  insertar_libretaEstudiantil(?,?,?)",asistencia,observaciones,idEstudiante);
            System.out.println("estudiantes ingresados al sistema exitosamente");
        }
        catch (Exception e) {
        System.err.println("Error al insertar los datos en la tabla de estudiantes");
        e.printStackTrace();
        }       
    }
}
