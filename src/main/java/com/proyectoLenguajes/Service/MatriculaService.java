
package com.proyectoLenguajes.Service;


public interface MatriculaService {
    
    void insertarMatricula(String nombre, String apellido,String telefono, String correo, String direccion,
            String nombreEst, String apellidoEst, String nivelEst , String alegiasEst, String condicionEst, int edadEst, Long idEncargadoEst,
            Long idEstudianteLi);
    
    void insertarEstudiante(String nombre, String apellido, String nivel , String alegias, String condicion, int edad, Long idEncargado,
            Long idEstudianteLi);
    
     void insertarLibreta(int asistencia, String observaciones, Long idEstudiante);
    

}
