
package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        //Indicamos el tipo de archivo que va a descargar
        response.setContentType("application/vnd.ms-excel");
        //Indicamos el archivo que se va a descargar
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //Para un uso mas profesional usar libreria poi.apache.org

        //Indicaremos que no guarde informacion previa
        response.setHeader("Pragma", "no-cache");
        //Para que cada vez que pulsemos en el link siempre sea informacion nueva
        response.setHeader("Cache-Control", "no-store");
        //Con esto especificamos que no guarde cache
        response.setDateHeader("Expires", -1);

        //Desplegamos inforamcion al cliente
        PrintWriter out = response.getWriter();
        
        /*
        Con este codigo generamos un excel con una columna con valor "Valores"
        Otra columna con el valor "1" y otra debajo con el valor "2"
        el \t indica que salta una columna, o a la siguiente columna
        Como son println cada valor se metera en una fila diferente
        En la ultima fila damos valores a la primera columna "Total" y 
        la siguiente columna con una funcion de suma
        */
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        /*
        Tener especial atencion a los nombres de los comandos
        puesto que en excel es "suma" pero en calc es "sum"
        obviamente eso puede afectar a como se visualiza el 
        documento puesto que pueden no funcionar algunas funciones
        */
        out.println("Total\t=SUM(b2:b3)");
        out.close();
    }

    
}
