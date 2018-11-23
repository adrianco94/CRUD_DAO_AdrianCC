/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Alumno;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IAlumnosDAO {

    public ArrayList<Alumno> getAlumnos();

    public ArrayList<Alumno> getAlumnosEquipo();
    
    public ArrayList<Alumno> getAlumnosSinEquipo();
    
    public boolean insertAlumno(Alumno alumno);

    public boolean updateAlumno(Alumno alumno);

    public boolean deleteAlumno(Alumno alumnos);
    
    public Alumno getAlumno(Alumno alumno);
    
    public ArrayList<Alumno> getAlumnosPorEquipo();
    

    public void closeConnection();

}
