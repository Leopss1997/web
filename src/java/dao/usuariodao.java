
package dao;

import model.Usuario;


public interface usuariodao {
    
    public Usuario obtenerDatosUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
    
}
