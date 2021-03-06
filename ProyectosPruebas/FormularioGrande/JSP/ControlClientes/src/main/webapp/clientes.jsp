<%-- 
    Document   : clientes
    Created on : 13 abr. 2020, 9:50:35
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/ee44a0b05b.js" crossorigin="anonymous"></script>
        <title>Control de Clientes</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>

        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>

        <ul>
            <c:forEach var="cliente" items="${clientes}">
                <li>
                    ${cliente.idCliente} ${cliente.nombre} ${cliente.apellido} ${cliente.saldo}
                </li>
            </c:forEach>
        </ul>
        
        <footer id="pie-pagina" class="bg-warning text-white mt-5 p-5">
            <div class="container">
                <div class="col">
                    <p class="lead text-center">CopyRight &copy; Workinginweb.com</p>
                </div>
            </div>
        </footer>
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
