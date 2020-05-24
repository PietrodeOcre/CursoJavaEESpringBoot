/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author pietrodeocre
 */

@WebService
public interface ServicioSumasWS {
    
    @WebMethod
    public int sumar(int num, int num1);
    
}
