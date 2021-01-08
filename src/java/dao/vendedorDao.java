/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Vendedor;

/**
 *
 * @author DELL
 */
public interface vendedorDao {

    public List<Vendedor> listarVendedor();/*Lista todos los clientes en el db*/
    public void newVendedor(Vendedor vendedor);/*Crear*/
    public void updateVendedor(Vendedor vendedor);/*Actualizar*/
    public void deleteVendedor(Vendedor vendedor);/*Eliminar*/

}
