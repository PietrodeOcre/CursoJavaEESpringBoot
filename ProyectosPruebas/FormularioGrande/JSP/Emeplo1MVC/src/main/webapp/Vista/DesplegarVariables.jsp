<%-- 
    Document   : DesplegarVariables
    Created on : 9 abr. 2020, 8:54:07
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        Variable en el alcance de Request:
        ${mensaje}
        <br/> 
        Variable en alcance de sesión: Rectangulo
        <br/>
        Base: ${rectangulo.base}
        <br/>
        Altura: ${rectangulo.altura}
        <br/>
        Area: ${rectangulo.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver</a>
    </body>
</html>
