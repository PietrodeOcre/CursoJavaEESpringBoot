/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Rectangulo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author pietrodeocre
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Procesamos parametros
        String accion = request.getParameter("accion");
        
        
        //Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSession = new Rectangulo(3,4);
        Rectangulo recAplication = new Rectangulo(5,6);
        
        //Agregamos al JavaBeans una variable string  llamada mensage
        //al alcance de correspondiente
        
        //Revisamos la accion proporcionada
        if("agregaVariables".equals(accion)){
            //Alcance Request
            request.setAttribute("rectanguloRequest", recRequest);
            //Alcance Session
            HttpSession sesion= request.getSession();
            sesion.setAttribute("rectanguloSession", recSession);
            
            //Alcance Application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", recAplication);
            
            //Agregamos mensaje 
            request.setAttribute("Mensaje", "Las variables fueron agregadas");
            
            
            //Redireccionamos al JSP de index
            request.getRequestDispatcher("index.jsp").forward(request,response);
            
        }else if("listarVariables".equals(accion)){
            
            //Redireccionamos al JSP que despliega las variables
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
            
            
        }else{
            
            //Redireccionamos a inicio
            request.setAttribute("Mensaje", "Accion desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //Otra forma de redirigir al JSP de index, pero comono propaga 
            //los objetos request y response no vale para compartir informacion
            //response.sendRedirect("index.jsp");
        }
       
        
        
        
        
    }
    
}
