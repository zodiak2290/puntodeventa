/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

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
public class EjecutarQuery implements ComportamientoEjecutar{
    Statement stmt;
    ResultSet rs;
    Connection con;
    public void ejecutar(String query) {
        
        try {
            this.rs=getStatement().executeQuery(query);
       } catch (SQLException ex) {
           Logger.getLogger(EjecutarQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
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

    public ResultSet getResultSet() {
        return rs;
    }
    public void cerrar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EjecutarQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
