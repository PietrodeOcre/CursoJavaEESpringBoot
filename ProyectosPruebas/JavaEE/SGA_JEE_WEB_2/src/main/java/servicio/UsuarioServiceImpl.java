/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author pietrodeocre
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService{
    
    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.BuscarTodosUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return (Usuario)usuarioDAO.BuscarPorId(usuario);
    }

    

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.insertarUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDAO.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.borrarUsuario(usuario);
    }

       
    
}
