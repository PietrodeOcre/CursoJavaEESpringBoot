
package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        //Indicamos que se vera en formato texto
        response.setContentType("text/html;charset=UTF-8");
        //Indicamos que la web se va a recargar cada segundo para ver pasar los segundos
        response.setHeader("refresh", "1");
        
        //Dar formato par amostrar solo hora, minutos y segundos
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
        String horaFormateada = formateador.format(fecha);
        
        PrintWriter out = response.getWriter();
        out.println(horaFormateada);
            
        out.close();
        
        
    }
    
}
