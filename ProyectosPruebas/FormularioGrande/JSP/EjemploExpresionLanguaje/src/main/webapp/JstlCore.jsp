<%-- 
    Document   : JstlCore
    Created on : 8 abr. 2020, 10:41:24
    Author     : pietrodeocre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core(JSP Standar Tag Library)</h1>
        <br/>
        <!-- Manipulacion de Variables -->
        <ul>
            <li>
                <!-- Definimos una variable -->
                <c:set var="nombre" value="Manuel" />
                <!-- Mostramos el valor de una variable -->
                Variable Nombre: <c:out value="${nombre}" />
            </li>
            <li>
                <!-- Variable con codigo html -->
                <c:set var="saludo" value="<h4>Hola</h4>" />
                <!-- Mostramos el valor de una variable sin escapeXml -->
                Variable Con codigo HTML: <c:out value="${saludo}" escapeXml="true" />
                <br/>
                <!-- Mostramos el valor de una variable con escapeXml -->
                Variable Con codigo HTML: <c:out value="${saludo}" escapeXml="false" />
            </li>
            <li>
                <!-- Codigo condicionado, Uso de if -->
                <c:set var="bandera" value="true" />
                <!-- Mostramos el valor de una variable -->
                Variable Nombre: <c:if test="${bandera}" >
                    La bandera es verdadera
                </c:if>
                <br/>
                <!-- Codigo condicionado, Uso de if -->
                <c:set var="bandera" value="false" />
                <!-- Mostramos el valor de una variable -->
                Variable Nombre: <c:if test="${!bandera}" >
                    La bandera no es verdadera
                </c:if>    
            </li>
            <li>
                Usando If: <br/>
                <!-- Codigo condicionado, Uso de if -->
                <c:set var="bandera" value="true" />
                <!-- Mostramos el valor de una variable -->
                Variable Nombre: <c:if test="${bandera}" >
                    La bandera es verdadera
                </c:if>
            </li>
            <li>
                <!-- Codigo condicionado, Uso de switch -->
                Usando Switch: <br/>
                <!-- Mostramos el valor de una variable del index.jsp -->
                Variable Nombre: <c:if test="${param.opcion != null}" >
                    <c:choose>
                        <c:when test="${param.opcion ==1}">                            
                            Opcion 1 seleccionada
                        </c:when>
                        <c:when test="${param.opcion ==2}">
                            Opcion 2 seleccionada
                        </c:when>
                        <c:otherwise>
                            Opcion proporcionada desconocida: ${param.opcion}
                        </c:otherwise>
                    </c:choose>
                </c:if>    
            </li>
            <li>
                <!-- Codigo Iterando arreglo -->
                <%
                String nombres[] = {"Claudia", "Pedro", "Juan"};
                request.setAttribute("nombres", nombres);
                %>
                <br/>
                Lista de nombres:
                <br/>
                <ul>
                    <c:forEach var="nombre" items="${nombres}" >
                        <li>
                            Nombre: ${nombre}
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </ul>
        <br/>
        <a href="index.jsp">Volver</a>
    </body>
</html>
