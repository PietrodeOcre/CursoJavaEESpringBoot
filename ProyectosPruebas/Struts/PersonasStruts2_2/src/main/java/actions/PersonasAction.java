/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pietrodeocre
 */
public class PersonasAction extends ActionSupport{
    
    Logger log = LogManager.getLogger(PersonasAction.class);
    
    private Persona persona;
    
    @Override
    public String execute(){
        if(this.persona != null){
            log.info("\n");
            log.info("Persona: " + persona);
        }else{
            log.info("Persona con valor nulo");
            
        }
        return SUCCESS;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
}
