/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.productoDao;
import imp.productoDaoImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Producto;


@ManagedBean
@ViewScoped
public class productoBean {

    private List<Producto> listaProductos;
    private Producto producto;

    public productoBean() {
        producto = new Producto();
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public List<Producto> getListaProductos() {
        productoDao pDao = new productoDaoImp();
        listaProductos = pDao.listarProductos();
        return listaProductos;
    }
    
    public void prepararNuevoProducto(){
        producto = new Producto();
    }
    
    public void nuevoProducto(){
        productoDao pDao = new productoDaoImp();
        pDao.newProducto(producto);
    }
    
    public void modificarProducto(){
        productoDao pDao = new productoDaoImp();
        pDao.updateProducto(producto);
        producto = new Producto();
    }
    
    public void eliminarProducto(){
        productoDao pDao = new productoDaoImp();
        pDao.deleteProducto(producto);
        producto = new Producto();
    }
    

   
}
