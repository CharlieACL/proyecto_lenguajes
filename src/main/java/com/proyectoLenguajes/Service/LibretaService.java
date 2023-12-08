
package com.proyectoLenguajes.Service;

import com.proyectoLenguajes.domain.Estudiantes;
import com.proyectoLenguajes.domain.Libreta;
import java.util.List;

public interface LibretaService {
    
    List<Estudiantes> obtenerTodosEstudiantes();
    Estudiantes getEstudiantesById(Long id);
    
    List<Libreta> getAllLibretas();
    Libreta getLibretaById(Long id);
    
    void actualizarLibreta(Long idLibreta, int asistencia, String observaciones);
 
    void actualizarEstudiante(Long idEncargado, String nombreEn, String apellidoEn, String telefono,String correo, String direccion,
            Long idEstudiante, String nombreEst, String apellidoEst, String nivel, String alergias, String condicion, int edad);
    
    void eliminarEstudianteMatriculado(Long idLibreta);
    
}
