/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
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
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class MostrarProdDep extends JFrame
/*     */ {
/*     */   private Dimension dim;
/*     */   private JTextField cant;
/*     */   private JTextField cb;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JMenu jMenu1;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JScrollPane jScrollPane3;
/*     */   private JTable jTable1;
/*     */   private JTextField pcom;
/*     */   private JTextField pven;
/*     */   private JTable tablasm;
/*     */ 
/*     */   public MostrarProdDep()
/*     */   {
/*  30 */     initComponents();
/*  31 */     setSize(910, 510);
/*  32 */     setResizable(false);
/*  33 */     setLocationRelativeTo(null);
/*     */ 
/*  35 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/*  37 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  39 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  41 */     Connection con = null;
/*     */     try
/*     */     {
/*  45 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  46 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/*  48 */       this.tablasm.setModel(modelo);
/*     */ 
/*  50 */       Statement stmt = con.createStatement();
/*     */ 
/*  52 */       ResultSet rs = stmt.executeQuery(" SELECT articulo.codigobarras AS Codigo, nombreart AS Articulo, preciocom AS 'Precio compra', precioVenta AS 'Precio venta', cantidad AS 'Cantidad en Almacen', (precioVenta - preciocom) AS 'Ganancia unitaria', ((precioVenta - preciocom) * cantidad) AS 'Utilidad en almacen' FROM compra NATURAL JOIN articulo NATURAL JOIN inventario NATURAL JOIN almacen WHERE idinventario IN (SELECT MAX( idinventario ) FROM inventario GROUP BY codigobarras) AND idcompra IN (SELECT MAX( idcompra ) FROM compra GROUP BY codigobarras) order by nombreart");
/*  53 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  55 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  57 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/*  58 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/*  60 */       while (rs.next()) {
/*  61 */         Object[] fila = new Object[cantidadColumnas];
/*  62 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/*  64 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/*  66 */         modelo.addRow(fila);
/*     */       }
/*  68 */       rs.close();
/*  69 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  73 */       if (con == null)
/*     */         return;
/*     */       try {
/*  76 */         con.rollback();
/*     */       } catch (SQLException ex) {
/*  78 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*  80 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  98 */     this.jScrollPane2 = new JScrollPane();
/*  99 */     this.jScrollPane1 = new JScrollPane();
/* 100 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 102 */         return false;
/*     */       }
/*     */     };
/* 105 */     this.jButton1 = new JButton();
/* 106 */     this.cb = new JTextField();
/* 107 */     this.jLabel1 = new JLabel();
/* 108 */     this.pcom = new JTextField();
/* 109 */     this.jLabel2 = new JLabel();
/* 110 */     this.pven = new JTextField();
/* 111 */     this.jLabel3 = new JLabel();
/* 112 */     this.cant = new JTextField();
/* 113 */     this.jButton2 = new JButton();
/* 114 */     this.jButton3 = new JButton();
/* 115 */     this.jScrollPane3 = new JScrollPane();
/* 116 */     this.jTable1 = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 118 */         return false;
/*     */       }
/*     */     };
/* 121 */     this.jButton4 = new JButton();
/* 122 */     this.jLabel4 = new JLabel();
/* 123 */     this.jLabel5 = new JLabel();
/* 124 */     this.jMenuBar1 = new JMenuBar();
/* 125 */     this.jMenu1 = new JMenu();
/*     */ 
/* 127 */     setDefaultCloseOperation(2);
/* 128 */     setTitle("Administrador");
/* 129 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 131 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Codigo ", "Articulo", "Precio Compra ", "Precio Venta" })
/*     */     {
/*     */       boolean[] canEdit;
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */       {
/* 147 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 150 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 152 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 760, 340));
/*     */ 
/* 154 */     this.jButton1.setText("Mostrar");
/* 155 */     this.jButton1.setBorder(null);
/* 156 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 158 */         MostrarProdDep.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 161 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(120, 370, 90, 40));
/* 162 */     getContentPane().add(this.cb, new AbsoluteConstraints(110, 420, 110, -1));
/*     */ 
/* 164 */     this.jLabel1.setText("Precio compra");
/* 165 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(260, 390, -1, -1));
/* 166 */     getContentPane().add(this.pcom, new AbsoluteConstraints(250, 420, 80, -1));
/*     */ 
/* 168 */     this.jLabel2.setText("Precio venta");
/* 169 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(790, 160, -1, -1));
/* 170 */     getContentPane().add(this.pven, new AbsoluteConstraints(790, 180, 70, -1));
/*     */ 
/* 172 */     this.jLabel3.setText("Cantidad");
/* 173 */     getContentPane().add(this.jLabel3, new AbsoluteConstraints(370, 390, -1, -1));
/* 174 */     getContentPane().add(this.cant, new AbsoluteConstraints(360, 420, 70, -1));
/*     */ 
/* 176 */     this.jButton2.setText("Agregar compra ");
/* 177 */     this.jButton2.setBorder(null);
/* 178 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 180 */         MostrarProdDep.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 183 */     getContentPane().add(this.jButton2, new AbsoluteConstraints(460, 420, 100, -1));
/*     */ 
/* 185 */     this.jButton3.setText("Actualizar tabla");
/* 186 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 188 */         MostrarProdDep.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 191 */     getContentPane().add(this.jButton3, new AbsoluteConstraints(770, 110, -1, -1));
/*     */ 
/* 193 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null } }, new String[] { "Total Productos", "Ganancia Parcial", "Ganancia Total" }));
/*     */ 
/* 201 */     this.jTable1.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 203 */         MostrarProdDep.this.jTable1FocusGained(evt);
/*     */       }
/*     */     });
/* 206 */     this.jScrollPane3.setViewportView(this.jTable1);
/*     */ 
/* 208 */     getContentPane().add(this.jScrollPane3, new AbsoluteConstraints(420, 340, 340, 50));
/*     */ 
/* 210 */     this.jButton4.setText("Cambiar precio Venta");
/* 211 */     this.jButton4.setBorder(null);
/* 212 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 214 */         MostrarProdDep.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 217 */     getContentPane().add(this.jButton4, new AbsoluteConstraints(770, 210, -1, -1));
/*     */ 
/* 219 */     this.jLabel4.setText("jLabel4");
/* 220 */     getContentPane().add(this.jLabel4, new AbsoluteConstraints(0, -30, 120, 30));
/*     */ 
/* 222 */     this.jLabel5.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/fondoRV.png")));
/* 223 */     this.jLabel5.setText("jLabel5");
/* 224 */     getContentPane().add(this.jLabel5, new AbsoluteConstraints(0, 0, 900, 470));
/*     */ 
/* 226 */     this.jMenu1.setText("Archivo");
/* 227 */     this.jMenuBar1.add(this.jMenu1);
/*     */ 
/* 229 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 231 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 235 */     conexioninicio ci = new conexioninicio();
/* 236 */     Connection con = null;
/*     */     try
/*     */     {
/* 239 */       Class.forName("org.gjt.mm.mysql.Driver");
/* 240 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 241 */       Statement stmt = con.createStatement();
/* 242 */       String cadenasql = "SELECT   preciocom , precioVenta , cantidad  FROM inventario natural join almacen natural join compra WHERE idinventario in (SELECT MAX( idinventario ) FROM  `inventario` group by codigobarras) and idcompra in (SELECT MAX( idcompra )  FROM  compra group by codigobarras) and  codigobarras='" + this.cb.getText() + "' ";
/* 243 */       ResultSet rs = stmt.executeQuery(cadenasql);
/*     */ 
/* 245 */       while (rs.next()) {
/* 246 */         this.pcom.setText(rs.getString("preciocom"));
/* 247 */         this.pven.setText(rs.getString("precioVenta"));
/* 248 */         this.cant.setText(rs.getString("cantidad"));
/*     */       }
/*     */ 
/* 251 */       if (!(rs.first())) {
/* 252 */         JOptionPane.showMessageDialog(this, "El codigo no es valido");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 257 */       System.out.println("for?" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 266 */       if ((this.cb.getText().length() > 0) && (this.pcom.getText().length() > 0) && (this.pven.getText().length() > 0) && (this.cant.getText().length() > 0))
/*     */       {
/* 269 */         if (verificarCo(this.cb.getText()))
/*     */         {
/* 271 */           new Almacen().actualizaAlma(this.cb.getText().toUpperCase(), Integer.parseInt(this.cant.getText()));
/*     */ 
/* 273 */           new Almacen().recibirCodigoCompra(this.cb.getText().toUpperCase(), Float.parseFloat(this.pcom.getText()), Integer.parseInt(this.cant.getText()));
/* 274 */           JOptionPane.showMessageDialog(null, "Actualizacion exitosa!", "", 0);
/* 275 */           this.cb.setText("");
/* 276 */           this.pven.setText("");
/* 277 */           this.pcom.setText("");
/* 278 */           this.cant.setText("");
/*     */         }
/*     */         else
/*     */         {
/* 284 */           JOptionPane.showMessageDialog(null, "El codigo no existe");
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 291 */         JOptionPane.showMessageDialog(null, "No deje campos vacios.\n");
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 299 */     MostrarProdDep mpd = new MostrarProdDep();
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 305 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 307 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 309 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 311 */     Connection con = null;
/*     */     try
/*     */     {
/* 315 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 316 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 318 */       this.tablasm.setModel(modelo);
/*     */ 
/* 320 */       Statement stmt = con.createStatement();
/*     */ 
/* 322 */       ResultSet rs = stmt.executeQuery(" SELECT articulo.codigobarras AS Codigo, nombreart AS Articulo, preciocom AS 'Precio compra', precioVenta AS 'Precio venta', cantidad AS 'En almamcen', (precioVenta - preciocom) AS 'Ganancia unitaria', ((precioVenta - preciocom) * cantidad) AS 'Ganancia total' FROM compra NATURAL JOIN articulo NATURAL JOIN inventario NATURAL JOIN almacen WHERE idinventario IN (SELECT MAX( idinventario ) FROM inventario GROUP BY codigobarras) AND idcompra IN (SELECT MAX( idcompra ) FROM compra GROUP BY codigobarras) order by nombreart");
/* 323 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 325 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 327 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 328 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 330 */       while (rs.next()) {
/* 331 */         Object[] fila = new Object[cantidadColumnas];
/* 332 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 334 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 336 */         modelo.addRow(fila);
/*     */       }
/* 338 */       rs.close();
/* 339 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 343 */       if (con == null)
/*     */         return;
/*     */       try {
/* 346 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 348 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 350 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jTable1FocusGained(FocusEvent evt)
/*     */   {
/* 358 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 360 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 362 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 364 */     Connection con = null;
/*     */     try
/*     */     {
/* 368 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 369 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 371 */       this.jTable1.setModel(modelo);
/*     */ 
/* 373 */       Statement stmt = con.createStatement();
/*     */ 
/* 375 */       ResultSet rs = stmt.executeQuery(" SELECT  sum(cantidad) as 'Total Productos', sum(((precioVenta - preciocom)) * cantidad) AS 'Utilidad en almacen' FROM compra NATURAL JOIN articulo NATURAL JOIN inventario NATURAL JOIN almacen WHERE idinventario IN (SELECT MAX( idinventario ) FROM inventario GROUP BY codigobarras) AND idcompra IN (SELECT MAX( idcompra ) FROM compra GROUP BY codigobarras) order by nombreart ");
/* 376 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 378 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 380 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 381 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 383 */       while (rs.next()) {
/* 384 */         Object[] fila = new Object[cantidadColumnas];
/* 385 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 387 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 389 */         modelo.addRow(fila);
/*     */       }
/* 391 */       rs.close();
/* 392 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 396 */       if (con == null)
/*     */         return;
/*     */       try {
/* 399 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 401 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 403 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 412 */     if ((this.cb.getText().length() > 0) && (this.pven.getText().length() > 0))
/*     */     {
/* 414 */       new Almacen().recibirCodigoInv(this.cb.getText().toUpperCase(), Float.parseFloat(this.pven.getText()));
/*     */     }
/*     */     else JOptionPane.showMessageDialog(null, "Escriba codigo del producto y su precio nuevo ", "Error", 0);
/*     */   }
/*     */ 
/*     */   boolean verificarCo(String elUsr) throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 423 */       conexioninicio ci = new conexioninicio();
/* 424 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 427 */       Statement instruccionSQL = con.createStatement();
/* 428 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM articulo WHERE codigobarras='" + elUsr + "'");
/*     */ 
/* 431 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 437 */     return false;
/*     */   }
/*     */ 
/*     */   public void mostrar()
/*     */   {
/* 445 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 449 */         new MostrarProdDep().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.MostrarProdDep
 * JD-Core Version:    0.5.3
 */