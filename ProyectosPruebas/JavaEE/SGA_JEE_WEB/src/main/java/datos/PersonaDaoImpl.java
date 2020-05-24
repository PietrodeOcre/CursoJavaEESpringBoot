/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;


/**
 *
 * @author pietrodeocre
 */
@Stateless
public class PersonaDaoImpl implements PersonaDAO{
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> buscarTodasPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona buscarPorId(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona buscarPorEmail(Persona persona) {
        Query query = em.createQuery("From Persona p WHERE p.mail =: email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void borrarPersona(Persona persona) {
        em.remove(em.merge(persona));
    }
    
    
    
}
