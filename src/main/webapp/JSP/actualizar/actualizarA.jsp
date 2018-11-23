

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar alumnos</title>
    </head>
    <body>
        <h1>Actualizar Alumnos:</h1>
        <form action="<c:url value = "/Controlador1"/>" method="post">
            <c:forEach items="${alumnos}" var="alumno">
                <p> <input type="radio" name="actualizarAlumno" value="${alumno.idAlumno}"> ${alumno.nombre} --- ${alumno.grupo}</p>
                </c:forEach>
            <input type="submit" value="Actualizar Alumno" name="opcion">
            <input type="submit" value="Cancelar" name="opcion">
        </form>

    </body>
</html>
