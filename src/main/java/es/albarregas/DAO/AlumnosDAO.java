/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class AlumnosDAO implements IAlumnosDAO {

    @Override
    public ArrayList<Alumno> getAlumnos() {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "SELECT * FROM alumnos ";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                alumno.setIdAlumno(resultado.getInt("idAlumno"));
                lista.add(alumno);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<Alumno> getAlumnosEquipo() {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "SELECT nombre,grupo,marca,numSerie FROM alumnos left join equipos using(idEquipo)";
        Connection conexion = ConnectionFactory.getConnection();

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                //Ahora construimos el equipo
                Equipo equipo = new Equipo();
                equipo.setNumSerie(resultado.getString("numSerie"));
                equipo.setMarca(resultado.getString("marca"));
                alumno.setEquipo(equipo);
                lista.add(alumno);
            }
            resultado.close();
            //resultadoEquipo.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<Alumno> getAlumnosSinEquipo() {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "SELECT * FROM alumnos where idEquipo is null ";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                alumno.setIdAlumno(resultado.getInt("idAlumno"));
                lista.add(alumno);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public boolean insertAlumno(Alumno alumno) {
        String consulta = "insert into alumnos(nombre,grupo,idEquipo) values (?,?,?)";
        if (alumno.getEquipo() == null) {
            consulta = "insert into alumnos(nombre,grupo) values (?,?)";
        }
        PreparedStatement preparada;
        boolean resultado = false;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setString(1, alumno.getNombre());
            preparada.setString(2, alumno.getGrupo());
            if (alumno.getEquipo() != null) {
                preparada.setInt(3, alumno.getEquipo().getIdEquipo());
            }
            resultado = preparada.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    @Override
    public boolean updateAlumno(Alumno alumno) {
        String consulta = "UPDATE alumnos SET nombre=?, grupo=?,idEquipo=? WHERE idAlumno=? ";
        PreparedStatement preparada;
        boolean resultado = false;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setString(1, alumno.getNombre());
            preparada.setString(2, alumno.getGrupo());
            preparada.setInt(3, alumno.getEquipo().getIdEquipo());
            preparada.setInt(4, alumno.getIdAlumno());
            resultado = preparada.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteAlumno(Alumno alumno) {
        String consulta = "delete from alumnos where idAlumno = ?";
        PreparedStatement preparada;
        boolean resultado = false;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setInt(1, alumno.getIdAlumno());
            resultado = preparada.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno getAlumno(Alumno alumno) {
        Alumno alumno2 = null;
        try {
            String consulta = "select idAlumno,nombre,grupo from alumnos where idAlumno = ?";
            PreparedStatement preparada;
            ResultSet resultado;
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setInt(1, alumno.getIdAlumno());
            resultado = preparada.executeQuery();
            resultado.next();
            alumno2 = new Alumno();
            alumno2.setIdAlumno(resultado.getInt("idAlumno"));
            alumno2.setGrupo(resultado.getString("grupo"));
            alumno2.setNombre(resultado.getString("nombre"));
            resultado.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno2;
    }

    @Override
    public ArrayList<Alumno> getAlumnosPorEquipo() {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "SELECT nombre,grupo,marca,numSerie FROM alumnos inner join equipos using(idEquipo) order by 4";
        Connection conexion = ConnectionFactory.getConnection();

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                //Ahora construimos el equipo
                Equipo equipo = new Equipo();
                equipo.setNumSerie(resultado.getString("numSerie"));
                equipo.setMarca(resultado.getString("marca"));
                alumno.setEquipo(equipo);
                lista.add(alumno);
            }
            resultado.close();
            //resultadoEquipo.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }

        return lista;
    }

}
