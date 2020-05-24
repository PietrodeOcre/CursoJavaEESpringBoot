<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Leyendo valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP Leyendo valores del JavaBean</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br/>
        <br/>
        Valor base: <jsp:getProperty name="rectangulo" property="base" />
        <br/>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br/>
        Valor Area de rectangulo: <jsp:getProperty name="rectangulo" property="area" />
        <br/>
        <a href="index.jsp">Regresar a inicio</a>
    </body>
</html>
