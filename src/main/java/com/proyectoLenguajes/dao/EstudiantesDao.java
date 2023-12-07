
package com.proyectoLenguajes.dao;

import com.proyectoLenguajes.domain.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudiantesDao extends JpaRepository<Estudiantes,Long> {
    
}
