/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;


import domain.Persona;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import servicio.PersonaServiceImpl;
import servicio.PersonaServiceRemote;

/**
 *
 * @author pietrodeocre
 */
public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/SGA_JEE/PersonaServiceImpl!servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona persona: personas){
                System.out.println(persona);
                       
            }
            
            System.out.println("\nFin de llamada al EJB desde el cliente.");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
