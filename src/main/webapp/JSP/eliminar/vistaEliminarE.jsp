<%-- 
    Document   : vistaEliminarE
    Created on : 23-nov-2018, 3:11:43
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
         <h1>Se han eliminado correctamente los siguientes:</h1>
        <c:forEach items="${equipos}" var="equipo">
            <p><c:out value="${equipo.marca}"/>--- nºSerie: <c:out value="${equipo.numSerie}"/></p>
        </c:forEach>
            <a href="<c:url value="index.jsp"/>">Volver menú</a>
    </body>
</html>
