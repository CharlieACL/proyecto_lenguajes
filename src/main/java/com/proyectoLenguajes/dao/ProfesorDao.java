/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoLenguajes.dao;

import com.proyectoLenguajes.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfesorDao extends JpaRepository<Profesor, Long>{
    
}
