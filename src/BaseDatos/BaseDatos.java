/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mipc
 */
public abstract class BaseDatos {
   ComportamientoEjecutar exec;
   String query;
   ResultSet rs;
   Statement stmt;
   ResultSetMetaData rsmd;
   public void setComportamientoEjecutar(ComportamientoEjecutar ce){
       this.exec=ce;
   }
   public BaseDatos(){
       
   }
   public String getQuery(){
       return query;
   }
   public ResultSet getResultSet(){
       return rs;
   }
   public Statement getStatement(){
       return stmt;
   }
   public ResultSetMetaData getResultSetMetaData(){
       return rsmd;
   }
   public BaseDatos(String query){
       this.query=query;
    }
   protected void crearResultSetQuery(){
          exec.ejecutar(query);
          this.rs=exec.getResultSet();
          
   }
    public ResultSet getResultSetQuery(String query){
        exec.ejecutar(query);
          this.rs=exec.getResultSet();
        return rs;
    }
    protected void crearResultSetMetaData(){
       try {
          if(rs!=null){ 
           this.rsmd=rs.getMetaData();
          }
       } catch (SQLException ex) {
           Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public ResultSetMetaData getResultSetMetaData(ResultSet rs){
       try {
           if(rs!=null){
           this.rsmd=rs.getMetaData();
           }
       } catch (SQLException ex) {
           Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rsmd;
    }
    public void cerrar(){
        exec.cerrar();
    }
}
