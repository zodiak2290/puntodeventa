/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.Statement;
import puntodeventa.inicio.conexioninicio;

/**
 *
 * @author mipc
 */
public interface ComportamientoEjecutar {
    conexioninicio ci=new conexioninicio();
    public ResultSet getResultSet();
    public Statement getStatement();
    public void ejecutar(String query);
    public void cerrar();
}
