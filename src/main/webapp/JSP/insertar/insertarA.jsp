
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Alumnos</title>
    </head>
    <body>
        <h1>Insertar Alumno</h1>
        <h3>(Deben estar rellenos los dos campos para insertar)</h3>
        <form action="<c:url value = "/Controlador1"/>" method="post">
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
            <input type="submit" name="opcion" value="Insertar Alumno"> 
            <input type="submit" name="opcion" value="Cancelar"> 
        </form>
    </body>
</html>
