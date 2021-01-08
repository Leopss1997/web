/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.pedidoDao;
import imp.pedidoDaoImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Detallefactura;

@ManagedBean
@ViewScoped

public class pedidoBean {

    private List<Detallefactura> listaPedidos;
    private Detallefactura detalle;
    
    private List<Detallefactura> Pedidosfiltrados;

    public pedidoBean() {
        detalle = new Detallefactura();
    }

    public Detallefactura getDetalle() {
        return detalle;
    }

    public void setDetalle(Detallefactura detalle) {
        this.detalle = detalle;
    }
    
    

    public void setListaPedidos(List<Detallefactura> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<Detallefactura> getListaPedidos() {
        pedidoDao pDao = new pedidoDaoImp();
        listaPedidos = pDao.listarPedidoss();
        return listaPedidos;
    }

    public List<Detallefactura> getPedidosfiltrados() {
        return Pedidosfiltrados;
    }

    public void setPedidosfiltrados(List<Detallefactura> Pedidosfiltrados) {
        this.Pedidosfiltrados = Pedidosfiltrados;
    }
    
    

}
