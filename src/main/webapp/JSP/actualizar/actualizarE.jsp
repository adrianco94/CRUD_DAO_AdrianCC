

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar equipos</title>
    </head>
    <body>
        <h1>Actualizar Equipos:</h1>
        <form action="<c:url value = "/Controlador1"/>" method="post">
            <c:forEach items="${equipos}" var="equipo">
                <p> <input type="radio" name="actualizarEquipo" value="${equipo.idEquipo}"> ${equipo.marca} --- nºSerie: ${equipo.numSerie}</p>
            </c:forEach>
                <input type="submit" value="Actualizar Equipo" name="opcion">
                <input type="submit" value="Cancelar" name="opcion">
        </form>
    </body>
</html>
