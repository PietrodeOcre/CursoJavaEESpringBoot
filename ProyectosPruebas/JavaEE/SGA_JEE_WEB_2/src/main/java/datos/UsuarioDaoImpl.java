/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author pietrodeocre
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDAO{
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Usuario> BuscarTodosUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario BuscarPorId(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    

    @Override
    public void insertarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
    
    
    
}
