/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pietrodeocre
 */
@WebServlet("/ServerHeaders")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String metofoHttp = request.getMethod();
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<title>Cabecera HTTP</title>");
        out.println("</head>");
        out.println("<body>");
        
        //Metodo de envio (get o Post)
        out.println("<h1>Headers HTTP</h1>");
        out.println("<p>Método Http: " + metofoHttp + "</p>");
        
        //Direccion a la que se accede
        String uri = request.getRequestURI();
        out.println("<p>Uri solicitada: " + uri + "</p>");
        
        //Ip a la cual se accece
        String ip = request.getRemoteAddr();
        out.println("<p>IP solicitada: " + ip + "</p>");
        
        //Imprimir todos los cabeceros disponibles
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombrecabecero = (String)cabeceros.nextElement();
            out.println("<b>" + nombrecabecero + ": </b>" + request.getHeader(nombrecabecero) + "<br/>");
            
        }
        
        Cookie cook = new Cookie("Cabecero", "Valor1");
        Cookie cook1 = new Cookie("Cabecero2", "Valor2");
        Cookie cook2;
        cook2 = new Cookie(ip, "hola");
                
        response.addCookie(cook);
        response.addCookie(cook2);
        
        //Indica el codigo de respuesta hacia el cliente por ejemplo un error
        //Tambien se puede mandar un mensaje de error
        response.sendError(500, "No hay web");
        
        
        //MEnsaje de estado del servidor
        //response.setStatus(403);
        
        //Mandar un error 302 que redirije a otra direccion
        //response.sendRedirect(uri);
        
        out.println("</body>");
        out.println("</html>");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
