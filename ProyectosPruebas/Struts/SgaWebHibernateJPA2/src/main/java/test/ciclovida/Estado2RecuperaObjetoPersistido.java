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
public class Estado2RecuperaObjetoPersistido {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        //definimos un objeto
        Contacto contacto = null;
        
        //Recuperamos un objeto
        contacto = em.find(Contacto.class, 3);
        
        //Ya estamos en Detached
        System.out.println("Contacto: " + contacto);
        
    }
}


