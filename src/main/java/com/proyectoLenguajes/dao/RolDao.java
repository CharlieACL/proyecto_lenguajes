
package com.proyectoLenguajes.dao;
import com.proyectoLenguajes.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {
    
}
