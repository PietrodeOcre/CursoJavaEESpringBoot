/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author pietrodeocre
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote{

    
    
    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Juan", "Perez", "jperez@email.com", "55139900"));
        personas.add(new Persona(2,"Marta", "Suarez", "msuarez@email.com", "55139910"));
        personas.add(new Persona(3,"Manuel", "Corral", "mcorral@email.com", "55139920"));
        personas.add(new Persona(4,"Miguel", "Guillem", "mguillem@email.com", "55139930"));
        personas.add(new Persona(5,"Pablo", "Garcia", "pgarcia@email.com", "55139940"));
        personas.add(new Persona(6,"Elisea", "Gomez", "egomez@email.com", "55139950"));

        return personas;
    }

    @Override
    public Persona encontrarPersonaPorId() {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail() {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
        
    }

    @Override
    public void modificarPersona(Persona persona) {
        
    }

    @Override
    public void eliminarPersona(Persona persona) {
        
    }
    
    
    
}
