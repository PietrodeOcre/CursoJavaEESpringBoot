<%-- 
    Document   : Expresiones
    Created on : 1 abr. 2020, 18:20:17
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP con expresiones</title>
    </head>
    <body>
        <h1>JSP con expresiones</h1>
        Concatenación = <%= "Saludos" + " " + "JSP"   %>
        <br/>
        Operación matemática <%= 2 * 3 / 2 %>
        <br/>
        Sesion ID: <%= session.getId() %>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
