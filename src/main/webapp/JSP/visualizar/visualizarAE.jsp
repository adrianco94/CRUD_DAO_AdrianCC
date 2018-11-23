<%-- 
    Document   : visualizarAE
    Created on : 23-nov-2018, 5:55:22
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alumnos y Equipos Asociados:</h1>
        <c:forEach items="${alumnos}" var="alumno" >
            <p>Alumno: <c:out value="${alumno.nombre}"/> Grupo: <c:out value="${alumno.grupo}"/>
                ---   <c:out value="${alumno.equipo.marca}"/> <c:out value="${alumno.equipo.numSerie}" default="Sin equipo"/>
            </p>
        </c:forEach>
        <a href="<c:url value="index.jsp"/>">Volver</a>
    </body>
</html>
