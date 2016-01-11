/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class DetalleProducto extends JFrame
/*     */ {
            AgregarArticulo aart;
/*     */   private Dimension dim;
/*     */   private JLabel jLabel1;
/*     */   private JMenu jMenu1;
/*     */   private JMenu jMenu2;
/*     */   private JMenu jMenu3;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JMenuItem jMenuItem1;
/*     */   private JMenuItem jMenuItem2;
/*     */   private JMenuItem jMenuItem3;
/*     */   private JMenuItem jMenuItem4;
/*     */   private JMenuItem jMenuItem5;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JScrollPane jScrollPane3;
/*     */   private JScrollPane jScrollPane4;
/*     */   private JScrollPane jScrollPane5;
/*     */   private JScrollPane jScrollPane6;
/*     */   private JScrollPane jScrollPane7;
/*     */   private JTable jTable1;
/*     */   private JTable tablamar;
/*     */   private JTable tablasm;
/*     */   private JTable total;
/*     */   private JTable total1;
/*     */   private JTable total2;
/*     */ 
/*     */   public DetalleProducto()
/*     */   {
/*  29 */     initComponents();
/*  30 */     setSize(1265, 768);
/*  31 */     setLocationRelativeTo(null);
/*  32 */     setResizable(false);
/*  33 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/*  35 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  37 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  39 */     Connection con = null;
/*     */     try
/*     */     {
/*  43 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  44 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/*  46 */       this.tablasm.setModel(modelo);
/*     */ 
/*  48 */       Statement stmt = con.createStatement();
/*     */ 
/*  50 */       ResultSet rs = stmt.executeQuery("SELECT nombredep AS Departamento, nombremar AS Marca, codigobarras AS Codigo, nombreart Articulo, sum(cantidadcomp) AS 'Cantidad Comprada', descripcion AS Descripcion, medida AS Medida, sum( cantidadcomp * preciocom ) AS 'Inversion por producto $' FROM compra NATURAL JOIN articulo  NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras) GROUP BY codigobarras ORDER BY departamento, marca, articulo ");
/*  51 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  53 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  55 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/*  56 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/*  58 */       while (rs.next()) {
/*  59 */         Object[] fila = new Object[cantidadColumnas];
/*  60 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/*  62 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/*  64 */         modelo.addRow(fila);
/*     */       }
/*  66 */       rs.close();
/*  67 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  71 */       if (con != null)
/*     */       {
/*     */         try {
/*  74 */           con.rollback();
/*     */         } catch (SQLException ex) {
/*  76 */           Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*  78 */         JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  83 */     total();
/*  84 */     mostrarprod();
/*  85 */     totalDep();
/*  86 */     mostrarmar();
/*  87 */     totalMar();
/*     */   }
/*     */ 
/*     */   public final void total()
/*     */   {
/*  92 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/*  94 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  96 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  98 */     Connection con = null;
/*     */     try
/*     */     {
/* 102 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 103 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 105 */       this.total.setModel(modelo);
/*     */ 
/* 107 */       Statement stmt = con.createStatement();
/*     */ 
/* 109 */       ResultSet rs = stmt.executeQuery("SELECT count( DISTINCT codigobarras ) AS Articulos, sum( cantidadcomp ) AS 'Productos Comprados', sum( cantidadcomp * preciocom ) AS 'Inversion Total$' FROM compra NATURAL JOIN articulo NATURAL JOIN almacen NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras) ");
/* 110 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 112 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 114 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 115 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 117 */       while (rs.next()) {
/* 118 */         Object[] fila = new Object[cantidadColumnas];
/* 119 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 121 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 123 */         modelo.addRow(fila);
/*     */       }
/* 125 */       rs.close();
/* 126 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 130 */       if (con == null)
/*     */         return;
/*     */       try {
/* 133 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 135 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 137 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final void mostrarprod()
/*     */   {
/* 147 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 149 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 151 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 153 */     Connection con = null;
/*     */     try
/*     */     {
/* 157 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 158 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 160 */       this.jTable1.setModel(modelo);
/*     */ 
/* 162 */       Statement stmt = con.createStatement();
/*     */ 
/* 164 */       ResultSet rs = stmt.executeQuery("SELECT nombredep AS Departamento, count(distinct idmarca) as Marcas,sum(cantidadcomp) AS 'Productos comprados', sum( cantidadcomp * preciocom ) AS 'Inversion en Departamento $' FROM compra NATURAL JOIN articulo  NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras) GROUP BY departamento ORDER BY departamento");
/* 165 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 167 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 169 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 170 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 172 */       while (rs.next()) {
/* 173 */         Object[] fila = new Object[cantidadColumnas];
/* 174 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 176 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 178 */         modelo.addRow(fila);
/*     */       }
/* 180 */       rs.close();
/* 181 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 185 */       if (con == null)
/*     */         return;
/*     */       try {
/* 188 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 190 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 192 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final void totalDep()
/*     */   {
/* 202 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 204 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 206 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 208 */     Connection con = null;
/*     */     try
/*     */     {
/* 212 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 213 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 215 */       this.total1.setModel(modelo);
/*     */ 
/* 217 */       Statement stmt = con.createStatement();
/*     */ 
/* 219 */       ResultSet rs = stmt.executeQuery("SELECT  count( DISTINCT iddepartamento ) AS Departamentos FROM compra NATURAL JOIN articulo NATURAL JOIN almacen NATURAL JOIN departamento NATURAL JOIN marca WHERE idcompra IN (SELECT MAX( idcompra ) FROM compra GROUP BY codigobarras)");
/* 220 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 222 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 224 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 225 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 227 */       while (rs.next()) {
/* 228 */         Object[] fila = new Object[cantidadColumnas];
/* 229 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 231 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 233 */         modelo.addRow(fila);
/*     */       }
/* 235 */       rs.close();
/* 236 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 240 */       if (con == null)
/*     */         return;
/*     */       try {
/* 243 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 245 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 247 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final void mostrarmar()
/*     */   {
/* 258 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 260 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 262 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 264 */     Connection con = null;
/*     */     try
/*     */     {
/* 268 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 269 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 271 */       this.tablamar.setModel(modelo);
/*     */ 
/* 273 */       Statement stmt = con.createStatement();
/*     */ 
/* 275 */       ResultSet rs = stmt.executeQuery("SELECT nombredep AS Departamento, nombremar AS Marca, sum(cantidadcomp) AS 'Cantidad Comprada', sum( cantidadcomp * preciocom ) AS 'Inversion por Marca$' FROM compra NATURAL JOIN articulo  NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras) GROUP BY idmarca ORDER BY departamento, marca");
/* 276 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 278 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 280 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 281 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 283 */       while (rs.next()) {
/* 284 */         Object[] fila = new Object[cantidadColumnas];
/* 285 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 287 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 289 */         modelo.addRow(fila);
/*     */       }
/* 291 */       rs.close();
/* 292 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 296 */       if (con == null)
/*     */         return;
/*     */       try {
/* 299 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 301 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 303 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final void totalMar()
/*     */   {
/* 313 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 315 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 317 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 319 */     Connection con = null;
/*     */     try
/*     */     {
/* 323 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 324 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 326 */       this.total2.setModel(modelo);
/*     */ 
/* 328 */       Statement stmt = con.createStatement();
/*     */ 
/* 330 */       ResultSet rs = stmt.executeQuery("SELECT  count( DISTINCT idmarca ) AS Marcas FROM compra NATURAL JOIN articulo NATURAL JOIN almacen NATURAL JOIN departamento NATURAL JOIN marca WHERE idcompra IN (SELECT MAX( idcompra ) FROM compra GROUP BY codigobarras)");
/* 331 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 333 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 335 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 336 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 338 */       while (rs.next()) {
/* 339 */         Object[] fila = new Object[cantidadColumnas];
/* 340 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 342 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 344 */         modelo.addRow(fila);
/*     */       }
/* 346 */       rs.close();
/* 347 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 351 */       if (con == null)
/*     */         return;
/*     */       try {
/* 354 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 356 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 358 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 374 */     this.jScrollPane2 = new JScrollPane();
/* 375 */     this.jScrollPane1 = new JScrollPane();
/* 376 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 378 */         return false;
/*     */       }
/*     */     };
/* 381 */     this.jScrollPane3 = new JScrollPane();
/* 382 */     this.total = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 384 */         return false;
/*     */       }
/*     */     };
/* 387 */     this.jScrollPane4 = new JScrollPane();
/* 388 */     this.jTable1 = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 390 */         return false;
/*     */       }
/*     */     };
/* 393 */     this.jScrollPane5 = new JScrollPane();
/* 394 */     this.total1 = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 396 */         return false;
/*     */       }
/*     */     };
/* 399 */     this.jScrollPane6 = new JScrollPane();
/* 400 */     this.tablamar = new JTable();
/* 401 */     this.jScrollPane7 = new JScrollPane();
/* 402 */     this.total2 = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 404 */         return false;
/*     */       }
/*     */     };
/* 407 */     this.jLabel1 = new JLabel();
/* 408 */     this.jMenuBar1 = new JMenuBar();
/* 409 */     this.jMenu1 = new JMenu();
/* 410 */     this.jMenu2 = new JMenu();
/* 411 */     this.jMenuItem2 = new JMenuItem();
/* 412 */     this.jMenuItem3 = new JMenuItem();
/* 413 */     this.jMenu3 = new JMenu();
/* 414 */     this.jMenuItem1 = new JMenuItem();
/* 415 */     this.jMenuItem4 = new JMenuItem();
/* 416 */     this.jMenuItem5 = new JMenuItem();
/*     */ 
/* 418 */     setDefaultCloseOperation(2);
/* 419 */     setTitle("Administrador");
/* 420 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 422 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null } }, new String[] { "Curp", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Colonia", "Numero", "Municipio", "Email", "Fecha Nacimiento", "Nick", "Contraseña", "Fecha de registro" })
/*     */     {
/*     */       boolean[] canEdit;
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */       {
/* 438 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 441 */     this.tablasm.setToolTipText("Gastos por producto");
/* 442 */     this.tablasm.setName("Productos");
/* 443 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 445 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 1260, 290));
/*     */ 
/* 447 */     this.total.setModel(new DefaultTableModel(new Object[][] { { null } }, new String[] { "Inversion en Almacen" }));
/*     */ 
/* 455 */     this.jScrollPane3.setViewportView(this.total);
/*     */ 
/* 457 */     getContentPane().add(this.jScrollPane3, new AbsoluteConstraints(940, 290, 320, 50));
/*     */ 
/* 459 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*     */ 
/* 470 */     this.jScrollPane4.setViewportView(this.jTable1);
/*     */ 
/* 472 */     getContentPane().add(this.jScrollPane4, new AbsoluteConstraints(0, 290, 650, 210));
/*     */ 
/* 474 */     this.total1.setModel(new DefaultTableModel(new Object[][] { { null } }, new String[] { "Departamentos" }));
/*     */ 
/* 482 */     this.jScrollPane5.setViewportView(this.total1);
/*     */ 
/* 484 */     getContentPane().add(this.jScrollPane5, new AbsoluteConstraints(650, 290, 120, 50));
/*     */ 
/* 486 */     this.tablamar.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*     */ 
/* 497 */     this.jScrollPane6.setViewportView(this.tablamar);
/*     */ 
/* 499 */     getContentPane().add(this.jScrollPane6, new AbsoluteConstraints(0, 500, 610, 220));
/*     */ 
/* 501 */     this.total2.setModel(new DefaultTableModel(new Object[][] { { null } }, new String[] { "Marcas" }));
/*     */ 
/* 509 */     this.jScrollPane7.setViewportView(this.total2);
/*     */ 
/* 511 */     getContentPane().add(this.jScrollPane7, new AbsoluteConstraints(610, 500, 120, 50));
/*     */ 
/* 513 */     this.jLabel1.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/fondoRV.png")));
/* 514 */     this.jLabel1.setText("jLabel1");
/* 515 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(604, 284, 660, 440));
/*     */ 
/* 517 */     this.jMenu1.setText("Menu");
/*     */ 
/* 519 */     this.jMenu2.setText("Editar");
/*     */ 
/* 521 */     this.jMenuItem2.setText("Producto");
/* 522 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 524 */         DetalleProducto.this.jMenuItem2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 527 */     this.jMenu2.add(this.jMenuItem2);
/*     */ 
/* 529 */     this.jMenuItem3.setText("Precios");
/* 530 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 532 */         DetalleProducto.this.jMenuItem3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 535 */     this.jMenu2.add(this.jMenuItem3);
/*     */ 
/* 537 */     this.jMenu1.add(this.jMenu2);
/*     */ 
/* 539 */     this.jMenu3.setText("Agregar");
/*     */ 
/* 541 */     this.jMenuItem1.setText("Producto");
/* 542 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 544 */         DetalleProducto.this.jMenuItem1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 547 */     this.jMenu3.add(this.jMenuItem1);
/*     */ 
/* 549 */     this.jMenuItem4.setText("Marca");
/* 550 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 552 */         DetalleProducto.this.jMenuItem4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 555 */     this.jMenu3.add(this.jMenuItem4);
/*     */ 
/* 557 */     this.jMenuItem5.setText("Departamento");
/* 558 */     this.jMenuItem5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 560 */         DetalleProducto.this.jMenuItem5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 563 */     this.jMenu3.add(this.jMenuItem5);
/*     */ 
/* 565 */     this.jMenu1.add(this.jMenu3);
/*     */ 
/* 567 */     this.jMenuBar1.add(this.jMenu1);
/*     */ 
/* 569 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 571 */     pack();
/*     */   }
/*     */ 
/*     */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 575 */     new ModificarArticulo().iniciaarMod();
/*     */   }
/*     */ 
/*     */   private void jMenuItem3ActionPerformed(ActionEvent evt) {
/* 579 */     new MostrarProdDep().mostrar();
/*     */   }
/*     */ 
/*     */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 583 */     //new AgregarArticulo().iiciarAgregarProd();
                aart=AgregarArticulo.getInstancia();
/*     */   }
/*     */ 
/*     */   private void jMenuItem4ActionPerformed(ActionEvent evt) {
/* 587 */     aart=AgregarArticulo.getInstancia();
/*     */   }
/*     */ 
/*     */   private void jMenuItem5ActionPerformed(ActionEvent evt) {
/* 591 */     aart=AgregarArticulo.getInstancia();
/*     */   }
/*     */ 
/*     */   public void iniciar()
/*     */   {
/* 598 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 602 */         new DetalleProducto().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.DetalleProducto
 * JD-Core Version:    0.5.3
 */