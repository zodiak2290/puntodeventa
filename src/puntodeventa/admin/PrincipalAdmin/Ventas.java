/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
          import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
          import puntodeventa.MDP.Observer;
          import puntodeventa.MDP.Subject;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class Ventas extends JFrame implements Subject
/*     */ {
            private ArrayList observers;
	    private String foliovent;
            String curp = new Almacen().buscarCurp(User);
/*     */   private Dimension dim;
/*     */   static String User;
            Almacen al=new Almacen();
            
/*     */   float cambio;
/*     */   private JTextField cant;
/*     */   private JTextField cb;
/*     */   private JTextField cbe;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JButton jButton5;
/*     */   private JButton jButton6;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JMenu jMenu1;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JScrollPane jScrollPane3;
/*     */   private JScrollPane jScrollPane4;
/*     */   private JTable jTable1;
/*     */   private JTable jTable2;
/*     */   private JTextField pago;
/*     */   private JTable tablasm;
/*     */ 
/*     */   public Ventas()
/*     */   {
            observers=new ArrayList();
            al.setSubjectVenta(this);
/*  37 */     initComponents();
/*     */ 
/*  39 */     setSize(910, 510);
/*  40 */     setResizable(false);
/*  41 */     setLocationRelativeTo(null);
/*     */ 
/*  43 */     getRootPane().setDefaultButton(this.jButton3);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  57 */     this.jScrollPane2 = new JScrollPane();
/*  58 */     this.jScrollPane1 = new JScrollPane();
/*  59 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/*  61 */         return false;
/*     */       }
/*     */     };
/*  64 */     this.cb = new JTextField();
/*  65 */     this.jLabel3 = new JLabel();
/*  66 */     this.cant = new JTextField();
/*  67 */     this.jButton2 = new JButton();
/*  68 */     this.jButton3 = new JButton();
/*  69 */     this.jScrollPane3 = new JScrollPane();
/*  70 */     this.jTable1 = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/*  72 */         return false;
/*     */       }
/*     */     };
/*  75 */     this.jLabel1 = new JLabel();
/*  76 */     this.cbe = new JTextField();
/*  77 */     this.jButton1 = new JButton();
/*  78 */     this.jButton4 = new JButton();
/*  79 */     this.jButton5 = new JButton();
/*  80 */     this.jScrollPane4 = new JScrollPane();
/*  81 */     this.jTable2 = new JTable() {
/*     */   @Override
       public boolean isCellEditable(int rowIndex, int colIndex) {
/*  83 */         return false;
/*     */       }
/*     */     };
/*  86 */     this.pago = new JTextField();
/*  87 */     this.jLabel2 = new JLabel();
/*  88 */     this.jLabel4 = new JLabel();
/*  89 */     this.jButton6 = new JButton();
/*  90 */     this.jMenuBar1 = new JMenuBar();
/*  91 */     this.jMenu1 = new JMenu();
/*     */ 
/*  93 */     setDefaultCloseOperation(2);
/*  94 */     setTitle("Ventas");
/*  95 */     addWindowListener(new WindowAdapter() {
/*     */   @Override
       public void windowClosing(WindowEvent evt) {
/*  97 */         Ventas.this.formWindowClosing(evt);
/*     */       }
/*     */     });
/* 100 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 102 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Codigo ", "Articulo", "Precio Compra ", "Precio Venta" })
/*     */     {
/*     */       boolean[] canEdit;
/*     */ 
/*     */   @Override
       public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */       {
/* 118 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 121 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 123 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 760, 340));
/* 124 */     getContentPane().add(this.cb, new AbsoluteConstraints(770, 140, 110, -1));
/*     */ 
/* 126 */     this.jLabel3.setText(" Cantidad");
/* 127 */     getContentPane().add(this.jLabel3, new AbsoluteConstraints(800, 60, -1, -1));
/* 128 */     getContentPane().add(this.cant, new AbsoluteConstraints(790, 80, 70, -1));
/*     */ 
/* 130 */     this.jButton2.setText("Relaizar Venta");
/* 131 */     this.jButton2.setBorder(null);
/* 132 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 134 */         Ventas.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 137 */     getContentPane().add(this.jButton2, new AbsoluteConstraints(780, 290, 100, -1));
/*     */ 
/* 139 */     this.jButton3.setText("Agregar Producto");
/* 140 */     this.jButton3.setBorder(null);
/* 141 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 143 */         Ventas.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 146 */     getContentPane().add(this.jButton3, new AbsoluteConstraints(780, 110, -1, -1));
/*     */ 
/* 148 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null } }, new String[] { "Total" }));
/*     */ 
/* 156 */     this.jTable1.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 158 */         Ventas.this.jTable1FocusGained(evt);
/*     */       }
/*     */     });
/* 161 */     this.jScrollPane3.setViewportView(this.jTable1);
/*     */ 
/* 163 */     getContentPane().add(this.jScrollPane3, new AbsoluteConstraints(580, 340, 180, 50));
/*     */ 
/* 165 */     this.jLabel1.setText("Quitar producto de la venta");
/* 166 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(20, 370, 170, -1));
/*     */ 
/* 168 */     this.cbe.setToolTipText("Ingrese codigo");
/* 169 */     getContentPane().add(this.cbe, new AbsoluteConstraints(30, 390, 160, -1));
/*     */ 
/* 171 */     this.jButton1.setText("Quitar");
/* 172 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 174 */         Ventas.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 177 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(210, 390, -1, -1));
/*     */ 
/* 179 */     this.jButton4.setText("Cancelar Venta");
/* 180 */     this.jButton4.setBorder(null);
/* 181 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 183 */         Ventas.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 186 */     getContentPane().add(this.jButton4, new AbsoluteConstraints(790, 400, -1, -1));
/*     */ 
/* 188 */     this.jButton5.setText("Salir");
/* 189 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 191 */         Ventas.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 194 */     getContentPane().add(this.jButton5, new AbsoluteConstraints(790, 430, 80, -1));
/*     */ 
/* 196 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null } }, new String[] { "Cambio" }));
/*     */ 
/* 204 */     this.jTable2.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 206 */         Ventas.this.jTable2FocusGained(evt);
/*     */       }
/*     */     });
/* 209 */     this.jScrollPane4.setViewportView(this.jTable2);
/*     */ 
/* 211 */     getContentPane().add(this.jScrollPane4, new AbsoluteConstraints(580, 390, 180, 50));
/* 212 */     getContentPane().add(this.pago, new AbsoluteConstraints(490, 380, 80, -1));
/*     */ 
/* 214 */     this.jLabel2.setText("Pago");
/* 215 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(450, 380, -1, -1));
/*     */ 
/* 217 */     this.jLabel4.setText("Seleccionar para ver Cambio");
/* 218 */     getContentPane().add(this.jLabel4, new AbsoluteConstraints(430, 420, -1, -1));
/*     */ 
/* 220 */     this.jButton6.setText("Venta Nueva");
/* 221 */     this.jButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 223 */         Ventas.this.jButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 226 */     getContentPane().add(this.jButton6, new AbsoluteConstraints(790, 20, -1, -1));
/*     */ 
/* 228 */     this.jMenu1.setText("Archivo");
/* 229 */     this.jMenuBar1.add(this.jMenu1);
/*     */ 
/* 231 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 233 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 237 */     
/*     */ 
/* 244 */     if (!(this.foliovent.equals(""))) {
/*     */       try
/*     */       {
/* 247 */         conexioninicio ci = new conexioninicio();
/*     */         try
/*     */         {
/* 250 */           Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 252 */           String cadenasql = "insert into tienda.venta(idventa,curp,fecha) values('" + this.foliovent + "','" + curp + "',CURRENT_DATE)";
/* 253 */           Statement stmt = con.createStatement();
/* 254 */           stmt.executeUpdate(cadenasql);
/* 255 */           mostrarTabla("l");
/* 256 */           mostrarTablaTotal("l");
/* 257 */           //new Almacen().actualizacantidadesAlmacen(this.foliovent);
/*     */          imprimirticket();
                     this.measurementsChanged();   
/* 261 */           this.pago.setText("");
/* 262 */           this.foliovent = "";
/* 263 */           this.cambio = 0.0F;
/* 264 */           mostrarTablaCambio();
/*     */         }
/*     */         catch (SQLException e)
/*     */         {
/* 269 */           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 274 */         System.out.println(e.getMessage());
/*     */       }
/*     */     }
/*     */     else {
/* 278 */       JOptionPane.showMessageDialog(null, "Ingrese Productos", "Error", 0);
/*     */     }
/*     */ 
/* 285 */     this.foliovent = "";
/*     */   }
/*     */ 
/*     */   public void imprimirticket() {
/* 289 */     int s = JOptionPane.showConfirmDialog(null, "Imprimir ticket?", "Confirmar", 0, 3);
/* 290 */     if (s != 0)
/*     */       return;
/* 292 */     new Impresora().hacerconsulta(this.foliovent, this.pago.getText(), String.valueOf(this.cambio));
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 297 */     if (this.cb.getText().length() > 0)
/*     */     {
/* 299 */       if (!(this.foliovent.equals("")))
/*     */         try
/*     */         {
/* 302 */           if (validarCodigo(this.cb.getText())) {
/* 303 */             Almacen a = new Almacen();
/*     */ 
/* 306 */             int idinv = a.buscarPrecio(this.cb.getText().toUpperCase());
/*     */             try {
/* 308 */               conexioninicio ci = new conexioninicio();
/*     */               try
/*     */               {
/* 311 */                 String cadenasql = null;
/* 312 */                 Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 313 */                 if (this.cant.getText().length() > 0)
/* 314 */                   cadenasql = "insert into tienda.ticketventa(idventa,cantidadprod,idinventario,idcompra) values('" + this.foliovent + "'," + Integer.parseInt(this.cant.getText()) + "," + idinv + ",1)";
/*     */                 else {
/* 316 */                   cadenasql = "insert into tienda.ticketventa(idventa,cantidadprod,idinventario,idcompra) values('" + this.foliovent + "'," + 1 + "," + idinv + ",1)";
/*     */                 }
/* 318 */                 Statement stmt = con.createStatement();
/* 319 */                 stmt.executeUpdate(cadenasql);
/* 320 */                 this.cant.setText("");
/* 321 */                 this.cb.setText("");
                         
/* 322 */                 mostrarTabla(this.foliovent);
/* 323 */                 mostrarTablaTotal(this.foliovent);
/*     */               }
/*     */               catch (SQLException e) {
/* 326 */                 JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */               }
/*     */             } catch (Exception e) {
/* 329 */               System.out.println(e.getMessage());
/*     */             }
/*     */           } else {
/* 332 */             JOptionPane.showMessageDialog(null, "Verifique el codigo");
/*     */           }
/*     */         } catch (IOException ex) {
/* 335 */           Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       else {
/* 338 */         JOptionPane.showMessageDialog(null, "Presione el boton de nueva venta");
/*     */       }
/*     */     }
/*     */     else
/* 342 */       JOptionPane.showMessageDialog(null, "No ha escrito ningun codigo");
/*     */   }
/*     */ 
/*     */   boolean validarCodigo(String cb)
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 355 */       conexioninicio ci = new conexioninicio();
/* 356 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 359 */       Statement instruccionSQL = con.createStatement();
/* 360 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM inventario WHERE codigobarras='" + cb + "'");
/*     */ 
/* 363 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 369 */     return false;
/*     */   }
/*     */ 
/*     */   public void mostrarTabla(String idven)
/*     */   {
/* 376 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 378 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 380 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 382 */     Connection con = null;
/*     */     try
/*     */     {
/* 386 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 387 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 389 */       this.tablasm.setModel(modelo);
/*     */ 
/* 391 */       Statement stmt = con.createStatement();
/*     */ 
/* 393 */       ResultSet rs = stmt.executeQuery(" SELECT  nombreart as Articulo,nombremar AS Marca,descripcion as Descripcion, medida as Medida,precioVenta as 'Precio venta' ,sum(cantidadprod) as Cantidad ,sum(cantidadprod*precioVenta) as Subtotal FROM marca NATURAL JOIN articulo NATURAL JOIN ticketventa natural join inventario WHERE idinventario in (SELECT MAX( idinventario ) FROM  `inventario` group by codigobarras)  and idventa='" + idven + "' group by codigobarras");
/* 394 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 396 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 398 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 399 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 401 */       while (rs.next()) {
/* 402 */         Object[] fila = new Object[cantidadColumnas];
/* 403 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 405 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 407 */         modelo.addRow(fila);
/*     */       }
/* 409 */       rs.close();
/* 410 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 415 */       if (con == null)
/*     */         return;
/*     */       try {
/* 418 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 420 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 422 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void mostrarTablaTotal(String idven)
/*     */   {
/* 431 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 433 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 435 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 437 */     Connection con = null;
/*     */     try
/*     */     {
/* 441 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 442 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 444 */       this.jTable1.setModel(modelo);
/*     */ 
/* 446 */       Statement stmt = con.createStatement();
/*     */ 
/* 448 */       ResultSet rs = stmt.executeQuery(" SELECT  sum(cantidadprod*precioVenta) as Total FROM marca NATURAL JOIN articulo NATURAL JOIN ticketventa natural join inventario WHERE idinventario in (SELECT MAX( idinventario ) FROM  `inventario` group by codigobarras)  and  idventa='" + idven + "'");
/* 449 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 451 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 453 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 454 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 456 */       while (rs.next()) {
/* 457 */         Object[] fila = new Object[cantidadColumnas];
/* 458 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 460 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 462 */         modelo.addRow(fila);
/*     */       }
/* 464 */       rs.close();
/* 465 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 469 */       if (con == null)
/*     */         return;
/*     */       try {
/* 472 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 474 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 476 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void mostrarTablaCambio()
/*     */   {
/* 486 */     if (this.pago.getText().length() > 0) {
/* 487 */       double total = ((Double)(Double)this.jTable1.getValueAt(0, 0)).doubleValue();
/*     */ 
/* 489 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 491 */       this.jTable2.setModel(modelo);
/* 492 */       int cantidadColumnas = 1;
/* 493 */       for (int i = 0; i <= cantidadColumnas; ++i) {
/* 494 */         modelo.addColumn("Cambio");
/*     */       }
/*     */ 
/* 497 */       Object[] fila = new Object[cantidadColumnas];
/* 498 */       for (int i = 0; i < cantidadColumnas; ++i) {
/* 499 */         fila[i] = Double.valueOf(Float.parseFloat(this.pago.getText()) - total);
/* 500 */         this.cambio = (Float.parseFloat(this.pago.getText()) - (float)total);
/*     */       }
/* 502 */       modelo.addRow(fila);
/*     */     }
/* 505 */     else if (this.pago.getText().length() == 0) {
/* 506 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 508 */       this.jTable2.setModel(modelo);
/* 509 */       int cantidadColumnas = 1;
/* 510 */       for (int i = 0; i <= cantidadColumnas; ++i) {
/* 511 */         modelo.addColumn("Cambio");
/*     */       }
/* 513 */       Object[] fila = new Object[cantidadColumnas];
/* 514 */       for (int i = 0; i < cantidadColumnas; ++i) {
/* 515 */         fila[i] = Integer.valueOf(0);
/* 516 */         this.cambio = 0.0F;
/*     */       }
/* 518 */       modelo.addRow(fila);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void recibir(String Useri)
/*     */   {
/* 524 */     User = Useri;
/*     */   }
/*     */ 
/*     */   private void jTable1FocusGained(FocusEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 534 */     if (this.cbe.getText().length() > 0)
/*     */     {
/*     */       try
/*     */       {
/* 539 */         int s = JOptionPane.showConfirmDialog(this, "Eliminar el producto?", "Confirmacion", 0, 3);
/* 540 */         if (s == 0)
/*     */         {
/* 542 */           int idinv = new Almacen().buscarPrecio(this.cbe.getText().toUpperCase());
/*     */ 
/* 544 */           if (validarCodigo(this.cbe.getText()))
/*     */           {
/*     */             try
/*     */             {
/* 549 */               conexioninicio ci2 = new conexioninicio();
/* 550 */               Class.forName("org.gjt.mm.mysql.Driver");
/* 551 */               Connection con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 552 */               Statement stmt = con.createStatement();
/* 553 */               String cadenasql = "DELETE FROM ticketventa WHERE idventa='" + this.foliovent + "' and idinventario=" + idinv;
/* 554 */               stmt.executeUpdate(cadenasql);
/* 555 */               mostrarTabla(this.foliovent);
/* 556 */               mostrarTablaTotal(this.foliovent);
/*     */             }
/*     */             catch (Exception e)
/*     */             {
/* 561 */               System.out.println("Consulte detalles del sistema" + e.getMessage());
/*     */             }
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 567 */             JOptionPane.showMessageDialog(null, "El codigo no existe");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 577 */         System.out.println(e.getMessage());
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 583 */       JOptionPane.showMessageDialog(null, "Ingrese codigo de barras.");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 591 */     if (new Almacen().buscaridventa(this.foliovent)) {
/*     */       try
/*     */       {
/* 594 */         String user = JOptionPane.showInputDialog("Nombre de administrador");
/* 595 */         String pass = JOptionPane.showInputDialog("Contraseña");
/*     */ 
/* 598 */         if (validarUsuario(user, pass))
/*     */         {
/*     */           try
/*     */           {
/* 605 */             conexioninicio ci2 = new conexioninicio();
/* 606 */             Class.forName("org.gjt.mm.mysql.Driver");
/* 607 */             Connection con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 608 */             Statement stmt = con.createStatement();
/* 609 */             String cadenasql = "DELETE FROM ticketventa WHERE idventa='" + this.foliovent + "'";
/* 610 */             stmt.executeUpdate(cadenasql);
/* 611 */             mostrarTabla("a");
/* 612 */             mostrarTablaTotal("a");
/* 613 */             this.foliovent = null;
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 617 */             System.out.println("Consulte detalles del sistema" + e.getMessage());
/*     */           }
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 624 */           JOptionPane.showMessageDialog(null, "Datos incorrectos");
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 629 */         System.out.println(e.getMessage());
/*     */       }
/*     */     }
/*     */     else
/* 633 */       JOptionPane.showMessageDialog(null, "No hay productos");
/*     */   }
/*     */ 
/*     */   private void formWindowClosing(WindowEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt)
/*     */   {
/* 646 */     int s = JOptionPane.showConfirmDialog(this, "Salir de la venta, verifique que no tenga productos en la tabla de venta", "Confirmacion", 0, 3);
/* 647 */     if (s != 0) return; dispose();
/*     */   }
/*     */ 
/*     */   private void jTable2FocusGained(FocusEvent evt) {
/* 651 */     mostrarTablaCambio();
/*     */   }
/*     */ 
/*     */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 655 */     Date fechaactual = new Date();
/* 656 */     this.foliovent = User + fechaactual.getYear() + fechaactual.getDay() + fechaactual.getHours() + fechaactual.getMinutes() + fechaactual.getSeconds() + (int)(Math.random() * 100.0D);
/* 657 */     System.out.println(this.foliovent);
/* 658 */     System.out.println(fechaactual.getHours());
/*     */   }
/*     */ 
/*     */   boolean validarUsuario(String elUsr, String elPw)
/*     */   {
/*     */     try
/*     */     {
/* 672 */       conexioninicio ci = new conexioninicio();
/* 673 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 676 */       Statement instruccionSQL = con.createStatement();
/* 677 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM admin WHERE idadmon='" + elUsr + "' AND contraseña='" + elPw + "'");
/*     */ 
/* 680 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 686 */     return false;
/*     */   }
/*     */ 
/*     */   public void ventas()
/*     */   {
/* 696 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 700 */         new Ventas().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */

    public void registerObserver(Observer o){
		observers.add(o);
	}
	public void removeObserver(Observer o){
		int i=observers.indexOf(o);
		if(i>=0){
			observers.remove(i);
		}
	}
    public void notifyObservers(){
    	for(int i=0;i<observers.size();i++){
    		Observer observer=(Observer)observers.get(i);
    		observer.update(curp,foliovent);
    	}
    }
    public void measurementsChanged(){
    	notifyObservers();
    }
    
 }

