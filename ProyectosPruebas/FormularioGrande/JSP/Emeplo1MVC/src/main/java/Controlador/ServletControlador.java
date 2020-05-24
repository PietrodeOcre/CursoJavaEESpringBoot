/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Rectangulo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        
        
        //Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        
        //Agregamos al JavaBeans una variable string  llamada mensage
        //al alcance de request, petición
        request.setAttribute("mensaje", "Saludos desde el Servlet");
       
        //Agregamos al javabeans la variable Rectangulo de tipo rectangulo
        //pero en el alcance de session con nuestro objeto HttpSession y el setAttribute
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //Redireccionamos nuestro RequestDispacher a la vista correspondiente que vamso a usar
        RequestDispatcher rd = request.getRequestDispatcher("Vista/DesplegarVariables.jsp");
        rd.forward(request, response);
        
        
        
    }
    
}
