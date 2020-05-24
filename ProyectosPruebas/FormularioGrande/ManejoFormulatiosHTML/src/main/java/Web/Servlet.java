
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologia[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musica[] = request.getParameterValues("musica");
        String comentario = request.getParameter("comentarios");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Resultado de Servlet</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Respuestas</h1>");
        out.println("<table border='1'>");

        out.println("<tr><td>Usuario: </td><td>"+ usuario + "</td></tr>");

        out.println("<tr><td>Password: </td><td>"+ password + "</td></tr>");
        
        out.println("<tr><td>Tecnologías: </td>");
        out.println("<td>");
        for (String tecnologia1 : tecnologia) {
            out.println(tecnologia1 + " / ");
        }
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr><td>Género: </td><td>"+ genero + "</td></tr>");
        
        out.println("<tr><td>Ocupación: </td><td>"+ ocupacion + "</td></tr>");
        
        out.println("<tr><td>Música: </td>");
        out.println("<td>");
        
        for (String musica1 : musica) {
            out.println(musica1 + " / ");
        }

        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr><td>Comentarios: </td><td>"+ comentario + "</td></tr>");
        
        

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
