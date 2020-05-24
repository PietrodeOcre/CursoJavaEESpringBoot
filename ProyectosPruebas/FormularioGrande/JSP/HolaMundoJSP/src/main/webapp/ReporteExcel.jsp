

<!-- 
La directiva de errorPage le indica a este JSP 
donde podemos mandar los posibles errores 
Si no la colocamos no podremos manejar errores
en ningun jsp normal.
-->
<%@page errorPage="/WEB-INF/ManejoErrores.jsp" %>

<%@page import="Utilerias.Conversiones, java.util.Date" %>

<%@page contentType="application/vnd.ms-excel" %>

<%
    String nombreArchivo = "reporte.xls";
    //response.setHeader("Content-Disposition", "Attachment;filename" + nombreArchivo);
    //Con este cambio del atributo attachment podemos redirigir en caso de error al JSP en este caso el de error
    response.setHeader("Content-Disposition", "inline;filename" + nombreArchivo);
%>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Reporte Excel</title>
    </head>
    <body>
        <h1>Reporte Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>
                    Curso
                </th>
                <th>
                    Descripción
                </th>
                <th>
                    Fecha
                </th>
            </tr>
            <tr>
                <td>
                    1. Fundamentos de java
                </td>
                <td>
                    Aprendemos la sintaxsis básica de Java
                </td>
                <td>
                    <!-- 
                        Estamos generando un error a posta
                        al introducir una cadena de texto en el formato de una fecha
                        hemos sobrecargado el método para que nos lo permita 
                        pero aun así el método detecta que noe s un formato 
                        valido y marca error que recogemos con errorPage
                        En otro jsp desde el cual mostramso el error 
                        preformateado.
                        Si no se hiciera esto, y el metodo fuera correcto generará un reporte
                        En excel con los datos de la tabla que se está mostrando.
                    -->
                    <%= 
                        //Conversiones.formato_Date("500")
                        Conversiones.formato_Date(new Date())
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    2. Fundamentos de java
                </td>
                <td>
                    Pondremos en páctica conceptos de la programación orientada a objetos
                </td>
                <td>
                    <%= Conversiones.formato_Date(new Date()) %>
                </td>
            </tr>
        </table>
    </body>
</html>
