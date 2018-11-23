/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.AlumnosDAO;
import es.albarregas.DAO.EquiposDAO;
import es.albarregas.DAO.IAlumnosDAO;
import es.albarregas.DAO.IEquiposDAO;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eleccion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Eleccion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
         */
        String opcion = request.getParameter("opcion");
        String url = "";

        if (opcion.equals("insertarA")) {
            IEquiposDAO edao = new EquiposDAO();
            ArrayList<Equipo> equipos = edao.getEquipos();
            request.setAttribute("equipos", equipos);
            url = "JSP/insertar/insertarA.jsp";

        } else if (opcion.equals("insertarE")) {
            url = "JSP/insertar/insertarE.jsp";
        } else if (opcion.equals("eliminarA")) {

            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnos();
            request.setAttribute("alumnos", alumnos);
            url = "JSP/eliminar/eliminarA.jsp";

        } else if (opcion.equals("eliminarE")) {
            url = "JSP/eliminar/eliminarE.jsp";
            IEquiposDAO edao = new EquiposDAO();
            ArrayList<Equipo> equipos = edao.getEquipos();
            request.setAttribute("equipos", equipos);
        } else if (opcion.equals("actualizarA")) {

            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnos();
            request.setAttribute("alumnos", alumnos);
            url = "JSP/actualizar/actualizarA.jsp";

        } else if (opcion.equals("actualizarE")) {
            url = "JSP/actualizar/actualizarE.jsp";
            IEquiposDAO edao = new EquiposDAO();
            ArrayList<Equipo> equipos = edao.getEquipos();
            request.setAttribute("equipos", equipos);
        } else if (opcion.equals("visualizarA")) {
            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnos();
            request.setAttribute("alumnos", alumnos);
            url = "JSP/visualizar/visualizarA.jsp";
        } else if (opcion.equals("visualizarE")) {
            IEquiposDAO edao = new EquiposDAO();
            ArrayList<Equipo> equipos = edao.getEquipos();
            request.setAttribute("equipos", equipos);
            url = "JSP/visualizar/visualizarE.jsp";
        } else if (opcion.equals("visualizarAE")) {
            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnosEquipo();
            request.setAttribute("alumnos", alumnos);
            url = "JSP/visualizar/visualizarAE.jsp";
        } else if (opcion.equals("visualizarApE")) {
            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnosPorEquipo();
            request.setAttribute("alumnos", alumnos);
            url = "JSP/visualizar/visualizarAE.jsp";

        } else if (opcion.equals("visualizarAsE")) {
            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnosSinEquipo();
            request.setAttribute("alumnos", alumnos);
            url = "JSP/visualizar/visualizarA.jsp";

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
