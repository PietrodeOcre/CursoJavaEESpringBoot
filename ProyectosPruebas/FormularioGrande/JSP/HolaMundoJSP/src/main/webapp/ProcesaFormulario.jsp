<%-- 
    Document   : ProcesaFormulario
    Created on : 1 abr. 2020, 18:20:39
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formulario</h1>
        Usuario: <%= request.getParameter("usuario") %>
        <br/>
        Password: <%= request.getParameter("password") %>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
