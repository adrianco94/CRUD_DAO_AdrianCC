/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author USUARIO
 */
public class ConnectionFactory {

    //static final String DATASOURCE_NAME_MYSQL = "java:comp/env/jdbc/jndi";
    //static final String DATASOURCE_NAME_DERBY = "java:comp/env/jdbc/derby/jndi";

    public static Connection getConnection() {
        Connection conexion = null;
        DataSource datasource = null;

        try {
            Context contextoInicial = new InitialContext();
            datasource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/jndi");
            conexion = datasource.getConnection();

        } catch (NamingException e) {
            System.out.println("Problemas en el acceso a la BD");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problemas en el acceso a la BD");
            ex.printStackTrace();
        }

        return conexion;

    }

    public static void cerrarConexion(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
