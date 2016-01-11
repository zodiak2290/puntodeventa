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
public class InsertBaseDatos extends BaseDatos{
     public InsertBaseDatos(String cons){
       super(cons);
       exec=new EjecutarInsert();
       crearResultSetQuery();
       crearResultSetMetaData();
   }
}
