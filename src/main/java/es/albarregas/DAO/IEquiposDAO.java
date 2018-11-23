/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Equipo;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IEquiposDAO {

    public ArrayList<Equipo> getEquipos();

    public ArrayList<Equipo> getEquiposSinAlumnos();

    public boolean insertEquipo(Equipo equipo);

    public boolean updateEquipo(Equipo equipo);

    public boolean deleteEquipo(Equipo equipos);
    
    public Equipo getEquipo(Equipo equipo);

}
