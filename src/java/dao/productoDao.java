/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Producto;
import org.hibernate.Session;


/**
 *
 * @author DELL
 */
public interface productoDao {

    public List<Producto> listarProductos();/*Lista todos los clientes en el db*/
    public void newProducto(Producto producto);/*Crear*/
    public void updateProducto(Producto producto);/*Actualizar*/
    public void deleteProducto(Producto producto);/*Eliminar*/
    public Producto  obtenerProductoPorCodBarra(Session session, String codBarra) throws Exception;


}
