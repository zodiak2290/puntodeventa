/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
import FabricadeVentanas.FabricaVentanas;
import FabricadeVentanas.VentanasAdministrador;
import FabricadeVentanas.VentanasCajero;
import VentanaPrincipalPrincipal.Principal;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import puntodeventa.inicio.EleccionLogin;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class PrincipalAdmin extends JFrame implements Principal
/*     */ {
            FabricaVentanas fv;
            AgregarArticulo aart;
/*     */   private Dimension dim;
/*     */   private JMenu jMenu1;
/*     */   private JMenu jMenu2;
/*     */   private JMenu jMenu3;
/*     */   private JMenu jMenu4;
/*     */   private JMenu jMenu5;
/*     */   private JMenu jMenu6;
/*     */   private JMenu jMenu7;
/*     */   private JMenu jMenu8;
/*     */   private JMenu jMenu9;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JMenuItem jMenuItem1;
/*     */   private JMenuItem jMenuItem10;
/*     */   private JMenuItem jMenuItem11;
/*     */   private JMenuItem jMenuItem12;
/*     */   private JMenuItem jMenuItem13;
/*     */   private JMenuItem jMenuItem14;
/*     */   private JMenuItem jMenuItem15;
/*     */   private JMenuItem jMenuItem16;
/*     */   private JMenuItem jMenuItem17;
/*     */   private JMenuItem jMenuItem18;
/*     */   private JMenuItem jMenuItem19;
/*     */   private JMenuItem jMenuItem2;
/*     */   private JMenuItem jMenuItem29;
/*     */   private JMenuItem jMenuItem3;
/*     */   private JMenuItem jMenuItem4;
/*     */   private JMenuItem jMenuItem5;
/*     */   private JMenuItem jMenuItem6;
/*     */   private JMenuItem jMenuItem7;
/*     */   private JMenuItem jMenuItem8;
/*     */   private JMenuItem jMenuItem9;
                String elUsr,elPw;
/*     */   public PrincipalAdmin()
/*     */   {
/*  30 */     setUndecorated(true);
/*  31 */     initComponents();
/*     */ 
/*  35 */     setSize(890, 145);
/*  36 */     setResizable(false);
/*  37 */     setLocationRelativeTo(null);
/*     */   }

/*     */   public void recibirUsuario(String Useri,String pass)
/*     */   {
              this.elUsr = Useri;
              this.elPw=pass;
/*     */   }
/*     */ 
/*     */   public String EnviarUsuario() {
/*  46 */     return elUsr;
/*     */   }
/*     */ 
/*     */    public void initComponents()
/*     */   {
/*  58 */     this.jMenuBar1 = new JMenuBar();
/*  59 */     this.jMenu1 = new JMenu();
/*  60 */     this.jMenuItem18 = new JMenuItem();
/*  61 */     this.jMenu3 = new JMenu();
/*  62 */     this.jMenu4 = new JMenu();
/*  63 */     this.jMenuItem3 = new JMenuItem();
/*  64 */     this.jMenuItem4 = new JMenuItem();
/*  65 */     this.jMenuItem5 = new JMenuItem();
/*  66 */     this.jMenuItem6 = new JMenuItem();
/*  67 */     this.jMenu5 = new JMenu();
/*  68 */     this.jMenuItem14 = new JMenuItem();
/*  69 */     this.jMenuItem15 = new JMenuItem();
/*  70 */     this.jMenuItem16 = new JMenuItem();
/*  71 */     this.jMenuItem17 = new JMenuItem();
/*  72 */     this.jMenu9 = new JMenu();
/*  73 */     this.jMenu6 = new JMenu();
/*  74 */     this.jMenuItem9 = new JMenuItem();
/*  75 */     this.jMenuItem10 = new JMenuItem();
/*  76 */     this.jMenuItem11 = new JMenuItem();
/*  77 */     this.jMenuItem29 = new JMenuItem();
/*  78 */     this.jMenu8 = new JMenu();
/*  79 */     this.jMenuItem12 = new JMenuItem();
/*  80 */     this.jMenuItem8 = new JMenuItem();
/*  81 */     this.jMenuItem19 = new JMenuItem();
/*  82 */     this.jMenu7 = new JMenu();
/*  83 */     this.jMenuItem7 = new JMenuItem();
/*  84 */     this.jMenuItem13 = new JMenuItem();
/*  85 */     this.jMenu2 = new JMenu();
/*  86 */     this.jMenuItem1 = new JMenuItem();
/*  87 */     this.jMenuItem2 = new JMenuItem();
/*     */ 
/*  89 */     setDefaultCloseOperation(3);
/*  90 */     setTitle(EnviarUsuario());
/*     */ 
/*  92 */     this.jMenuBar1.setBackground(new Color(204, 0, 255));
/*  93 */     this.jMenuBar1.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 204), 7));
/*     */ 
/*  95 */     this.jMenu1.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/file.png")));
/*     */ 
/*  97 */     this.jMenuItem18.setText("Respaldar Base de datos");
/*  98 */     this.jMenuItem18.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 100 */         PrincipalAdmin.this.jMenuItem18ActionPerformed(evt);
/*     */       }
/*     */     });
/* 103 */     this.jMenu1.add(this.jMenuItem18);
/*     */ 
/* 105 */     this.jMenuBar1.add(this.jMenu1);
/*     */ 
/* 107 */     this.jMenu3.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/card-file-icon.png")));
/* 108 */     this.jMenu3.setText("Registros");
/*     */ 
/* 110 */     this.jMenu4.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/admon.png")));
/* 111 */     this.jMenu4.setText("Aministradores");
/*     */ 
/* 113 */     this.jMenuItem3.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/add.png")));
/* 114 */     this.jMenuItem3.setText("Nuevo Administrador");
/* 115 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 117 */         PrincipalAdmin.this.jMenuItem3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 120 */     this.jMenu4.add(this.jMenuItem3);
/*     */ 
/* 122 */     this.jMenuItem4.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/delete.png")));
/* 123 */     this.jMenuItem4.setText("Darse de baja ");
/* 124 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 126 */         PrincipalAdmin.this.jMenuItem4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 129 */     this.jMenu4.add(this.jMenuItem4);
/*     */ 
/* 131 */     this.jMenuItem5.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/edit.png")));
/* 132 */     this.jMenuItem5.setText("Modificar mis datos");
/* 133 */     this.jMenuItem5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 135 */         PrincipalAdmin.this.jMenuItem5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 138 */     this.jMenu4.add(this.jMenuItem5);
/*     */ 
/* 140 */     this.jMenuItem6.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/list.png")));
/* 141 */     this.jMenuItem6.setText("Lista de administradores");
/* 142 */     this.jMenuItem6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 144 */         PrincipalAdmin.this.jMenuItem6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 147 */     this.jMenu4.add(this.jMenuItem6);
/*     */ 
/* 149 */     this.jMenu3.add(this.jMenu4);
/*     */ 
/* 151 */     this.jMenu5.setText("Cajeros");
/* 152 */     this.jMenu5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 154 */         PrincipalAdmin.this.jMenu5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 158 */     this.jMenuItem14.setText("Nuevo Cajero");
/* 159 */     this.jMenuItem14.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 161 */         PrincipalAdmin.this.jMenuItem14ActionPerformed(evt);
/*     */       }
/*     */     });
/* 164 */     this.jMenu5.add(this.jMenuItem14);
/*     */ 
/* 166 */     this.jMenuItem15.setText("Eliminar Cajero");
/* 167 */     this.jMenuItem15.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 169 */         PrincipalAdmin.this.jMenuItem15ActionPerformed(evt);
/*     */       }
/*     */     });
/* 172 */     this.jMenu5.add(this.jMenuItem15);
/*     */ 
/* 174 */     this.jMenuItem16.setText("Modificar Cajero");
/* 175 */     this.jMenuItem16.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 177 */         PrincipalAdmin.this.jMenuItem16ActionPerformed(evt);
/*     */       }
/*     */     });
/* 180 */     this.jMenu5.add(this.jMenuItem16);
/*     */ 
/* 182 */     this.jMenuItem17.setText("Lista de cajeros");
/* 183 */     this.jMenuItem17.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 185 */         PrincipalAdmin.this.jMenuItem17ActionPerformed(evt);
/*     */       }
/*     */     });
/* 188 */     this.jMenu5.add(this.jMenuItem17);
/*     */ 
/* 190 */     this.jMenu3.add(this.jMenu5);
/*     */ 
/* 192 */     this.jMenuBar1.add(this.jMenu3);
/*     */ 
/* 194 */     this.jMenu9.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/shop-icon.png")));
/* 195 */     this.jMenu9.setText("Tienda");
/*     */ 
/* 197 */     this.jMenu6.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/prod.png")));
/* 198 */     this.jMenu6.setText("Productos");
/*     */ 
/* 200 */     this.jMenuItem9.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/add.png")));
/* 201 */     this.jMenuItem9.setText("Nuevo Producto");
/* 202 */     this.jMenuItem9.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 204 */         PrincipalAdmin.this.jMenuItem9ActionPerformed(evt);
/*     */       }
/*     */     });
/* 207 */     this.jMenu6.add(this.jMenuItem9);
/*     */ 
/* 209 */     this.jMenuItem10.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/delete.png")));
/* 210 */     this.jMenuItem10.setText("Eliminar Producto");
/* 211 */     this.jMenuItem10.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 213 */         PrincipalAdmin.this.jMenuItem10ActionPerformed(evt);
/*     */       }
/*     */     });
/* 216 */     this.jMenu6.add(this.jMenuItem10);
/*     */ 
/* 218 */     this.jMenuItem11.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/edit.png")));
/* 219 */     this.jMenuItem11.setText("Modificar Producto");
/* 220 */     this.jMenuItem11.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 222 */         PrincipalAdmin.this.jMenuItem11ActionPerformed(evt);
/*     */       }
/*     */     });
/* 225 */     this.jMenu6.add(this.jMenuItem11);
/*     */ 
/* 227 */     this.jMenuItem29.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/precios.png")));
/* 228 */     this.jMenuItem29.setText("Agregar Compra  (Precios)");
/* 229 */     this.jMenuItem29.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 231 */         PrincipalAdmin.this.jMenuItem29ActionPerformed(evt);
/*     */       }
/*     */     });
/* 234 */     this.jMenu6.add(this.jMenuItem29);
/*     */ 
/* 236 */     this.jMenu9.add(this.jMenu6);
/*     */ 
/* 238 */     this.jMenu8.setText("Inversiones");
/*     */ 
/* 240 */     this.jMenuItem12.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/list.png")));
/* 241 */     this.jMenuItem12.setText("Listas");
/* 242 */     this.jMenuItem12.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 244 */         PrincipalAdmin.this.jMenuItem12ActionPerformed(evt);
/*     */       }
/*     */     });
/* 247 */     this.jMenu8.add(this.jMenuItem12);
/*     */ 
/* 249 */     this.jMenuItem8.setText("Inversion");
/* 250 */     this.jMenuItem8.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 252 */         PrincipalAdmin.this.jMenuItem8ActionPerformed(evt);
/*     */       }
/*     */     });
/* 255 */     this.jMenu8.add(this.jMenuItem8);
/*     */ 
/* 257 */     this.jMenu9.add(this.jMenu8);
/*     */ 
/* 259 */     this.jMenuItem19.setText("Datos de la tienda");
/* 260 */     this.jMenuItem19.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 262 */         PrincipalAdmin.this.jMenuItem19ActionPerformed(evt);
/*     */       }
/*     */     });
/* 265 */     this.jMenu9.add(this.jMenuItem19);
/*     */ 
/* 267 */     this.jMenuBar1.add(this.jMenu9);
/*     */ 
/* 269 */     this.jMenu7.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/ventas.png")));
/* 270 */     this.jMenu7.setText("Ventas");
/*     */ 
/* 272 */     this.jMenuItem7.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/buy.png")));
/* 273 */     this.jMenuItem7.setText("Realizar Ventas");
/* 274 */     this.jMenuItem7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 276 */         PrincipalAdmin.this.jMenuItem7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 279 */     this.jMenu7.add(this.jMenuItem7);
/*     */ 
/* 281 */     this.jMenuItem13.setText("Ventas");
/* 282 */     this.jMenuItem13.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 284 */         PrincipalAdmin.this.jMenuItem13ActionPerformed(evt);
/*     */       }
/*     */     });
/* 287 */     this.jMenu7.add(this.jMenuItem13);
/*     */ 
/* 289 */     this.jMenuBar1.add(this.jMenu7);
/*     */ 
/* 291 */     this.jMenu2.setBackground(new Color(0, 51, 255));
/* 292 */     this.jMenu2.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/login.png")));
/* 293 */     this.jMenu2.setText("Sesion");
/*     */ 
/* 295 */     this.jMenuItem1.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/cambiarsesion.png")));
/* 296 */     this.jMenuItem1.setText("Cerrar Sesion");
/* 297 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 299 */         PrincipalAdmin.this.jMenuItem1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 302 */     this.jMenu2.add(this.jMenuItem1);
/*     */ 
/* 304 */     this.jMenuItem2.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/cerrarsesion.png")));
/* 305 */     this.jMenuItem2.setText("Cerrar");
/* 306 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 308 */         PrincipalAdmin.this.jMenuItem2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 311 */     this.jMenu2.add(this.jMenuItem2);
/*     */ 
/* 313 */     this.jMenuBar1.add(this.jMenu2);
/*     */ 
/* 315 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 317 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 318 */     getContentPane().setLayout(layout);
/* 319 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 905, 32767));
/*     */ 
/* 323 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */ 
/* 328 */     pack();
/*     */   }
/*     */ 
/*     */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 332 */     EleccionLogin el = new EleccionLogin();
/* 333 */     el.elegir();
/* 334 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 338 */     int s = JOptionPane.showConfirmDialog(null, "Realmente desea salir de la aplicacion", "Confirmar salida", 0, 3);
/* 339 */     if (s != 0)
/*     */       return;
/* 341 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   private void jMenuItem3ActionPerformed(ActionEvent evt)
/*     */   {
               fv=new VentanasAdministrador();
               fv.crearVentana("Crear");
/*     */   }
/*     */ 
/*     */   private void jMenuItem5ActionPerformed(ActionEvent evt)
/*     */   {
                fv=new VentanasAdministrador();
                fv.crearVentana("Update");
/*     */   }
/*     */ 
/*     */   private void jMenuItem6ActionPerformed(ActionEvent evt)
/*     */   {
                fv=new VentanasAdministrador();
                fv.crearVentana("Read");
/*     */   }
/*     */ 
/*     */   private void jMenuItem7ActionPerformed(ActionEvent evt) {
/* 364 */     Ventas v = new Ventas();
/* 365 */     v.recibir(elUsr);
/* 366 */     v.ventas();
/*     */   }
/*     */ 
/*     */   private void jMenuItem4ActionPerformed(ActionEvent evt)
/*     */   {
/* 374 */     int s = JOptionPane.showConfirmDialog(this, "Por su seguridad para darse de baja son requeridos algunos datos,Al proporciona tales datos usted quedara dado de baja automaticamente del sistema", "La aplicacion se cerrara al terminar el proceso de baja", 0, 3);
/* 375 */     if (s != 0)
/*     */       return;
/* 377 */     String curp = JOptionPane.showInputDialog("Profecor Ingrese su CURP");
/* 378 */     String idadmin = JOptionPane.showInputDialog("Por favor Ingrese su ID de administrador");
/* 379 */     String contraseña = JOptionPane.showInputDialog("ingrese su contraseña ");
/* 380 */     System.out.println("admin" + idadmin);
/* 381 */     System.out.println("pas " + contraseña);
/* 382 */     System.out.println("crup " + curp);
/* 383 */     System.out.println("user " + elUsr);
/*     */     try
/*     */     {
/* 388 */       if ((idadmin.length() > 0) && (contraseña.length() > 0) && (curp.length() > 0))
/*     */       {
/* 392 */         if (elUsr.endsWith(idadmin)&&elPw.equals(contraseña))
/*     */         {
/* 394 */           Connection con = null;
/* 395 */           Connection con1 = null;
/*     */           try {
/* 397 */             conexioninicio ci2 = new conexioninicio();
/* 398 */             Class.forName("org.gjt.mm.mysql.Driver");
/* 399 */             con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 400 */             con1 = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 401 */             Statement stmt = con.createStatement();
/* 402 */             Statement stmts = con1.createStatement();
/* 403 */             String cadenasql = "DELETE FROM persona WHERE curp='" + curp + "'";
/* 404 */             String cadenasql2 = "DELETE FROM admin WHERE idadmon='" + idadmin + "' and contraseña='" + contraseña + "'";
/* 405 */             stmts.executeUpdate(cadenasql2);
/* 406 */             stmt.executeUpdate(cadenasql);
/* 407 */             System.exit(0);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 411 */             System.out.println("MENSO" + e.getMessage());
/*     */           }
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 420 */           JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contrasenia no son validos.");
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/* 425 */         JOptionPane.showMessageDialog(null, "Debe proporcionar los datos requeridos.\nNO deje campos vacios");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jMenuItem9ActionPerformed(ActionEvent evt)
/*     */   {
/* 437 */    aart=AgregarArticulo.getInstancia();
/* 438 */     
/*     */   }
/*     */ 
/*     */   private void jMenuItem11ActionPerformed(ActionEvent evt) {
/* 442 */     ModificarArticulo ma = new ModificarArticulo();
/* 443 */     ma.iniciaarMod();
/*     */   }
/*     */ 
/*     */   private void jMenuItem10ActionPerformed(ActionEvent evt) {
/* 447 */     EliminarProducto el = new EliminarProducto();
/* 448 */     el.eliminar();
/*     */   }
/*     */ 
/*     */   private void jMenuItem29ActionPerformed(ActionEvent evt) {
/* 452 */     MostrarProdDep mpd = new MostrarProdDep();
/* 453 */     mpd.mostrar();
/*     */   }
/*     */ 
/*     */   private void jMenuItem12ActionPerformed(ActionEvent evt) {
/* 457 */     new DetalleProducto().iniciar();
/*     */   }
/*     */ 
/*     */   private void jMenuItem8ActionPerformed(ActionEvent evt) {
/* 461 */     if (new Almacen().validarCompras()) {
/* 462 */       InversionFecha iv = new InversionFecha();
/* 463 */       iv.mostrar();
/*     */     } else {
/* 465 */       JOptionPane.showMessageDialog(null, "No hay compras registradas"); }
/*     */   }
/*     */ 
/*     */   private void jMenuItem13ActionPerformed(ActionEvent evt) {
/* 469 */     if (new Almacen().validarVenta()) {
/* 470 */       VentaFecha vf = new VentaFecha();
/* 471 */       vf.mostrar();
/*     */     } else {
/* 473 */       JOptionPane.showMessageDialog(null, "No ha realizado ventas");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jMenuItem14ActionPerformed(ActionEvent evt)
/*     */   {
                 fv=new VentanasCajero();
                 fv.crearVentana("Crear");
/*     */   }
/*     */ 
/*     */   private void jMenuItem16ActionPerformed(ActionEvent evt) {
/* 483 */     fv=new VentanasCajero();
              fv.crearVentana("Update");
/*     */   }
/*     */ 
/*     */   private void jMenuItem18ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jMenuItem15ActionPerformed(ActionEvent evt)
/*     */   {
/* 496 */     new EliminarCajero().eliminar();
/*     */   }
/*     */ 
/*     */   private void jMenu5ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jMenuItem19ActionPerformed(ActionEvent evt) {
/* 504 */     new AgregarSucursal().MostrarPirncipaladmin();
/*     */   }
/*     */ 
/*     */   private void jMenuItem17ActionPerformed(ActionEvent evt) {
            fv=new VentanasCajero();
            fv.crearVentana("Read");
/*     */   }
/*     */ 
/*     */   boolean validarUsuario()
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 519 */       conexioninicio ci = new conexioninicio();
/* 520 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 523 */       Statement instruccionSQL = con.createStatement();
/* 524 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM admin WHERE idadmon='" + elUsr + "' AND contraseña='" + elPw + "'");
/*     */ 
/* 527 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 533 */     return false;
/*     */   }
/*     */ 
/*     */   public void MostrarPirncipal()
/*     */   {
/* 541 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 545 */         new PrincipalAdmin().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */

    public boolean correcto() {
    try {
        return validarUsuario();
    } catch (IOException ex) {
        Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }
 }

