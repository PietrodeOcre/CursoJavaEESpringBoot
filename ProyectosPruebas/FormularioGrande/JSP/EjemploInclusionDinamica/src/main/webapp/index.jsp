<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusi�n din�mica</title>
    </head>
    <body>
        <h1>Ejemplo Inclusi�n din�mica</h1>
        <br/>
        <jsp:include page="paginas/RecursoPublicoJSP.jsp" />
        <br/>
        <!-- Este parametro vamso a poder usarl en el JSP correspondiente -->
        <jsp:include page="WEB-INF/recursoPribado.jsp">
            <jsp:param name="colorfondo" value="yellow" />
        </jsp:include>
    </body>
</html>
