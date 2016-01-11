/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package puntodeventa.inicio;
import java.sql.*;
/**
 *
 * @author alberto
 */
public class conexioninicio {
    public String bd = "tienda";
    public String login = "root";
    public String password = "123";
    public String url = "jdbc:mysql://localhost/"+bd;
    Connection conn = null;
    public conexioninicio(){
         try {
        Class.forName("org.gjt.mm.mysql.Driver");
        conn = DriverManager.getConnection(url, login, password);
        if (conn != null)
            {
                System.out.println("Conexión a base de datos "+url+" ... Ok");
            }
        }
    catch(SQLException ex) {
        System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
        }
    catch(ClassNotFoundException ex) {
        System.out.println(ex);
        }
    }
    public void conectar() {
    
    try {
        Class.forName("org.gjt.mm.mysql.Driver");
        conn = DriverManager.getConnection(url, login, password);
        if (conn != null)
            {
                System.out.println("Conexión a base de datos "+url+" ... Ok");
            }
        }
    catch(SQLException ex) {
        System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
        }
    catch(ClassNotFoundException ex) {
        System.out.println(ex);
        }
    }
    public String getURl()
        {
            return url;
        }

public String getLogin()
    {
    return login;
}
public String getPassword()
    {
    return password;
}
public Connection getConexion(){
    return conn;
}
  public void cerrarConexxion() throws SQLException{
      conn.close();
  }
}
