

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualizar Alumno</h1>
        <h3>(Deben estar rellenos los dos campos para insertar)</h3>
        <form action="<c:url value = "/Controlador2"/>" method="post">
            <input hidden="hidden" name="idAlumno" value="${alumno.idAlumno}">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre" value="${alumno.nombre}">
            <label for="grupo">Grupo:</label>
            <input type="text" name="grupo" id="grupo" value="${alumno.grupo}">
            <select name="equipo">
                <option value="0" selected="">Sin equipo</option>
                <c:forEach items="${equipos}" var="equipo">

                    <option value="${equipo.idEquipo}"><c:out value="${equipo.marca} - NºSerie: ${equipo.numSerie}"/></option>

                </c:forEach>
            </select> 
            <br>
            <input type="submit" name="opcion" value="Actualizar Alumno"> 
            <input type="submit" name="opcion" value="Cancelar"> 
        </form>
    </body>
</html>
