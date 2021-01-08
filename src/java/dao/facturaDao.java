/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Factura;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public interface facturaDao {
    public Factura obtenerUltimoRegistro(Session session) throws Exception;
    public Long obtenerTotalRegistrosEnFactura(Session session);
    public boolean guardarVentaFactura(Session session, Factura factura) throws Exception;
    
    
}
