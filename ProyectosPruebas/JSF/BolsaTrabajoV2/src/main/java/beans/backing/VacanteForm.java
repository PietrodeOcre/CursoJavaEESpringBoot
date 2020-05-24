package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {
    
    @Inject
    private Candidato candidato;
    
    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando el objeto VacanteForm");
    }
    
    
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if(this.candidato.getNombre().equals("Juan")){
            if(this.candidato.getApellido().equals("Perez")){
                String msg = "Gracias pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; //Este es un mensaje global
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        }
        else{
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uIViewRoot = facesContext.getViewRoot();
        String nuevoCodigoPostal = (String) valueChangeEvent.getNewValue();
        if("28025".equals(nuevoCodigoPostal)){
            UIInput provinciaInputText = (UIInput) uIViewRoot.findComponent("vacanteForm.provincia");
            String provincia = "Madrid";
            provinciaInputText.setValue(provincia);
            provinciaInputText.setSubmittedValue(provincia);
            
            UIInput ciudadInputText = (UIInput) uIViewRoot.findComponent("vacanteForm.ciudad");
            String ciudad = "Madrid";
            ciudadInputText.setValue(ciudad);
            ciudadInputText.setSubmittedValue(ciudad);
            
            facesContext.renderResponse();
        }
    }
    
}
