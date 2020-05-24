<%-- 
    Document   : Scriptlets
    Created on : 2 abr. 2020, 10:10:58
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Scriptlets</title>
    </head>
    <body>
        <h1>Ejemplo de Scriptlets</h1>
        <br/>
        <%-- Scriptlets para enviar información al navegador --%>
        <% 
            out.println("Saludos desde un Scriptlet");
        %>
        <%-- 
            Scriptlets para manupular objetos implicitos
            como el objeto out que hemos usado antes
        --%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.println("Nombre de la aplicación " + nombreAplicacion);
        %>
        <br/>
        <%-- Scriptlets con código condicionado --%>
        <% 
            if(session != null && session.isNew()){
        %>
        La sesión es nueva
        <% 
            }else if(session !=null){
        %>
        La sesion NO es nueva
        <%
            }
        %>
        <br/>
        <a href="index.jsp">Volver atras</a>
    </body>
</html>
