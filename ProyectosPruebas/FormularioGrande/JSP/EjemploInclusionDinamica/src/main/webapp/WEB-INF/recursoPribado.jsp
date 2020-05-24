<%
    //Recojemos el parametro que aparece en el index.jsp
    String colorFondo =  request.getParameter("colorfondo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="<%= colorFondo %>">
        <h1>Hello World!</h1>
    </body>
</html>
