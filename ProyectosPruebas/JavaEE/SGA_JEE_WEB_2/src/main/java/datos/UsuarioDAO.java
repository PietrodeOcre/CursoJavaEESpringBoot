/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Usuario;
import java.util.List;

/**
 *
 * @author pietrodeocre
 */
public interface UsuarioDAO {
    
    public List<Usuario> BuscarTodosUsuarios();
    
    public Usuario BuscarPorId(Usuario usuario);
    
    
    
    public void insertarUsuario(Usuario usuario);
    
    public void actualizarUsuario(Usuario usuario);
    
    public void borrarUsuario(Usuario usuario);
    
}
