package beans;

import javax.ejb.Stateless;
import javax.jws.WebService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pietrodeocre
 */
@Stateless
@WebService(endpointInterface = "beans.ServicioSumasWS")
public class ServicioSumarImpl implements ServicioSumasWS{

    @Override
    public int sumar(int num, int num1) {
        return num+num1;
    }
    
    
    
}
