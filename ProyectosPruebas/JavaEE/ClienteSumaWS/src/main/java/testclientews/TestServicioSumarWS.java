/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumasWS;

/**
 *
 * @author pietrodeocre
 */
public class TestServicioSumarWS {
    
    public static void main(String[] args) {
        
        ServicioSumasWS servicioSumasWS = new ServicioSumarImplService().getServicioSumarImplPort();
        
        System.out.println("Ejecutando Servicio Sumar");
        
        int a = 6;
        int b = 3;
        
        int resultado = servicioSumasWS.sumar(a, b);
        
        System.out.println("Resultado: " + resultado);
        
        System.out.println("Fin de la ejecución");
        
    }
    
}
