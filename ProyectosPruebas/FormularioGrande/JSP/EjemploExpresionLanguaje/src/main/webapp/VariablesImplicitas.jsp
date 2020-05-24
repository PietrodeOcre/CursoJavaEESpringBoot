<%-- 
    Document   : VariablesImplicitas
    Created on : 8 abr. 2020, 9:31:20
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expr-LANG variables implicitas</title>
    </head>
    <body>
        <h1>Expr-LANG variables implicitas</h1>
        <ul>
            <li>
                Nombre de la aplicación: ${pageContext.request.contextPath}
            </li>
            <li>
                Navegador del cliente: ${header["User-agent"]}
            </li>
            <li>
                ID Cookies: ${cookie.JSESSIONID.value}
            </li>
            <li>
                Web Server: ${pageContext.servletContext.serverInfo}
            </li>
            <li>
                <!-- Se puede llamar al parametro asi -->
                Valor Parametro: ${param.usuario}
            </li>
            <li>
                <!-- o se puede llamar en forma de array -->
                Valor Parametro: ${param["usuario"]}
            </li>
        </ul>
        <br/>
        <a href="index.jsp">Volver</a>
    </body>
</html>
