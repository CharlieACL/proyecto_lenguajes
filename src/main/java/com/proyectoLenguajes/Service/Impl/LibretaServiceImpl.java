
package com.proyectoLenguajes.Service.Impl;

import com.proyectoLenguajes.Service.LibretaService;
import com.proyectoLenguajes.dao.EstudiantesDao;
import com.proyectoLenguajes.dao.LibretaDao;
import com.proyectoLenguajes.domain.Estudiantes;
import com.proyectoLenguajes.domain.Libreta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibretaServiceImpl implements LibretaService{
    
    private final EstudiantesDao estudiantesDao;
    
    private final LibretaDao libretaDao;
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibretaServiceImpl(EstudiantesDao estudiantesDao, LibretaDao libretaDao, JdbcTemplate jdbcTemplate) {
        this.estudiantesDao = estudiantesDao;
        this.libretaDao = libretaDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Estudiantes> obtenerTodosEstudiantes() {
        return estudiantesDao.findAll();
    }

    @Override
    public List<Libreta> getAllLibretas() {
        return libretaDao.findAll();
    }
    
    @Override
    public Estudiantes getEstudiantesById(Long id) {
        return estudiantesDao.findById(id).orElse(null);
    }

    @Override
    public Libreta getLibretaById(Long id) {
        return libretaDao.findById(id).orElse(null);
    }   

    @Override
    public void actualizarLibreta(Long idLibreta, int asistencia, String observaciones) {
        try{    
        jdbcTemplate.update("CALL  actualizar_libreta(?,?,?)",idLibreta,asistencia,observaciones);
            System.out.println("libreta actualizada exitosamente");
        }
        catch (Exception e) {
        System.err.println("Error al actualizar los datos en la libreta del estudiante");
        e.printStackTrace();
        } 
    }

    @Override
    public void actualizarEstudiante(Long idEncargado, String nombreEn, String apellidoEn, String telefono, String correo, String direccion, 
            Long idEstudiante, String nombreEst, String apellidoEst, String nivel, String alergias, String condicion, int edad) {
        try{    
        jdbcTemplate.update("CALL  actualizar_estudiante(?,?,?,?,?,?,?,?,?,?,?,?,?)",
        idEncargado,nombreEn,apellidoEn,telefono,correo,direccion,
        idEstudiante,nombreEst,apellidoEst,nivel,alergias,condicion,edad);
            System.out.println("Estudiante actualizado exitosamente");
        }
        catch (Exception e) {
        System.err.println("Error al actualizar los datos del estudiante");
        e.printStackTrace();
        } 
    }
    
    @Transactional
    @Override
    public void eliminarEstudianteMatriculado(Long idLibreta) {
        try{    
        jdbcTemplate.update("CALL  eliminar_estudiante_matriculado(?)",idLibreta);
            System.out.println("estudiante eliminada exitosamente");
        }
        catch (Exception e) {
        System.err.println("Error al insertar los datos en la tabla de estudiantes");
        e.printStackTrace();
        } 
    }

    
}
