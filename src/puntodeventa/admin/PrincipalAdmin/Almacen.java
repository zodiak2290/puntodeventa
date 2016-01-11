/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JOptionPane;
import puntodeventa.MDP.Observer;
import puntodeventa.MDP.Subject;
import static puntodeventa.admin.PrincipalAdmin.Ventas.User;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class Almacen implements Observer
/*     */ {
/*     */   String cant;
/*     */   String cadenasql;
/*     */   String cadenasql2;
/*     */   ArrayList codigos;
/*     */   ArrayList cantidades;

            String foliovent;
            String curp;
            Subject venta;
              public Almacen()
/*     */   {
/*  22 */     this.cadenasql = null;
/*  23 */     this.cadenasql2 = null;
/*  24 */     this.codigos = new ArrayList();
/*  25 */     this.cantidades = new ArrayList();
/*     */   }
/*     */   public void setSubjectVenta(Subject venta){
                venta.registerObserver(this);
}
/*     */   public void recibirCodigoB(String cb, int cant)
/*     */   {
/*     */     try {
/*  31 */       this.cadenasql = "insert into tienda.almacen(codigobarras,cantidad) values('" + cb.toUpperCase() + "'," + cant + ")";
/*  32 */       conexioninicio ci = new conexioninicio();
/*  33 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  34 */       Statement stmt = con.createStatement();
/*  35 */       stmt.executeUpdate(this.cadenasql);
/*  36 */       JOptionPane.showMessageDialog(null, "Registrado en Almacen!", "", 0);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  40 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void recibirCodigoInv(String cb, float prec)
/*     */   {
/*     */     try
/*     */     {
/*  51 */       this.cadenasql2 = "insert into tienda.inventario(codigobarras,fechaCambi,precioVenta) values('" + cb.toUpperCase() + "'," + "CURRENT_DATE," + prec + ")";
/*     */ 
/*  53 */       conexioninicio ci = new conexioninicio();
/*  54 */       Connection con = null;
/*  55 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  56 */       Statement stmt = con.createStatement();
/*  57 */       stmt.executeUpdate(this.cadenasql2);
/*  58 */       JOptionPane.showMessageDialog(null, "Registro Exitoso!", "", 0);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  62 */       System.out.println("inventario" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void recibirCodigoCompra(String cb, float prec, int cantidad)
/*     */   {
/*     */     try
/*     */     {
/*  72 */       this.cadenasql2 = "insert into tienda.compra(idcompra,codigobarras,cantidadcomp,fechacom,preciocom) values(null,'" + cb.toUpperCase() + "'," + cantidad + ",CURRENT_DATE," + prec + ")";
/*     */ 
/*  74 */       conexioninicio ci = new conexioninicio();
/*  75 */       Connection con = null;
/*  76 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  77 */       Statement stmt = con.createStatement();
/*  78 */       stmt.executeUpdate(this.cadenasql2);
/*  79 */       System.out.println(" re gistrado en compra inventario");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  83 */       System.out.println("inventario" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void actualizaAlma(String cb, int cant)
/*     */   {
/*     */     try
/*     */     {
/*  93 */       this.cadenasql2 = "UPDATE almacen  SET cantidad=cantidad+" + cant + " where codigobarras ='" + cb + "'";
/*  94 */       conexioninicio ci = new conexioninicio();
/*  95 */       Connection con = null;
/*  96 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  97 */       Statement stmt = con.createStatement();
/*  98 */       stmt.executeUpdate(this.cadenasql2);
/*  99 */       JOptionPane.showMessageDialog(null, "Registrado en Almacen!", "", 0);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 103 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public int buscarPrecio(String cb)
/*     */   {
/* 110 */     int id = 0;
/* 111 */     conexioninicio ci = new conexioninicio();
/* 112 */     ci.conectar();
/*     */     try {
/* 114 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 115 */       Statement stmt = con.createStatement();
/* 116 */       ResultSet rs = stmt.executeQuery(" SELECT  idinventario FROM  inventario WHERE idinventario in (SELECT MAX( idinventario ) FROM  inventario group by codigobarras)  and codigobarras='" + cb + "'");
/* 117 */       while (rs.next()) {
/* 118 */         id = Integer.parseInt(rs.getString("idinventario"));
/*     */       }
/* 120 */       rs.close();
/* 121 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 125 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */ 
/* 129 */     return id;
/*     */   }
/*     */ 
/*     */   public String idVentaBuscar(String idv) {
/* 133 */     String id = null;
/* 134 */     conexioninicio ci = new conexioninicio();
/* 135 */     ci.conectar();
/*     */     try {
/* 137 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 138 */       Statement stmt = con.createStatement();
/* 139 */       ResultSet rs = stmt.executeQuery("SELECT idventa  FROM venta where idventa='" + idv + "'");
/* 140 */       while (rs.next()) {
/* 141 */         id = rs.getString("idventa");
/*     */       }
/* 143 */       rs.close();
/* 144 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 151 */     return id;
/*     */   }
/*     */ 
/*     */   public String buscarCurp(String id)
/*     */   {
/* 156 */     String curp = null;
/* 157 */     conexioninicio ci = new conexioninicio();
/* 158 */     ci.conectar();
/*     */     try {
/* 160 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 161 */       Statement stmt = con.createStatement();
/* 162 */       ResultSet rs = stmt.executeQuery("SELECT curp FROM admin where idadmon='" + id + "'");
/* 163 */       if (!(rs.first()))
/*     */       {
/* 165 */         ResultSet rss = stmt.executeQuery("SELECT curp FROM cajero where idcajero='" + id + "'");
/* 166 */         while (rss.next())
/* 167 */           curp = rss.getString("curp");
/*     */       }
/*     */       else
/*     */       {
/* 171 */         ResultSet rsss = stmt.executeQuery("SELECT curp FROM admin where idadmon='" + id + "'");
/* 172 */         while (rsss.next()) {
/* 173 */           curp = rsss.getString("curp");
/* 174 */           System.out.println(curp);
/*     */         }
/* 176 */         rs.close();
/* 177 */         con.close();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 182 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */ 
/* 186 */     return curp;
/*     */   }
/*     */ 
/*     */   public int idVentaparaVenta()
/*     */   {
/* 191 */     int id = 0;
/* 192 */     conexioninicio ci = new conexioninicio();
/* 193 */     ci.conectar();
/*     */     try {
/* 195 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 196 */       Statement stmt = con.createStatement();
/* 197 */       ResultSet rs = stmt.executeQuery("SELECT max(idventa) as idventa FROM ticketventa ");
/* 198 */       while (rs.next()) {
/* 199 */         id = Integer.parseInt(rs.getString("idventa"));
/*     */       }
/*     */ 
/* 202 */       rs.close();
/* 203 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 210 */     return id;
/*     */   }
/*     */ 
/*     */   boolean checarelidventa(int idventa) throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 217 */       conexioninicio ci = new conexioninicio();
/* 218 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 222 */       Statement instruccionSQL = con.createStatement();
/* 223 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM venta WHERE idventa=" + idventa + "");
/*     */ 
/* 226 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 232 */     return false;
/*     */   }
/*     */ 
/*     */   public void actualizacantidadesAlmacen(String idv)
/*     */   {
/* 241 */     conexioninicio ci = new conexioninicio();
/* 242 */     ci.conectar();
/*     */     try {
/* 244 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 246 */       Statement stmt = con.createStatement();
/*     */ 
/* 248 */       ResultSet rs = stmt.executeQuery("SELECT codigobarras, sum( cantidadprod ) as cantidad FROM marca NATURAL JOIN articulo NATURAL JOIN ticketventa NATURAL JOIN inventario WHERE idinventario IN (SELECT MAX( idinventario ) FROM `inventario` GROUP BY codigobarras) AND idventa ='" + idv + "'  GROUP BY codigobarras");
/*     */ 
/* 250 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 252 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 256 */       while (rs.next()) {
/* 257 */         Object[] fila = new Object[cantidadColumnas];
/* 258 */         for (int i = 1; i < cantidadColumnas; ++i) {
/* 259 */           actualizaAlmaDVenta(rs.getString("codigobarras"), Integer.parseInt(rs.getString("cantidad")));
/*     */         }
/*     */       }
/*     */ 
/* 263 */       rs.close();
/* 264 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 268 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void actualizaAlmaDVenta(String cb, int cant)
/*     */   {
/*     */     try
/*     */     {
/* 279 */       this.cadenasql2 = "UPDATE almacen  SET cantidad=cantidad-" + cant + " where codigobarras ='" + cb + "'";
/* 280 */       conexioninicio ci = new conexioninicio();
/* 281 */       Connection con = null;
/* 282 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 283 */       Statement stmt = con.createStatement();
/* 284 */       stmt.executeUpdate(this.cadenasql2);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 288 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   boolean validarVenta()
/*     */   {
/*     */     try
/*     */     {
/* 298 */       conexioninicio ci = new conexioninicio();
/* 299 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 302 */       Statement instruccionSQL = con.createStatement();
/* 303 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM venta ");
/*     */ 
/* 306 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 312 */     return false;
/*     */   }
/*     */ 
/*     */   boolean validarCompras()
/*     */   {
/*     */     try
/*     */     {
/* 322 */       conexioninicio ci = new conexioninicio();
/* 323 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 326 */       Statement instruccionSQL = con.createStatement();
/* 327 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM compra ");
/*     */ 
/* 330 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */   boolean checareltikcetventa()
/*     */   {
/*     */     try
/*     */     {
/* 347 */       conexioninicio ci = new conexioninicio();
/* 348 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 351 */       Statement instruccionSQL = con.createStatement();
/* 352 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM ticketventa ");
/*     */ 
/* 355 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 361 */     return false;
/*     */   }
/*     */ 
/*     */   boolean buscaridventa(String idventa)
/*     */   {
/*     */     try
/*     */     {
/* 371 */       conexioninicio ci = new conexioninicio();
/* 372 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 376 */       Statement instruccionSQL = con.createStatement();
/* 377 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM ticketventa WHERE idventa='" + idventa + "'");
/*     */ 
/* 380 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 386 */     return false;
/*     */   }
/*     */ 
/*     */   boolean buscaridventaenvent(String idventa)
/*     */   {
/*     */     try
/*     */     {
/* 395 */       conexioninicio ci = new conexioninicio();
/* 396 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 400 */       Statement instruccionSQL = con.createStatement();
/* 401 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM venta WHERE idventa='" + idventa + "'");
/*     */ 
/* 404 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 410 */     return false;
/*     */   }
/*     */

    public void update(String curp, String folioventa) {
        this.foliovent=folioventa;
        actualizacantidadesAlmacen(folioventa);
    }
 }

