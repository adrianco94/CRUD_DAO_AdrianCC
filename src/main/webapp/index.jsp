<%-- 
    Document   : index
    Created on : 21-nov-2018, 21:48:58
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD EquiposDept</title>
    </head>
    <body>
        <h1>CRUD EquiposDept</h1>
        <h3>1. Insertar</h3>
        <p>
            a. <a href="<c:url value = "/Eleccion?opcion=insertarA"/>">Alumnos</a>
            b. <a href="<c:url value = "/Eleccion?opcion=insertarE"/>">Equipos</a>
        </p>
        <h3>2. Actualizar</h3>
        <p>
            a. <a href="<c:url value = "/Eleccion?opcion=actualizarA"/>">Alumnos</a>
            b. <a href="<c:url value = "/Eleccion?opcion=actualizarE"/>">Equipos</a>
        </p>
        <h3>3. Eliminar</h3>
        <p>
            a. <a href="<c:url value = "/Eleccion?opcion=eliminarA"/>">Alumnos</a>
            b. <a href="<c:url value = "/Eleccion?opcion=eliminarE"/>">Equipos</a>
        </p>
        <h3>4. Visualizar</h3>
        <p>
            a. <a href="<c:url value = "/Eleccion?opcion=visualizarA"/>">Alumnos</a><br>
            b. <a href="<c:url value = "/Eleccion?opcion=visualizarE"/>">Equipos</a><br>
            c. <a href="<c:url value = "/Eleccion?opcion=visualizarAE"/>">Alumnos y Equipos Asociados</a><br>
            d. <a href="<c:url value = "/Eleccion?opcion=visualizarApE"/>">Alumnos por Equipo</a><br>
            e. <a href="<c:url value = "/Eleccion?opcion=visualizarAsE"/>">Alumnos sin Equipo</a><br>
        </p>

    </body>
</html>
