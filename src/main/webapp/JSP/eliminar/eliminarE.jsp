<%-- 
    Document   : eliminarE
    Created on : 23-nov-2018, 2:51:45
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Equipos</title>
    </head>
    <body>
        <h1>Eliminar Equipos:</h1>
        <form action="<c:url value = "/Controlador1"/>" method="post">
            <c:forEach items="${equipos}" var="equipo">
                <p> <input type="checkbox" name="eliminarEquipos" value="${equipo.idEquipo}"> ${equipo.marca} --- nºSerie: ${equipo.numSerie}</p>
            </c:forEach>
                <input type="submit" value="Eliminar Equipos" name="opcion">
                <input type="submit" value="Cancelar" name="opcion">
        </form>
    </body>
</html>
