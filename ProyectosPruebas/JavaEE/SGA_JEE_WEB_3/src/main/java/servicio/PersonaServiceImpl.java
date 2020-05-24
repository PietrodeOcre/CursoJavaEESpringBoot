/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author pietrodeocre
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{
    
    @Inject
    private PersonaDAO personaDAO;
    
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Persona> listarPersonas() {
        //List<Persona> personas = new ArrayList<>();
        //Esto sería para no necesitar base de datos
        /*personas.add(new Persona(1,"Juan", "Perez", "jperez@email.com", "55139900"));
        personas.add(new Persona(2,"Marta", "Suarez", "msuarez@email.com", "55139910"));
        personas.add(new Persona(3,"Manuel", "Corral", "mcorral@email.com", "55139920"));
        personas.add(new Persona(4,"Miguel", "Guillem", "mguillem@email.com", "55139930"));
        personas.add(new Persona(5,"Pablo", "Garcia", "pgarcia@email.com", "55139940"));
        personas.add(new Persona(6,"Elisea", "Gomez", "egomez@email.com", "55139950"));
        
        return personas;*/
        
        //Esta parte usa base de datos para persistir personas
        
        return personaDAO.buscarTodasPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return (Persona)personaDAO.buscarPorId(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return (Persona)personaDAO.buscarPorEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDAO.insertarPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try {
            personaDAO.actualizarPersona(persona);
        } catch (Throwable e) {
            contexto.setRollbackOnly(); 
            e.printStackTrace(System.out);
        }
        
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDAO.borrarPersona(persona);
        
    }

    

    
}
