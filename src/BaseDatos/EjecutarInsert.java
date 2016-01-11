/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import static BaseDatos.ComportamientoEjecutar.ci;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mipc
 */
class EjecutarInsert implements ComportamientoEjecutar {
Statement stmt;
    ResultSet rs;
    Connection con;
    public void ejecutar(String query) {
        
        try {
            getStatement().executeUpdate(query);
       } catch (SQLException ex) {
           Logger.getLogger(EjecutarQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public ResultSet getResultSet(){
        return rs;
    }
    public Statement getStatement() {
        con=ci.getConexion();
        try {
            this.stmt=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EjecutarQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stmt;
    }
     public void cerrar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EjecutarQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
