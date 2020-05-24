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
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        //Variable para usuaio
        boolean nuevousuario = true;
        
        
        //Obtenemso las cookies
        Cookie cookie[] = request.getCookies();
        
        //Buscamos si existe otra cookie llamada "visitanteRecurrente"
        if(cookie != null){
            
            for(Cookie c:cookie){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    //Si es recurrente
                    nuevousuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        
        if(nuevousuario){
            Cookie visitanteRecurrente = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteRecurrente);
            mensaje =  "Gracias por visitar por primera vez nuestro sitio";
        }else{
            mensaje =  "Gracias por visitar por Nuevamente nuestro sitio";
        }
        
        response.setContentType("text/html;chaset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Mensaje: " + mensaje);
        out.close();
        
    }
    
}
