package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

public class MostrarPersonaAction extends ActionSupport{
    
    Logger log = LogManager.getLogger(MostrarPersonaAction.class);
    
    private String usuario, password;
    
    public String execute(){
        log.info("El Usuario es: " + this.usuario);
        log.info("El Password es: " + this.password);
        return SUCCESS;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*
    form.titulo:Login
    form.valor:Valores Recibidos
    form.boton:Enviar Formulario
    form.usuario:Usuario
    form.password:Contraseña
    */
    
    public String getTitulo(){
        return getText("form.titulo");
    }
    
    public String getValor(){
        return getText("form.valor");
    }

    public String getBoton(){
        return getText("form.boton");
    }
    
}
