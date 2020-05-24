/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author pietrodeocre
 */
@Named
@RequestScoped
public class ColoniaHelper {
    
    public List<Colonia> getColonias(){
        
        List<Colonia> colonias = new ArrayList<>();
        
        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Alcala de Henares", 28025);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Getafe", 28048);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Parla", 28028);
        colonias.add(colonia);
        
        return colonias;
        
    }
    
    public int getColoniaIdPorNombre(String nombreColonia){
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        
        for(Colonia colonia: colonias){
            if(colonia.getNombreColonia().equals(nombreColonia)){
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public int getColoniaIdPorCP(int codigoPostal){
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();

        for(Colonia colonia: colonias){
            if(colonia.getCodigoPostal() == codigoPostal){
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
        
    }
    
    public List<SelectItem> getSelectItems(){
        
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        for(Colonia colonia: colonias){
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(),colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        return selectItems;
    }
    
    
}
