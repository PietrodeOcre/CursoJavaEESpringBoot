<%-- 
    Document   : alcanceVariables
    Created on : 9 abr. 2020, 18:42:03
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Alcance Variables</h1>
        <br/>
        Variable Request:
        <br/>
        Base: ${rectanguloRequest.base}
        <br/>
        Altura: ${rectanguloRequest.altura}
        <br/>
        Area: ${rectanguloRequest.area}
        <br/>
        <br/>
        Variable Session:
        <br/>
        Base: ${rectanguloSession.base}
        <br/>
        Altura: ${rectanguloSession.altura}
        <br/>
        Area: ${rectanguloSession.area}
        <br/>
        <br/>
        Variable Application:
        <br/>
        Base: ${rectanguloApplication.base}
        <br/>
        Altura: ${rectanguloApplication.altura}
        <br/>
        Area: ${rectanguloApplication.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">
            Volver
        </a>
    </body>
</html>
