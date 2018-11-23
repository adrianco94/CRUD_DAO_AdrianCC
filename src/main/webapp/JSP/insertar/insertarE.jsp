
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insertar Equipo</h1>
        <form action="<c:url value = "/Controlador1"/>" method="post">
            <label for="marca">Marca:</label>
            <input type="text" name="marca" id="marca" value="${equipo.marca}">
            <label for="numSerie">Nº Serie:</label>
            <input type="text" name="numSerie" id="numSerie" value="${equipo.numSerie}">
            <input type="submit" name="opcion" value="Insertar Equipo"> 
            <input type="submit" name="opcion" value="Cancelar"> 
        </form>      
    </body>
</html>
