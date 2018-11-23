/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Equipo;
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
public class EquiposDAO implements IEquiposDAO {

    @Override
    public ArrayList<Equipo> getEquipos() {
        ArrayList<Equipo> lista = new ArrayList();
        String consulta = "select * from equipos";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            while (resultado.next()) {
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(resultado.getInt("idEquipo"));
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));
                lista.add(equipo);
            }
            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<Equipo> getEquiposSinAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertEquipo(Equipo equipo) {

        String consulta = "insert into equipos(marca,numSerie) values (?,?)";

        PreparedStatement preparada;
        boolean resultado = false;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setString(1, equipo.getMarca());
            preparada.setString(2, equipo.getNumSerie());
            resultado = preparada.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    @Override
    public boolean updateEquipo(Equipo equipo) {
        String consulta = "UPDATE equipos SET marca=?, numSerie=? WHERE idEquipo=? ";
        PreparedStatement preparada;
        boolean resultado = false;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setString(1, equipo.getMarca());
            preparada.setString(2, equipo.getNumSerie());
            preparada.setInt(3, equipo.getIdEquipo());
            resultado = preparada.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteEquipo(Equipo equipo) {
        String consulta = "delete from equipos where idEquipo = ?";
        PreparedStatement preparada;
        boolean resultado = false;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setInt(1, equipo.getIdEquipo());
            resultado = preparada.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public Equipo getEquipo(Equipo equipo) {
        Equipo equipo2 = null;
        try {
            String consulta = "select idEquipo,marca,numSerie from equipos where idEquipo = ?";
            PreparedStatement preparada;
            ResultSet resultado;
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setInt(1, equipo.getIdEquipo());
            resultado = preparada.executeQuery();
            resultado.next();
            equipo2 = new Equipo();
            equipo2.setIdEquipo(resultado.getInt("idEquipo"));
            equipo2.setMarca(resultado.getString("marca"));
            equipo2.setNumSerie(resultado.getString("numSerie"));
            resultado.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipo2;
    }

}
