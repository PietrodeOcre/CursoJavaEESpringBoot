/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pietrodeocre
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        //Leer parametros de formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        System.out.println("Usuario: " + usuario);
        System.err.println("Contraseña: " + password);

        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<title>Pagina Secundaria</title>");
        
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h2>Hola: " + usuario + ", la contraseña que has introducido es: " + password + "</h2>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
        
        
        
    }
    
}
