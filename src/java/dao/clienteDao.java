/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public interface clienteDao {
    
    public List<Cliente> listarClientes();/*Lista todos los clientes en el db*/
    public void newCliente(Cliente cliente);/*Crear*/
    public void updateCliente(Cliente cliente);/*Actualizar*/
    public void deleteCliente(Cliente cliente);/*Eliminar*/
    
    public Cliente obtenerClientePorCodigo(Session session, Integer codCliente) throws Exception;
    
}
