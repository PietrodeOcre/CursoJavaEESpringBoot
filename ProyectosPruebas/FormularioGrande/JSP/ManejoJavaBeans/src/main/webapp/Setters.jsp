<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica un JavaBeans</title>
    </head>
    <body>
        <h1>JSP que modifica un JavaBeans</h1>
        <br/>
        <!-- 
        Creamos un objeto de tipo rectangulo con nombre rectangulo 
        Ahora bien, cuando usamos el parametro scope le decimos a nuestro
        JSP que el alcance de nuestro objeto es hasta que se pase el tiempo de 
        sesion, una vez pasado el objeto se destruye y al volver a entrar 
        en este jsp se crea uno nuevo.
        Si pusieramos un request en lugar de un session, nuestro JSP se
        ejecutaria en esa peticion al servidor, al volver atras y 
        pulsar en el otro link seria otro request y por tanto otro objeto 
        diferente, con lo cual nuestras propiedades(atributos) no serian 
        los mismos y estarian vacios a cero
        -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br/>
        <br/>
        Modificamos los atributos:
        <br/>
        <br/>
        <% 
            //Creamos dos variables locales para usarlas como valores de las propiedades
            int baseValor = 5;
            int alturaValor = 10;
        %>
        <!-- Asignamos valores a los atributos que el profesor llama propiedades -->
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>" />
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>" />
        
        Nuevo valor de base: <%=baseValor%>
        <br/>
        Nuevo valor de altura: <%=alturaValor%>
        <br/>
        <a href="index.jsp">Regresar a inicio</a>
    </body>
</html>
