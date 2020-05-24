/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pietrodeocre
 */
@WebServlet("/SesionServlet")
public class SesionServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;chaset=UTF-8");
        
        //Hacemos peticion de datos de sesion, si no hay datos crea una sesion automaticamente
        HttpSession sesion = request.getSession();
        
        String titulo = null;
        
        //Pedir atributo contador visitas a la sesion
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorVisitas");
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
            
        }else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        //Agregamos nuevo valor a la sesion
        //Si existe lo actualiza si no lo crea
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        
        //Mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.println(titulo);
        out.println("<br/>");
        out.println("Numero de accesos al recurso: " + contadorVisitas);
        out.println("<br/>");
        //El id se crea automaticamente en cada sesion
        //out.println("Id de sesion: " + sesion.getAttribute("JSESSIONID"));
        //out.println("Id de sesion: " + sesion.getAttributeNames());
        /*try {
            Enumeration<String> atributos = sesion.getAttributeNames();
            int i = 0;
            while (atributos.hasMoreElements()) {
                String attr = atributos.nextElement();
                out.println(attr + ":" + sesion.getAttribute(attr));

                out.println("<br/>");
            }
        } catch (IllegalStateException e){
            //e.printStackTrace();
        }*/

        out.println("<br/>");
        //El id se crea automaticamente en cada sesion
        out.println("Id de sesion: " + sesion.getId());

        out.close();

    }

}
