/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Persona;
import java.util.List;

/**
 *
 * @author pietrodeocre
 */
public interface PersonaDAO {
   
    public List<Persona> buscarTodasPersonas();
    
    public Persona buscarPorId(Persona persona);
    
    public Persona buscarPorEmail(Persona persona);
    
    public void insertarPersona(Persona persona);
    
    public void actualizarPersona(Persona persona);
    
    public void borrarPersona(Persona persona);
    
}
