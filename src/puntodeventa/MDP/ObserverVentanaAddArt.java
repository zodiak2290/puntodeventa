/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntodeventa.MDP;

/**
 *
 * @author mipc
 */
public interface ObserverVentanaAddArt {
    public void update(String idmarca,String iddep,String codigobarras,String nombre,String medida,String precioVenta,String precioCompra,String desc,String cantidad);
}
