/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author mipc
 */
public class ConsultaBaseDatos extends BaseDatos{
   public ConsultaBaseDatos(String cons){
       super(cons);
       exec=new EjecutarQuery();
       crearResultSetQuery();
       crearResultSetMetaData();
   }
}
