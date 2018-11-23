<%-- 
    Document   : visualizarA
    Created on : 23-nov-2018, 5:39:58
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
        <h1>Alumnos:</h1>
        <c:forEach items="${alumnos}" var="alumno">
            <p> <c:out value="${alumno.nombre}"/>---<c:out value="${alumno.grupo}"/></p>
        </c:forEach>
        <a href="<c:url value="index.jsp"/>">Volver</a>
    </body>
</html>
