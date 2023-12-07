
package com.proyectoLenguajes.Service;

import com.proyectoLenguajes.domain.Estudiantes;
import com.proyectoLenguajes.domain.Libreta;
import java.util.List;

public interface LibretaService {
    public List<Estudiantes> obtenerTodosEstudiantes();
    
    List<Libreta> getAllLibretas();
    Libreta getLibretaById(Long id);
    
    void actualizarLibreta(Long idLibreta, int asistencia, String observaciones);
    
    void eliminarLibreta(Long idLibreta);
    
}
