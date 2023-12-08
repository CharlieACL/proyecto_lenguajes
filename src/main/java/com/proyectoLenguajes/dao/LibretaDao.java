
package com.proyectoLenguajes.dao;

import com.proyectoLenguajes.domain.Libreta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibretaDao extends JpaRepository<Libreta, Long> {
    
}
