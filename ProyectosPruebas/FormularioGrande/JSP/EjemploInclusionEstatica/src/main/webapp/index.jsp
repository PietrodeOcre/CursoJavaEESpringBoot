<%-- 
    Document   : index
    Created on : 5 abr. 2020, 14:22:34
    Author     : pietrodeocre
--%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Ejemplo Inclusión Estática</title>
        <meta charset="UTF-8" content="text/html">
    </head>
    <body>
        <h1>Ejemplo Inclusión Estática</h1>
        <br/>
        <ul>
            <li>
                <%@include file="paginas/Noticias2.jsp" %>
            </li>
            <li>
                <%@include file="paginas/Noticias1.html" %>
            </li>
            
        </ul>
    </body>
</html>
