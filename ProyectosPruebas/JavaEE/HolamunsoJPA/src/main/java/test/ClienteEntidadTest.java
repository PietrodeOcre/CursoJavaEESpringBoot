package test;

import domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class ClienteEntidadTest {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        tx.begin();
        
        //Nuevo registro en DB, no se indica el id por que es autonumerido e incremental
        Persona persona1 = new Persona("Manuel", "Corral", "mcorral@mail.com", "11223344");
        Persona persona2 = new Persona("Juan", "Perez", "jperez@mail.com", "11223344");
        
        log.debug("Objeto a persistir:" + persona1);
        log.debug("Objeto a persistir:" + persona2);
        //Persistimos el objeto
        em.persist(persona1);
        em.persist(persona2);
        //terminamos la transaccion
        tx.commit();
        log.debug("Objeto persistido" + persona1);
        log.debug("Objeto persistido" + persona2);
        em.close();
        
        
    }
    
}
