/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.criteria;

import domain.Persona;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.*;

/**
 *
 * @author pietrodeocre
 */
public class PruebaApiCriteria {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        List<Persona> personas = null;
        Persona persona = null;
        
        //Query usando Api de Criteria
        
        //Consulta 1
        //El objeto EntityManager crea una instancia de CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //Creamos el objeto raiz, digamos que el nombre de la tabla
        fromPersona = criteriaQuery.from(Persona.class);
        
        //Seleccionamos el from al que queremos acceder desde nuestro select
        criteriaQuery.select(fromPersona);
        
        //Creamos el tipo de Query TypeSafe
        query = em.createQuery(criteriaQuery);
        
        //Ejecutamos la consulta
        personas = query.getResultList();
       
        //mostrarPersonas(personas);

        //Consulta 2
        //El objeto EntityManager crea una instancia de CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //Creamos el objeto raiz, digamos que el nombre de la tabla
        fromPersona = criteriaQuery.from(Persona.class);
        
        //Seleccionamos el from al que queremos acceder desde nuestro select
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        
        //Creamos el tipo de Query TypeSafe
        query = em.createQuery(criteriaQuery);
        
        //Ejecutamos la consulta
        personas = query.getResultList();
        
        //mostrarPersonas(personas);
        
        //Consulta 3
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        
        //La clase predicate nos permite pasar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        //Verificamos si tenemso criterios
        Integer idPersonaParam = 2;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add( cb.equal(fromPersona.get("idPersona"), parameter));
        
        //Agregamos los criterios
        /*
        Si el largo de neustra coleccion 
        es un elemento obtenemos solo el primer valor 
        y si tenemos mas elementos podemos elegir la funcion
        AND o OR o cualquier función valida
        */
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        }else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        }else{
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        personas = query.getResultList();
        mostrarPersonas(personas);
        
        
        
        
        
    }
    
    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
    
    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            log.debug(usuario);
        }
    }
    
}
