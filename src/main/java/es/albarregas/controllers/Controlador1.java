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
@WebServlet(name = "Controlador1", urlPatterns = {"/Controlador1"})
public class Controlador1 extends HttpServlet {

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
            out.println("<title>Servlet Controlador1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador1 at " + request.getContextPath() + "</h1>");
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
        String opcion = request.getParameter("opcion");
        String url = "";
        if (!opcion.equals("Cancelar")) {
            if (opcion.equals("Insertar Alumno")) {
                if (request.getParameter("grupo").equals("") || request.getParameter("nombre").equals("")) {
                    IEquiposDAO edao = new EquiposDAO();
                    ArrayList<Equipo> equipos = edao.getEquipos();
                    request.setAttribute("equipos", equipos);
                    Alumno alumno = new Alumno();
                    alumno.setGrupo(request.getParameter("grupo"));
                    alumno.setNombre(request.getParameter("nombre"));
                    request.setAttribute("alumno", alumno);
                    url = "JSP/insertar/insertarA.jsp";
                } else {
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
                    adao.insertAlumno(alumno);
                    url = "JSP/insertar/vistaInsertar.jsp";
                }

            } else if (opcion.equals("Insertar Equipo")) {

                if (request.getParameter("marca").equals("") || request.getParameter("numSerie").equals("")) {
                    Equipo equipo = new Equipo();
                    equipo.setMarca(request.getParameter("marca"));
                    equipo.setNumSerie(request.getParameter("numSerie"));
                    request.setAttribute("equipo", equipo);
                    url = "JSP/insertar/insertarE.jsp";
                } else {
                    IEquiposDAO edao = new EquiposDAO();
                    Equipo equipo = new Equipo();
                    equipo.setMarca(request.getParameter("marca"));
                    equipo.setNumSerie(request.getParameter("numSerie"));
                    edao.insertEquipo(equipo);
                    url = "JSP/insertar/vistaInsertar.jsp";
                }

            } else if (opcion.equals("Eliminar Alumnos")) {
                IAlumnosDAO adao = new AlumnosDAO();
                if (request.getParameter("eliminarAlumnos") == null) {
                    ArrayList<Alumno> alumnos = adao.getAlumnos();
                    request.setAttribute("alumnos", alumnos);
                    url = "JSP/eliminar/eliminarA.jsp";

                } else {
                    Alumno alumno;
                    ArrayList<Alumno> alumnos = null;
                    for (String idAlumno : request.getParameterValues("eliminarAlumnos")) {
                        alumno = new Alumno();
                        alumno.setIdAlumno(Integer.parseInt(idAlumno));
                        //Alumno alumnos2 = adao.getAlumno(alumno);
                        //alumnos.add(alumnos2);
                        adao.deleteAlumno(alumno);
                    }
                    request.setAttribute("alumnos", alumnos);
                    url = "JSP/eliminar/vistaEliminarA.jsp";
                }
            } else if (opcion.equals("Eliminar Equipos")) {
                IEquiposDAO edao = new EquiposDAO();
                if (request.getParameter("eliminarEquipos") == null) {
                    ArrayList<Equipo> equipos = edao.getEquipos();
                    request.setAttribute("equipos", equipos);
                    url = "JSP/eliminar/eliminarE.jsp";

                } else {
                    Equipo equipo;
                    ArrayList<Equipo> equipos = null;
                    for (String idEquipo : request.getParameterValues("eliminarEquipos")) {
                        equipo = new Equipo();
                        equipo.setIdEquipo(Integer.parseInt(idEquipo));
                        //Equipo equipo2 = edao.getEquipo(equipo);
                        //equipos.add(equipos2);
                        edao.deleteEquipo(equipo);
                    }
                    request.setAttribute("equipos", equipos);
                    url = "JSP/eliminar/vistaEliminarE.jsp";
                }
            } else if (opcion.equals("Actualizar Alumno")) {
                IEquiposDAO edao = new EquiposDAO();
                ArrayList<Equipo> equipos = edao.getEquipos();
                request.setAttribute("equipos", equipos);

                IAlumnosDAO adao = new AlumnosDAO();
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(Integer.parseInt(request.getParameter("actualizarAlumno")));
                Alumno alumno2 = adao.getAlumno(alumno);
                request.setAttribute("alumno", alumno2);

                url = "JSP/actualizar/leerActualizarA.jsp";
            } else if (opcion.equals("Actualizar Equipo")) {
                IEquiposDAO edao = new EquiposDAO();
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(Integer.parseInt(request.getParameter("actualizarEquipo")));
                Equipo equipo2 = edao.getEquipo(equipo);
                request.setAttribute("equipo", equipo2);
                url = "JSP/actualizar/leerActualizarE.jsp";
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
