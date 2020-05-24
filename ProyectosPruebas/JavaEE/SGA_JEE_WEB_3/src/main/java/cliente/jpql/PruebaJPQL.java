/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.jpql;

import domain.Persona;
import domain.Usuario;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.logging.log4j.*;

/**
 *
 * @author pietrodeocre
 */
public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        //Creamos las variables que vamos a utilizar
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        //Creamos la conexión hacia la unidad de persistencia PersonaPU
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        //Primera consulta
        //Solo son consultas asi que no vamos a crear una transaccion
        //Consulta de todas las personas
        log.debug("\n1. Consulta de todas las Personas");
        //Creamos el Query en JPQL
        //jpql = "select p from Persona p";
        /*Creamos una lista con todos los objetos de tipo 
        *persona persistidos en la base de datos
        *getResultList() devuelve una lista con todos los objetos
        *de tipo persona de la tabla Persona
         */
        //personas = em.createQuery(jpql).getResultList();
        /*
        Este metodo solo nos muestra la iteracion de todos los objetos
         */
        //mostrarPersonas(personas);

        //Segunda consulta
        log.debug("\n2. Consulta de la Persona con id = 1");
        //jpql = "select p from Persona p where p.idPersona = 1";
        //persona = (Persona)em.createQuery(jpql).getSingleResult();
        //log.debug(persona);

        //Tercera consulta
        log.debug("\n3. Consulta de la Persona con nombre = karla");
        //jpql = "select p from Persona p where p.nombre = 'Maria'";
        //personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //Cuarta consulta
        log.debug("\n4. Consulta datos individuales Arreglo tupla 3x3");
        //jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        //iter = em.createQuery(jpql).getResultList().iterator();
        //while(iter.hasNext()){
            //tupla = (Object[]) iter.next();
            //String nombre = (String)tupla[0];
            //String apellido = (String)tupla[1];
            //String email = (String)tupla[2];
            //log.debug("Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email);
        //}
        
        //Quinta consulta
        log.debug("\n5. Obtiene objeto Persona y ID");
        /*jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[])iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("Objeto Persona: " + persona);
            log.debug("Id_Persona: " + idPersona);
        }*/
        
        //Sexta consulta
        log.debug("\n6. Recuperar los objetos pero con al llave primaria");
        //jpql = "select new domain.Persona(p.idPersona) from Persona p";
        //personas =  em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //Septima consulta
        log.debug("\n7. Devuelve el primero y ultimo objeto de la tabla Persona");
        /*jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter =  em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[])iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long contador = (Long) tupla[2];
            log.debug("Id Minimo: " + idMin);
            log.debug("Id Maximo: " + idMax);
            log.debug("Total Ids: " + contador);
        }*/
        
        //Octaba consulta
        log.debug("\n8. Contar los nombres distintos");
        /*jpql = "select count(distinct p.idPersona) as Contador from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("Total Ids: " + contador);*/
        
        
        //Novena consulta
        log.debug("\n9. Concatenar y poner en mayuscula el nombre y apellido");
        /*jpql = "select CONCAT(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for(String nombbreCompleto: nombres){
            log.debug("Nombre: " + nombbreCompleto);
        }*/
        
        //Decima consulta
        log.debug("\n10. Obtiene el objeto Persona con ID igual al proporcionado");
        /*int idPersona = 3;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id",idPersona);
        persona = (Persona) q.getSingleResult();
        log.debug(persona);*/
        
        //Onceaba consulta
        log.debug("\n11. Obtiene Persona que contenga letra A en el nombre sin importar may o min");
        /*jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%a%";
        q = em.createQuery(jpql);
        q.setParameter("parametro",parametro);
        personas = q.getResultList();
        mostrarPersonas(personas);*/
        
        //Doceaba consulta
        log.debug("\n12. Uso de Between");
        /*jpql = "select p from Persona p where p.idPersona between 1 and 2";
        personas =  em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);*/
        
        //treceaba consulta
        log.debug("\n13. Ordenando por...");
        /*jpql = "select p from Persona p where p.idPersona < 3 order by p.nombre asc";
        personas =  em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);*/
        
        //Catorceaba consulta
        log.debug("\n14. Uso de Subquery...");
        /*jpql = "select p from Persona p where p.idPersona in(select min(p1.idPersona) from Persona p1)";
        personas =  em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);*/
        
        //Quinceaba consulta
        log.debug("\n15. Uso de join con LAZY loading...");
        /*jpql = "select u from Usuario u join u.persona p";
        usuarios =  em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);*/
        
        //Dieciseiaba consulta
        log.debug("\n16. Uso de left join con eager loading...");
        /*jpql = "select u from Usuario u left join fetch u.persona p";
        usuarios =  em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);*/
        
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
