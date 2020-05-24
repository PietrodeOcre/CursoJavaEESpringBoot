/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pietrodeocre
 */
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        
        //Contador de visitas
        int contador = 0;
        
        //Obtenemso las cookies
        Cookie cookie[] = request.getCookies();
        
        //Buscamos si existe otra cookie llamada "//Obtenemso las cookies
        Cookie cookies[] = request.getCookies();
        if(cookie != null){
            
            for(Cookie c:cookies){
                if(c.getName().equals("contadorVisitas")){
                    
                    contador = Integer.parseInt(c.getValue());
                    
                }
            }
        }
        
        //Incrementar el valor del contador a 1
        contador++;
        //Agregamos la respuesta al navegador
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        //Configurar cookie temporal 1 hora 3600seg
        c.setMaxAge(3600);
        //Mandamos el cookie
        response.addCookie(c);
        
        response.setContentType("text/html;chaset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Contador de cada cliente: " + contador);
        out.close();
        
        
    }
    
}
