/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.awt.Desktop;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
/*     */ import javax.swing.JOptionPane;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class Impresora
/*     */ {
/*     */   String nombre;
/*     */   String calle;
/*     */   String num;
/*     */   String colonia;
/*     */   String municipio;
/*     */   String cp;
/*     */   String email;
/*     */   String mens1;
/*     */   String mens2;
/*     */   String telefono;
/*     */   String nombreest;
/*     */   String art;
            String rfc;
/*     */   private FileWriter fw;
/*     */   private BufferedWriter bw;
/*     */   private PrintWriter pw;
/*     */   private String dispositivo;
/*     */ 
/*     */   public Impresora()
/*     */   {
/*  35 */     this.dispositivo = ""; }
/*     */ 
/*     */   public void setDispositivo(String texto) {
/*  38 */     this.dispositivo = texto;
/*  39 */     if (texto.trim().length() <= 0)
/*     */     {
/*  46 */       this.dispositivo = "USB";
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  55 */       this.fw = new FileWriter(this.dispositivo);
/*  56 */       this.bw = new BufferedWriter(this.fw);
/*  57 */       this.pw = new PrintWriter(this.bw);
/*     */     } catch (Exception e) {
/*  59 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void escribir(String texto)
/*     */   {
/*     */     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//Le decimos el tipo de datos que vamos a enviar a la impresora
//Tipo: bytes Subtipo: autodetectado
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Creamos un trabajo de impresión
DocPrintJob pj = service.createPrintJob();
//Nuestro trabajo de impresión envía una cadena de texto
String ss=texto;
byte[] bytes;
//Transformamos el texto a bytes que es lo que soporta la impresora
bytes=ss.getBytes();
//Creamos un documento (Como si fuese una hoja de Word para imprimir)
Doc doc=new SimpleDoc(bytes,flavor,null);

//Obligado coger la excepción PrintException
try {
  //Mandamos a impremir el documento
  pj.print(doc, null);
}
catch (PrintException e) {
  System.out.println("Error al imprimir: "+e.getMessage());
}
/*     */   }
/*     */ 
/*     */   public void escribirdatos(String texto)
/*     */   {
/*     */     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//Le decimos el tipo de datos que vamos a enviar a la impresora
//Tipo: bytes Subtipo: autodetectado
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Creamos un trabajo de impresión
DocPrintJob pj = service.createPrintJob();
//Nuestro trabajo de impresión envía una cadena de texto
String ss=texto+"\n";
byte[] bytes;
//Transformamos el texto a bytes que es lo que soporta la impresora
bytes=ss.getBytes();
//Creamos un documento (Como si fuese una hoja de Word para imprimir)
Doc doc=new SimpleDoc(bytes,flavor,null);

//Obligado coger la excepción PrintException
try {
  //Mandamos a impremir el documento
  pj.print(doc, null);
}
catch (PrintException e) {
  System.out.println("Error al imprimir: "+e.getMessage());
}
/*     */   }
/*     */ 
/*     */   public void cortar()
/*     */   {
/*     */     try {
/*  87 */       char[] ESC_CUT_PAPER = { '\27', 'm' };
/*  88 */       if (!(this.dispositivo.trim().equals("pantalla.txt")))
/*  89 */         this.pw.write(ESC_CUT_PAPER);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  93 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void avanza_pagina() {
/*     */     try {
/*  99 */       if (!(this.dispositivo.trim().equals("pantalla.txt")))
/* 100 */         this.pw.write(12);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setRojo() {
/*     */     try {
/* 110 */       char[] ESC_CUT_PAPER = { '\27', 'r', '\1' };
/* 111 */       if (!(this.dispositivo.trim().equals("pantalla.txt")))
/* 112 */         this.pw.write(ESC_CUT_PAPER);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 116 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setNegro() {
/*     */     try {
/* 122 */       char[] ESC_CUT_PAPER = { '\27', 'r', '\0' };
/* 123 */       if (!(this.dispositivo.trim().equals("pantalla.txt")))
/* 124 */         this.pw.write(ESC_CUT_PAPER);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 128 */       System.out.print(e); }
/*     */   }
/*     */ 
/*     */  
/*     */ 
/*     */   public void setFormato(int formato) {
/*     */     try {
/* 144 */       char[] ESC_CUT_PAPER = { '\27', '!', (char)formato };
/* 145 */       if (!(this.dispositivo.trim().equals("pantalla.txt")))
/* 146 */         this.pw.write(ESC_CUT_PAPER);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 150 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void correr(int fin) {
/*     */     try {
/* 156 */       for (int i = 1; i <= fin; ++i)
/* 157 */         salto();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 161 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void salto() {
/*     */     try {
/* 167 */       this.pw.println("");
/*     */     }
/*     */     catch (Exception e) {
/* 170 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dividir()
/*     */   {
     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//Le decimos el tipo de datos que vamos a enviar a la impresora
//Tipo: bytes Subtipo: autodetectado
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Creamos un trabajo de impresión
DocPrintJob pj = service.createPrintJob();
//Nuestro trabajo de impresión envía una cadena de texto
String ss="----------------------------------------";
byte[] bytes;
//Transformamos el texto a bytes que es lo que soporta la impresora
bytes=ss.getBytes();
//Creamos un documento (Como si fuese una hoja de Word para imprimir)
Doc doc=new SimpleDoc(bytes,flavor,null);

//Obligado coger la excepción PrintException
try {
  //Mandamos a impremir el documento
  pj.print(doc, null);
}
catch (PrintException e) {
  System.out.println("Error al imprimir: "+e.getMessage());
}
/*     */   }
/*     */ 
/*     */   public void cerrarDispositivo()
/*     */   {
/*     */     try {
/* 182 */       this.pw.close();
/* 183 */       if (this.dispositivo.trim().equals("pantalla.txt"))
/*     */       {
/* 185 */         File archivo = new File("pantalla.txt");
/* 186 */         Desktop.getDesktop().open(archivo);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 190 */       System.out.print(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String CortarHoja() {
/* 195 */     return "\27m";
/*     */   }
/*     */ 
/*     */   public void hacerconsulta(String id, String efectivo, String cambio)
/*     */   {
/* 200 */     conexioninicio ci = new conexioninicio();
/* 201 */     Connection con = null;
/*     */     try
/*     */     {
/* 204 */       Class.forName("org.gjt.mm.mysql.Driver");
/* 205 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 206 */       Statement stmt = con.createStatement();
/* 207 */       String cadenasql = "select * from  sucursal natural join estado where numerotienda=1 ";
/* 208 */       ResultSet rs = stmt.executeQuery(cadenasql);
/* 209 */       while (rs.next()) {
/* 210 */         this.nombre = rs.getString("nombresuc");
/* 211 */         this.calle = rs.getString("calle");
                   this.rfc = rs.getString("rfc");
/* 212 */         this.num = rs.getString("nume");
/* 213 */         this.colonia = rs.getString("colonia");
/* 214 */         this.municipio = rs.getString("municipio");
/* 215 */         this.cp = rs.getString("cp");
/* 216 */         this.email = rs.getString("email");
/* 217 */         this.mens1 = rs.getString("mensaje1");
/* 218 */         this.mens2 = rs.getString("mensaje2");
/* 219 */         this.telefono = rs.getString("tel");
/* 220 */         this.nombreest = rs.getString("nombreest");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 225 */       System.out.println(e.getMessage());
/*     */     }
/* 227 */     imprimirse(id, efectivo, cambio);
/*     */   }
/*     */ 
/*     */   public void imprimirse(String id, String efectivo, String cambio)
/*     */   {
/* 232 */     Impresora p = new Impresora();
/* 233 */     p.setDispositivo("");
/*     */ 

/* 236 */     p.setRojo();
/* 237 */     p.escribirdatos("               "+this.nombre );
              p.escribirdatos("               RFC:"+rfc );
/* 238 */     p.escribirdatos("   " + this.calle +" #"+ this.num+" "+this.municipio);
/* 239 */     p.escribirdatos("   " + this.colonia );
/* 240 */     p.escribirdatos("   C.P.: " + this.cp   +"   "+this.nombreest);
/* 241 */     
/* 242 */     p.escribirdatos("   Venta: " + id);
/* 243 */     p.dividir();
/* 244 */     p.escribirdatos("   Prod               P.U   Cant Subt");
/* 245 */     p.cerrarDispositivo();
/* 246 */     articulos(id, efectivo, cambio);
/*     */   }
/*     */ 
/*     */   public void articulos(String id, String efectivo, String cambio)
/*     */   {
/* 257 */     Impresora p = new Impresora();
/* 258 */     p.setDispositivo("");
/* 259 */     conexioninicio ci = new conexioninicio();
/* 260 */     Connection con = null;
/*     */     try
/*     */     {
/* 264 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 265 */       Statement stmt = con.createStatement();
/*     */ 
/* 267 */       ResultSet rs = stmt.executeQuery(" SELECT  nombreart,nombremar,descripcion, medida,precioVenta,sum(cantidadprod) as cantidad ,sum(cantidadprod*precioVenta) as subtotal FROM marca NATURAL JOIN articulo NATURAL JOIN ticketventa natural join inventario WHERE idinventario in (SELECT MAX( idinventario ) FROM  `inventario` group by codigobarras)  and idventa='" + id + "' group by codigobarras");
/* 268 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 271 */       while (rs.next()) {
/* 272 */         p.escribir("" + rs.getString("nombreart").toLowerCase().substring(0, 4) + " " + rs.getString("nombremar").toLowerCase().substring(0, 4) + " " + rs.getString("descripcion").substring(0, 6) + rs.getString("medida") + "\r");
                  
/* 273 */         p.escribirpre("            "+ rs.getString("precioVenta")+"\r" );
                  p.escribirpre("                  "+rs.getString("cantidad")+"\r");
                  p.escribirpre("                       "+rs.getString("subtotal")+"\n");
/*     */       }
/* 275 */       p.escribirpre("           Total M.N $" + total(id)+"\n");
/* 276 */       p.escribirpre("           Efectivo  $" + efectivo+"\n");
/* 277 */       p.escribirpre("           Cambio    $" + cambio+"\n");
/* 278 */       p.escribirdatos("******" + this.mens1 +"******");
/* 279 */       p.dividir();
/* 280 */       p.escribirdatos("       Quejas o sugerencias:");
                p.escribirdatos("Email:"+this.email);
                p.escribirdatos("Tel: " + this.telefono        );
/* 281 */       Date fechaactual = new Date();
/* 282 */       p.escribirdatos("Fecha de venta: " + fechaactual);
/* 283 */       p.escribirdatos("****"+this.mens2+"****");
                p.escribirdatos("                            ");
                p.escribirdatos("                            ");
                p.escribirdatos("                            ");
                p.escribirdatos("                            ");
                p.escribirdatos("                            ");
                p.escribirdatos("                            ");
                p.escribirdatos("                            ");
/* 284 */       p.CortarHoja();
/* 285 */       cerrarDispositivo();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 290 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */ 
/* 295 */     p.cerrarDispositivo();
/*     */   }
/*     */ 
/*     */   public void escribirpre(String texto) {
/*     */     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//Le decimos el tipo de datos que vamos a enviar a la impresora
//Tipo: bytes Subtipo: autodetectado
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Creamos un trabajo de impresión
DocPrintJob pj = service.createPrintJob();
//Nuestro trabajo de impresión envía una cadena de texto
String ss="            "+texto;
byte[] bytes;
//Transformamos el texto a bytes que es lo que soporta la impresora
bytes=ss.getBytes();
//Creamos un documento (Como si fuese una hoja de Word para imprimir)
Doc doc=new SimpleDoc(bytes,flavor,null);

//Obligado coger la excepción PrintException
try {
  //Mandamos a impremir el documento
  pj.print(doc, null);
}
catch (PrintException e) {
  System.out.println("Error al imprimir: "+e.getMessage());
}
/*     */   }
/*     */ 
/*     */   public String total(String id)
/*     */   {
/* 310 */     String total = "";
/* 311 */     conexioninicio ci = new conexioninicio();
/* 312 */     Connection con = null;
/*     */     try {
/* 314 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 315 */       Statement stmt = con.createStatement();
/* 316 */       ResultSet rs = stmt.executeQuery(" SELECT  sum(cantidadprod*precioVenta) as total FROM marca NATURAL JOIN articulo NATURAL JOIN ticketventa natural join inventario WHERE idinventario in (SELECT MAX( idinventario ) FROM  `inventario` group by codigobarras)  and  idventa='" + id + "'");
/* 317 */       ResultSetMetaData rsMd = rs.getMetaData();
/* 318 */       while (rs.next()) {
/* 319 */         total = rs.getString("total");
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 326 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */ 
/* 329 */     return total;
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.Impresora
 * JD-Core Version:    0.5.3
 */