<%-- 
    Document   : listadoPersonas
    Created on : 19 abr. 2020, 19:36:27
    Author     : pietrodeocre
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Personas</title>
    </head>
    <body>
        <h1>Listado de Personas</h1>

        <ul>

            <c:forEach items="${personas}" var="persona">
                <li>
                    ${persona.nombre} ${persona.apellido}
                </li>
            </c:forEach>

        </ul>

    </body>
</html>
