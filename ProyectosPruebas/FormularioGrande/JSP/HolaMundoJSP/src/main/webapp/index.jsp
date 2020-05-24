<%-- 
    Document   : index
    Created on : 1 abr. 2020, 13:28:15
    Author     : pietrodeocre
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Hola mundo con JSP Page</title>
    </head>
    <body>
        <h1>Hola mundo con JSP Page</h1>
        <ul>
            <li>
                <% out.println("Hola mundo con JSP con Scriptlets"); %>
            </li>
            <li>
                ${"Hola mundo con Expresion Languaje"}
            </li>
            <li>
                <%= "Hola mundo con expresiones" %>
            </li>
            <li>
                <c:out value="Hola mundo con JSTL" />
            </li>
            <li>
                <% out.println(request.getCookies()[0].getName() + ": " + request.getCookies()[0].getValue()); %>
            </li>
            <li>
                <% out.println(session.getAttribute(request.getCookies()[0].getName())); %>
            </li>
            <li>
                <a href="Expresiones.jsp">Link a JSP de Expresiones</a>
                <br/>
                <h4>Formulario HTML</h4>
                <form name="forma1" action="ProcesaFormulario.jsp">
                    Usuario: <input type="text" name="usuario">
                    <br/>
                    Password: <input type="password" name="password">
                    <br/>
                    <input type="submit" value="Enviar">
                </form>
            </li>
            <li>
                <a href="Scriptlets.jsp">Ejemplos de Scriptlets</a>
            </li>
            <li>
                <form action="FondoColor.jsp">
                    Proporciona el color de fondo(Ej. red, blue, yellow, white, etc)
                    <input type="text" name="colorFondo">
                    <br/>
                    <input type="submit" value="Enviar">
                </form>
            </li>
            <li>
                <a href="documentoJSP.jspx">Ejemplos de JSPX</a>
            </li>
            <li>
                <a href="ReporteExcel.jsp">Generación de reporte Excel</a>
            </li>
        </ul>
    </body>
</html>
