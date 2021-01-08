/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.usuariodao;
import imp.usuarioDaoImp;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import model.Usuario;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class loginbean{

    private String nombreUsuario;
    private String password;
    private Usuario usuario;
    
    public loginbean() {
        this.usuario = new Usuario();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void login(ActionEvent event){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedln = false;

        String ruta="";
        usuariodao uDao = new usuarioDaoImp();
        this.usuario = uDao.login(this.usuario);
        
        if (this.usuario != null) {
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombreUsuario());
            loggedln = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido",this.usuario.getNombreUsuario());
            ruta = "/WEBAPP1/faces/Views/bienvenido.xhtml";
            
        }else{
            loggedln = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Error al ingresar","Datos incorrectos");
            this.usuario = new Usuario();
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedln", loggedln);
        context.addCallbackParam("ruta", ruta);
    }
    
    public String cerrarSession(){
        this.nombreUsuario = null;
        this.password = null;
        
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "/login";
    }
    
    
}
