<%-- 
    Document   : FondoColor
    Created on : 2 abr. 2020, 10:10:04
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    /*
    Declaración de parametros en JSP
    Si declaramos variables o metodos dentro 
    de este bloque con ! podemos definir parametros
    de clase y no locales al metodo _jspService
    que sería el equivalente al doPost/doGet 
    en nuestro servlet generado por un JSP
    */

    private int contador = 0;
    public int getContador(){
        return this.contador++;
    }

%>    

<%
    String fondo = request.getParameter("colorFondo");
    if(fondo == null || fondo.trim().equals("")){
        fondo =  "white";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP cambio de color</title>
    </head>
    <body bgcolor="<%= fondo %>">
        <h1>JSP cambio de color</h1>
        <br/>
        Color de fondo aplicado: <%= fondo %>
        <br/>
        <p>
            Valor del atributo declarado en este JSP: <%= this.getContador() %>
        </p>
        <br/>
        <a href="index.jsp">Volver atras</a>
    </body>
</html>
