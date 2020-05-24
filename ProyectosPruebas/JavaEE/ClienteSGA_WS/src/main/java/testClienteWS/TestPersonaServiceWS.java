/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClienteWS;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;

/**
 *
 * @author pietrodeocre
 */
public class TestPersonaServiceWS {
    public static void main(String[] args) {
        
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        System.out.println("Ejecutando servicio de Listar personas del WS");
        
        List<Persona> personas = personaService.listarPersonas();
        
        for(Persona persona: personas){
            System.out.println("Persona IdPersona: " + persona.getIdPersona() +
                    ", Nombre: " + persona.getNombre() + ", Apellido: " + persona.getEmail() +
                    ", Email: " + persona.getEmail() + ", Telefono: " + persona.getTelefono()
                    );
        }
        
    }
            
}
