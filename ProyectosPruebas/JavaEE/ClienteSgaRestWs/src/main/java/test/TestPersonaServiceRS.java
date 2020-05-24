/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.omg.PortableServer.POAOperations;

/**
 *
 * @author pietrodeocre
 */


public class TestPersonaServiceRS {
    
    //Variables
    private static final String URL_BASE = "http://pietrodeocre-desktop:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        
        cliente = ClientBuilder.newClient();
        
        //Usamos get para pedir datos de una persona
        webTarget = cliente.target(URL_BASE).path("/personas");
        
        //Proporcionamos un id valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        
        System.out.println("Persona recuperada: " + persona);
        
        //Leer todas las personas
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas: ");
        ImprimirPersonas(personas);
        
        //Agregar Persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("cmiranda3@mail.com");
        nuevaPersona.setTelefono("33445566");
        
        //Agregar persona nueva
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println("Response: " + response.getStatus());
        
        //Recuperamso la persona recien agregada para modificarla y eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona Agragada: " + personaRecuperada);
        
        //Modificamos la persona agregada
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        personaModificar.setEmail("cramirez@mail.com");
        String pathId = "/" + personaModificar.getIdPersona();
        
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("Response: " + response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));
        
        
        //Eliminar una persona un registro
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId = "/" + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("Response: " + response.getStatus());
        System.out.println("Persona Eliminada: " + personaEliminar);
        
        
        
        
        
    }

    private static void ImprimirPersonas(List<Persona> personas) {
        
        for(Persona persona: personas){
            System.out.println("Persona: " + persona);
        }
    
    }
    
    
    
}
