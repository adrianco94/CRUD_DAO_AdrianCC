

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Equipo</title>
    </head>
    <body>
       <h1>Actualizar Equipo</h1>
        <form action="<c:url value = "/Controlador2"/>" method="post">
            <input hidden="hidden" name="idEquipo" value="${equipo.idEquipo}">
            <label for="marca">Marca:</label>
            <input type="text" name="marca" id="marca" value="${equipo.marca}">
            <label for="numSerie">Nº Serie:</label>
            <input type="text" name="numSerie" id="numSerie" value="${equipo.numSerie}">
            <input type="submit" name="opcion" value="Actualizar Equipo"> 
            <input type="submit" name="opcion" value="Cancelar"> 
        </form>  
    </body>
</html>
