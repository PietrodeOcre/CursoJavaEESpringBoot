/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pietrodeocre
 */
public class Conversiones {
    
    private static final String FORMATO_FECHA = "dd-MM";
    
    
    public static String formato_Date(Date fecha){
        
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
        
    }
    
    public static String formato_Date(String fecha){
        
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
        
    }
    
}
