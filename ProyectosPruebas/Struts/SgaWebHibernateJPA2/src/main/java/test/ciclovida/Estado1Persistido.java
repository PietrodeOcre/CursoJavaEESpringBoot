/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ciclovida;

import domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pietrodeocre
 */
public class Estado1Persistido {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        //Estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("44556677");
        
        
        //Estado de persistente
        //Incio de transaccion
        em.getTransaction().begin();
        //Guarad un objeto y lo pasa a persistente, aunque el objeto no pasa a la base de datos aun
        em.persist(contacto);
        //Se sincornizan los datos del objeto en la base de datos pero no definitivamente como una actualizacion
        em.flush();
        //En este punto se puede recuperar el id asignado al objeto 
        //en la base dedatos( en caso de serautoincremental) pese a no estar commiteado aun
        //Se guarda el objeto en la base de datos definitivamente
        em.getTransaction().commit();
        
        //detaches o separado
        //Cualquier modificacion al objeto en la fase de detached  no se guardara enla base de datos
        //por tanto se eliminara dicha modificacion
        System.out.println("contacto= " + contacto);
        
    }
}
