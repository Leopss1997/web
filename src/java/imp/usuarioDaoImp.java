
package imp;

import clasesAuxiliares.encriptacionPassword;
import dao.usuariodao;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


public class usuarioDaoImp implements usuariodao{

    @Override
    public Usuario obtenerDatosUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql="FROM Usuario WHERE nombreUsuario=:nombreUsuario";
        Query q = session.createQuery(hql);
        q.setParameter("nombreUsuario", usuario.getNombreUsuario());
        
        return (Usuario) q.uniqueResult();
        
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user=this.obtenerDatosUsuario(usuario);
        if (user!=null) {
            if (!user.getPassword().equals(encriptacionPassword.sha512(usuario.getPassword()))) {
                user=null;
            }
        }
        return user; 
    }
    
}
