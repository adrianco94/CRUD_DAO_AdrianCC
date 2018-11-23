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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "Controlador2", urlPatterns = {"/Controlador2"})
public class Controlador2 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        String url = "";
        String opcion = request.getParameter("opcion");
        if (!opcion.equals("Cancelar")) {
            if (opcion.equals("Actualizar Alumno")) {
                IAlumnosDAO adao = new AlumnosDAO();
                Alumno alumno = new Alumno();
                alumno.setGrupo(request.getParameter("grupo"));
                alumno.setNombre(request.getParameter("nombre"));
                Equipo equipo = null;
                if (!request.getParameter("equipo").equals("0")) {
                    equipo = new Equipo();
                    equipo.setIdEquipo(Integer.parseInt(request.getParameter("equipo")));

                }
                alumno.setEquipo(equipo);
                alumno.setIdAlumno(Integer.parseInt(request.getParameter("idAlumno")));
                adao.updateAlumno(alumno);
                url = "JSP/actualizar/vistaActualizar.jsp";
            } else {
                IEquiposDAO edao = new EquiposDAO();
                Equipo equipo = new Equipo();
                equipo.setMarca(request.getParameter("marca"));
                equipo.setNumSerie(request.getParameter("numSerie"));
                equipo.setIdEquipo(Integer.parseInt(request.getParameter("idEquipo")));
                edao.updateEquipo(equipo);
                url = "JSP/actualizar/vistaActualizar.jsp";

            }
        }
        request.getRequestDispatcher(url).forward(request, response);
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
