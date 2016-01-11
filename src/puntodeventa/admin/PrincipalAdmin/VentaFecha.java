/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
          
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class VentaFecha extends JFrame
/*     */ {
/*  30 */   String consulta = null;
/*  31 */   String fecha = null;
/*  32 */   String finalcons = null;
/*  33 */   String finalcons2 = null;
/*  34 */   String finalcons3 = null;
/*  35 */   String finalcons4 = null;
/*  36 */   String fechacons = null;
/*     */   int grafi;
/*     */   private ButtonGroup buttonGroup1;
/*     */   private ButtonGroup buttonGroup2;
/*     */   private ButtonGroup buttonGroup3;
/*     */   private ButtonGroup buttonGroup4;
/*     */   private ButtonGroup buttonGroup5;
/*     */   private JDateChooser fechafinal;
/*     */   private JDateChooser fechaini;
/*     */   private JRadioButton gb;
/*     */   private JRadioButton gl;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JRadioButton jRadioButton1;
/*     */   private JRadioButton jRadioButton2;
/*     */   private JRadioButton jRadioButton3;
/*     */   private JRadioButton jRadioButton4;
/*     */   private JRadioButton jRadioButton5;
/*     */   private JRadioButton jRadioButton6;
/*     */   private JRadioButton jRadioButton7;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JSeparator jSeparator1;
/*     */   private JSeparator jSeparator2;
/*     */   private JTable tablasm;
/*     */ 
/*     */   public VentaFecha()
/*     */   {
/*  40 */     initComponents();
/*  41 */     setSize(990, 520);
/*  42 */     setResizable(false);
/*  43 */     setLocationRelativeTo(null);
/*  44 */     getRootPane().setDefaultButton(this.jButton1);
/*  45 */     this.buttonGroup1.add(this.jRadioButton1);
/*  46 */     this.buttonGroup1.add(this.jRadioButton2);
/*  47 */     this.buttonGroup1.add(this.jRadioButton3);
/*  48 */     this.buttonGroup1.add(this.jRadioButton7);
/*  49 */     this.jRadioButton4.setSelected(true);
/*  50 */     this.jRadioButton1.setVisible(false);
/*  51 */     this.jRadioButton2.setVisible(false);
/*  52 */     this.jRadioButton3.setVisible(false);
/*  53 */     this.jRadioButton7.setVisible(false);
/*     */ 
/*  55 */     this.buttonGroup2.add(this.jRadioButton4);
/*  56 */     this.buttonGroup2.add(this.jRadioButton5);
/*  57 */     this.buttonGroup2.add(this.jRadioButton6);
/*     */ 
/*  60 */     this.buttonGroup3.add(this.gl);
/*  61 */     this.buttonGroup3.add(this.gb);
/*  62 */     this.gl.setVisible(false);
/*  63 */     this.gb.setVisible(false);
/*     */ 
/*  65 */     fechaprimcompra();
/*     */ 
/*  67 */     int año5 = this.fechafinal.getCalendar().get(1);
/*  68 */     int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/*  69 */     int dia5 = this.fechafinal.getCalendar().get(5);
/*  70 */     String dia6 = año5 + "-" + mes5 + "-" + dia5;
/*     */ 
/*  72 */     int año3 = this.fechaini.getCalendar().get(1);
/*  73 */     int mes3 = this.fechaini.getCalendar().get(2) + 1;
/*  74 */     int dia3 = this.fechaini.getCalendar().get(5);
/*  75 */     String dia4 = año3 + "-" + mes3 + "-" + dia3;
/*  76 */     conexioninicio ci = new conexioninicio();
/*  77 */     String consultasql = "SELECT  YEAR( fecha ) AS Año,  sum( cantidadprod ) AS 'Cantidad Vendida',  sum( cantidadprod * precioVenta) AS 'Total Vendido  $' FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras) AND DATE( fecha ) BETWEEN'" + dia4 + "' AND '" + dia6 + "'" + " GROUP BY YEAR( fecha) ORDER BY YEAR( fecha ) desc";
/*     */     try
/*     */     {
/*  80 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  82 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  84 */     Connection con = null;
/*     */     try
/*     */     {
/*  88 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  89 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/*  91 */       this.tablasm.setModel(modelo);
/*     */ 
/*  93 */       Statement stmt = con.createStatement();
/*     */ 
/*  95 */       ResultSet rs = stmt.executeQuery(consultasql);
/*  96 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  98 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 100 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 101 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 103 */       while (rs.next()) {
/* 104 */         Object[] fila = new Object[cantidadColumnas];
/* 105 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 107 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 109 */         modelo.addRow(fila);
/*     */       }
/* 111 */       rs.close();
/* 112 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 116 */       if (con == null)
/*     */         return;
/*     */       try {
/* 119 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 121 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 123 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 139 */     this.buttonGroup1 = new ButtonGroup();
/* 140 */     this.buttonGroup2 = new ButtonGroup();
/* 141 */     this.buttonGroup3 = new ButtonGroup();
/* 142 */     this.buttonGroup4 = new ButtonGroup();
/* 143 */     this.buttonGroup5 = new ButtonGroup();
/* 144 */     this.jPanel1 = new JPanel();
/* 145 */     this.jScrollPane1 = new JScrollPane();
/* 146 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 148 */         return false;
/*     */       }
/*     */     };
/* 151 */     this.fechaini = new JDateChooser();
/* 152 */     this.fechafinal = new JDateChooser();
/* 153 */     this.jLabel1 = new JLabel();
/* 154 */     this.jLabel2 = new JLabel();
/* 155 */     this.jRadioButton1 = new JRadioButton();
/* 156 */     this.jRadioButton2 = new JRadioButton();
/* 157 */     this.jRadioButton3 = new JRadioButton();
/* 158 */     this.jRadioButton4 = new JRadioButton();
/* 159 */     this.jRadioButton5 = new JRadioButton();
/* 160 */     this.jRadioButton6 = new JRadioButton();
/* 161 */     this.jRadioButton7 = new JRadioButton();
/* 162 */     this.jButton1 = new JButton();
/* 163 */     this.jSeparator1 = new JSeparator();
/* 164 */     this.jSeparator2 = new JSeparator();
/* 165 */     this.gb = new JRadioButton();
/* 166 */     this.gl = new JRadioButton();
/* 167 */     this.jButton2 = new JButton();
/*     */ 
/* 169 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 170 */     this.jPanel1.setLayout(jPanel1Layout);
/* 171 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */ 
/* 175 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */ 
/* 180 */     setDefaultCloseOperation(2);
/* 181 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 183 */     this.tablasm.setBackground(new Color(102, 102, 255));
/* 184 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*     */ 
/* 195 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 197 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 990, 330));
/*     */ 
/* 199 */     this.fechaini.setDateFormatString("yyyy-MM-dd");
/* 200 */     getContentPane().add(this.fechaini, new AbsoluteConstraints(340, 380, 140, -1));
/*     */ 
/* 202 */     this.fechafinal.setDateFormatString("yyyy-MM-dd");
/* 203 */     getContentPane().add(this.fechafinal, new AbsoluteConstraints(530, 380, 160, 20));
/*     */ 
/* 205 */     this.jLabel1.setText("Fecha Inicial");
/* 206 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(410, 360, -1, -1));
/*     */ 
/* 208 */     this.jLabel2.setForeground(new Color(102, 204, 0));
/* 209 */     this.jLabel2.setText("Fecha Final");
/* 210 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(550, 360, -1, -1));
/*     */ 
/* 212 */     this.jRadioButton1.setBackground(new Color(204, 204, 255));
/* 213 */     this.jRadioButton1.setText("Por Departamento");
/* 214 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 216 */         VentaFecha.this.jRadioButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 219 */     getContentPane().add(this.jRadioButton1, new AbsoluteConstraints(380, 470, -1, -1));
/*     */ 
/* 221 */     this.jRadioButton2.setBackground(new Color(204, 204, 255));
/* 222 */     this.jRadioButton2.setText("Por Marca");
/* 223 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 225 */         VentaFecha.this.jRadioButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 228 */     getContentPane().add(this.jRadioButton2, new AbsoluteConstraints(520, 470, -1, -1));
/*     */ 
/* 230 */     this.jRadioButton3.setBackground(new Color(204, 204, 255));
/* 231 */     this.jRadioButton3.setText("Por Producto");
/* 232 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 234 */         VentaFecha.this.jRadioButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 237 */     getContentPane().add(this.jRadioButton3, new AbsoluteConstraints(620, 470, -1, -1));
/*     */ 
/* 239 */     this.jRadioButton4.setBackground(new Color(51, 102, 255));
/* 240 */     this.jRadioButton4.setText("Por año");
/* 241 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 243 */         VentaFecha.this.jRadioButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 246 */     this.jRadioButton4.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 248 */         VentaFecha.this.jRadioButton4FocusGained(evt);
/*     */       }
/*     */     });
/* 251 */     getContentPane().add(this.jRadioButton4, new AbsoluteConstraints(390, 420, -1, -1));
/*     */ 
/* 253 */     this.jRadioButton5.setBackground(new Color(51, 102, 255));
/* 254 */     this.jRadioButton5.setText("Por mes");
/* 255 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 257 */         VentaFecha.this.jRadioButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 260 */     getContentPane().add(this.jRadioButton5, new AbsoluteConstraints(470, 420, -1, -1));
/*     */ 
/* 262 */     this.jRadioButton6.setBackground(new Color(51, 102, 255));
/* 263 */     this.jRadioButton6.setText("Por dia");
/* 264 */     this.jRadioButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 266 */         VentaFecha.this.jRadioButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 269 */     getContentPane().add(this.jRadioButton6, new AbsoluteConstraints(550, 420, -1, -1));
/*     */ 
/* 271 */     this.jRadioButton7.setBackground(new Color(204, 204, 255));
/* 272 */     this.jRadioButton7.setText("Total");
/* 273 */     this.jRadioButton7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 275 */         VentaFecha.this.jRadioButton7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 278 */     this.jRadioButton7.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 280 */         VentaFecha.this.jRadioButton7FocusGained(evt);
/*     */       }
/*     */     });
/* 283 */     getContentPane().add(this.jRadioButton7, new AbsoluteConstraints(310, 470, -1, -1));
/*     */ 
/* 285 */     this.jButton1.setText("Mostrar");
/* 286 */     this.jButton1.setBorder(null);
/* 287 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 289 */         VentaFecha.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 292 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(720, 440, -1, -1));
/* 293 */     getContentPane().add(this.jSeparator1, new AbsoluteConstraints(330, 450, 380, -1));
/* 294 */     getContentPane().add(this.jSeparator2, new AbsoluteConstraints(340, 410, 350, 10));
/*     */ 
/* 296 */     this.gb.setText("Grafica de barras");
/* 297 */     this.gb.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 299 */         VentaFecha.this.gbActionPerformed(evt);
/*     */       }
/*     */     });
/* 302 */     getContentPane().add(this.gb, new AbsoluteConstraints(20, 360, -1, -1));
/*     */ 
/* 304 */     this.gl.setText("Grafica lineal");
/* 305 */     this.gl.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 307 */         VentaFecha.this.glActionPerformed(evt);
/*     */       }
/*     */     });
/* 310 */     getContentPane().add(this.gl, new AbsoluteConstraints(20, 400, -1, -1));
/*     */ 
/* 312 */     this.jButton2.setText("Generar");
/* 313 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 315 */         VentaFecha.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 318 */     getContentPane().add(this.jButton2, new AbsoluteConstraints(20, 450, -1, -1));
/*     */ 
/* 320 */     pack();
/*     */   }
/*     */ 
/*     */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 324 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton3.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton3.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton3.isSelected()))) {
/* 325 */       this.gl.setVisible(false); this.gb.setVisible(false);
/*     */     }
/* 327 */     this.consulta = "SELECT " + this.fecha + ", nombredep AS Departamento, nombremar AS Marca, codigobarras AS Codigo, nombreart Articulo, sum( cantidadprod ) AS 'Cantidad Vendida', descripcion AS Descripcion, medida AS Medida, sum( cantidadprod * precioVenta) AS 'Total vendido $' FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras)" + this.fechacons + " GROUP BY codigobarras," + this.finalcons;
/*     */   }
/*     */ 
/*     */   private void jRadioButton6ActionPerformed(ActionEvent evt)
/*     */   {
/* 333 */     this.jRadioButton1.setVisible(true);
/* 334 */     this.jRadioButton2.setVisible(true);
/* 335 */     this.jRadioButton3.setVisible(true);
/* 336 */     this.jRadioButton7.setVisible(true);
/* 337 */     this.fecha = " fecha as Dia ";
/* 338 */     this.finalcons = "  fecha ORDER BY fecha DESC , departamento, marca, articulo";
/* 339 */     this.finalcons2 = " fecha ORDER BY fecha DESC , departamento, marca";
/* 340 */     this.finalcons3 = " fecha ORDER BY fecha DESC , departamento";
/* 341 */     this.finalcons4 = " fecha  ORDER BY  fecha DESC";
/*     */   }
/*     */ 
/*     */   private void jRadioButton5ActionPerformed(ActionEvent evt)
/*     */   {
/* 346 */     this.jRadioButton1.setVisible(true);
/* 347 */     this.jRadioButton2.setVisible(true);
/* 348 */     this.jRadioButton3.setVisible(true);
/* 349 */     this.jRadioButton7.setVisible(true);
/* 350 */     this.fecha = " YEAR( fecha ) AS Año, MONTHNAME( fecha ) AS Mes";
/* 351 */     this.finalcons = " MONTHNAME( fecha ) ORDER BY YEAR( fecha ) desc, MONTHNAME( fecha) desc, departamento, marca, articulo";
/* 352 */     this.finalcons2 = " MONTHNAME( fecha ) ORDER BY YEAR( fecha ) desc, MONTHNAME( fecha ) desc, departamento  , marca ";
/* 353 */     this.finalcons3 = "MONTHNAME( fecha ) ORDER BY YEAR( fecha )desc , MONTHNAME( fecha ) desc , departamento ";
/* 354 */     this.finalcons4 = "MONTHNAME( fecha ) ORDER BY YEAR (fecha) DESC, MONTHNAME( fecha ) DESC";
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 358 */     this.jRadioButton1.setVisible(false);
/* 359 */     this.jRadioButton2.setVisible(false);
/* 360 */     this.jRadioButton3.setVisible(false);
/* 361 */     this.jRadioButton7.setVisible(false);
/* 362 */     int año3 = this.fechaini.getCalendar().get(1);
/* 363 */     int mes3 = this.fechaini.getCalendar().get(2) + 1;
/* 364 */     int dia3 = this.fechaini.getCalendar().get(5);
/* 365 */     if (validarfecha(año3, mes3, dia3)) {
/* 366 */       conexioninicio ci = new conexioninicio();
/* 367 */       String consultasql = this.consulta;
/*     */       try {
/* 369 */         Class.forName("org.gjt.mm.mysql.Driver");
/*     */       } catch (ClassNotFoundException ex) {
/* 371 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 373 */       Connection con = null;
/*     */       try
/*     */       {
/* 377 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 378 */         DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 380 */         this.tablasm.setModel(modelo);
/*     */ 
/* 382 */         Statement stmt = con.createStatement();
/*     */ 
/* 384 */         ResultSet rs = stmt.executeQuery(consultasql);
/* 385 */         ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 387 */         int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 389 */         for (int i = 1; i <= cantidadColumnas; ++i) {
/* 390 */           modelo.addColumn(rsMd.getColumnLabel(i));
/*     */         }
/* 392 */         while (rs.next()) {
/* 393 */           Object[] fila = new Object[cantidadColumnas];
/* 394 */           for (int i = 0; i < cantidadColumnas; ++i)
/*     */           {
/* 396 */             fila[i] = rs.getObject(i + 1);
/*     */           }
/* 398 */           modelo.addRow(fila);
/*     */         }
/* 400 */         rs.close();
/* 401 */         con.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 405 */         if (con != null)
/*     */         {
/*     */           try {
/* 408 */             con.rollback();
/*     */           } catch (SQLException ex) {
/* 410 */             Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/* 412 */           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */         }
/*     */       }
/*     */     } else {
/* 416 */       JOptionPane.showMessageDialog(null, "verifique las fechas", "error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jRadioButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 422 */     this.jRadioButton1.setVisible(true);
/* 423 */     this.jRadioButton2.setVisible(true);
/* 424 */     this.jRadioButton3.setVisible(true);
/* 425 */     this.jRadioButton7.setVisible(true);
/* 426 */     this.fecha = " YEAR( fecha ) AS Año";
/* 427 */     this.finalcons = " YEAR( fecha ) ORDER BY YEAR( fecha ) desc, departamento, marca, articulo";
/* 428 */     this.finalcons2 = " YEAR( fecha ) ORDER BY YEAR( fecha ) desc, departamento, marca";
/* 429 */     this.finalcons3 = "YEAR( fecha ) ORDER BY YEAR( fecha ) desc , departamento";
/* 430 */     this.finalcons4 = "YEAR( fecha ) ORDER BY YEAR( fecha ) desc";
/*     */   }
/*     */ 
/*     */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 434 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton2.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton2.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton2.isSelected()))) {
/* 435 */       this.gl.setVisible(false); this.gb.setVisible(false); }
/* 436 */     cadenacons();
/* 437 */     this.consulta = "SELECT " + this.fecha + ", nombredep AS Departamento, nombremar AS Marca,  sum( cantidadprod ) AS 'Cantidad Vendida',  sum( cantidadprod * precioVenta) AS 'Total vendido $' FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras) " + this.fechacons + "  GROUP BY idmarca," + this.finalcons2;
/*     */   }
/*     */ 
/*     */   private void jRadioButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 443 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton1.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton1.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton1.isSelected()))) {
/* 444 */       this.gl.setVisible(false); this.gb.setVisible(false); }
/* 445 */     cadenacons();
/* 446 */     this.consulta = "SELECT " + this.fecha + ", nombredep AS Departamento,  sum( cantidadprod ) AS 'Cantidad Vendida',  sum( cantidadprod * precioVenta ) AS 'Total vendido$'  FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras)" + this.fechacons + "  GROUP BY departamento," + this.finalcons3;
/*     */   }
/*     */ 
/*     */   private void jRadioButton7ActionPerformed(ActionEvent evt)
/*     */   {
/* 451 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton7.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton7.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton7.isSelected()))) {
/* 452 */       this.gl.setVisible(true); this.gb.setVisible(true); }
/* 453 */     cadenacons();
/* 454 */     this.consulta = "SELECT " + this.fecha + ",   sum( cantidadprod ) AS 'Cantidad Vendida',  sum( cantidadprod * precioVenta ) AS 'Total Vendido $' FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras)" + this.fechacons + "  GROUP BY " + this.finalcons4;
/*     */   }
/*     */ 
/*     */   private void jRadioButton7FocusGained(FocusEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jRadioButton4FocusGained(FocusEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 467 */     String cos = null; String nomv = null; String horiz = null; String ver = null; String nombgraf = null;
/* 468 */     if ((this.jRadioButton6.isSelected()) && (this.jRadioButton7.isSelected()))
/*     */     {
/* 470 */       cos = "SELECT fecha as Dia, sum( cantidadprod * precioVenta ) AS 'Total $' FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras) GROUP BY fecha  ORDER BY  fecha ";
/* 471 */       nomv = "Ventas";
/* 472 */       horiz = "Dia";
/* 473 */       ver = "Total";
/* 474 */       nombgraf = "Ventas al dia";
/*     */     }
/* 476 */     else if ((this.jRadioButton5.isSelected()) && (this.jRadioButton7.isSelected()))
/*     */     {
/* 478 */       cos = "SELECT DATE_FORMAT(fecha, '%M %Y'), sum( cantidadprod * precioVenta ) AS 'Total $' FROM venta NATURAL JOIN ticketventa NATURAL JOIN inventario NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM ticketventa natural join inventario GROUP BY codigobarras) GROUP BY DATE_FORMAT(fecha, '%M %Y')  ORDER BY  DATE_FORMAT(fecha, '%M %Y') DESC";
/* 479 */       nomv = "Ventas";
/* 480 */       horiz = "Mes";
/* 481 */       ver = "Total";
/* 482 */       nombgraf = "Ventasal Mes";
/*     */     }
/*     */     else {
/* 485 */       cos = "SELECT YEAR( fecha ) AS Año , SUM( cantidadprod * precioVenta ) AS  'Total $'\nFROM venta\nNATURAL JOIN ticketventa\nNATURAL JOIN inventario\nNATURAL JOIN articulo\nNATURAL JOIN departamento\nNATURAL JOIN marca\nWHERE codigobarras\nIN (\n\nSELECT codigobarras\nFROM ticketventa\nNATURAL JOIN inventario\nGROUP BY codigobarras\n)\nGROUP BY YEAR( fecha ) ORDER BY YEAR( fecha ) ";
/*     */ 
/* 501 */       nomv = "Ventas";
/* 502 */       horiz = "Año";
/* 503 */       ver = "Total";
/* 504 */       nombgraf = "Ventas al Año";
/*     */     }
/*     */ 
/* 509 */     GeneraGrafica gg = new GeneraGrafica();
/* 510 */     gg.recibirparametros(cos, nomv, horiz, ver, this.grafi, nombgraf);
/*     */   }
/*     */ 
/*     */   private void gbActionPerformed(ActionEvent evt) {
/* 514 */     this.grafi = 1;
/*     */   }
/*     */ 
/*     */   private void glActionPerformed(ActionEvent evt) {
/* 518 */     this.grafi = 0;
/*     */   }
/*     */ 
/*     */   public void cadenacons() {
/* 522 */     int año5 = this.fechafinal.getCalendar().get(1);
/* 523 */     int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/* 524 */     int dia5 = this.fechafinal.getCalendar().get(5);
/* 525 */     String dia6 = año5 + "-" + mes5 + "-" + dia5;
/*     */ 
/* 527 */     int año3 = this.fechaini.getCalendar().get(1);
/* 528 */     int mes3 = this.fechaini.getCalendar().get(2) + 1;
/* 529 */     int dia3 = this.fechaini.getCalendar().get(5);
/* 530 */     String dia4 = año3 + "-" + mes3 + "-" + dia3;
/* 531 */     this.fechacons = "AND DATE( fecha ) BETWEEN'" + dia4 + "' AND '" + dia6 + "'";
/*     */   }
/*     */ 
/*     */   public final void fechaprimcompra()
/*     */   {
/* 536 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 538 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 540 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 542 */     Connection con = null;
/*     */     try
/*     */     {
/* 546 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 547 */       Statement stmt = con.createStatement();
/*     */ 
/* 549 */       ResultSet rs = stmt.executeQuery("SELECT min(fecha) as fecha  FROM venta  ");
/* 550 */       String dia = null;
/* 551 */       while (rs.next()) {
/* 552 */         dia = rs.getString("fecha");
/* 553 */         System.out.println(dia);
/*     */       }
/*     */       try
/*     */       {
/* 557 */         Date fechaactual = new Date();
/* 558 */         Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dia);
/*     */ 
/* 560 */         this.fechaini.setDate(date);
/* 561 */         this.fechaini.setMinSelectableDate(date);
/* 562 */         this.fechaini.setMaxSelectableDate(fechaactual);
/* 563 */         this.fechafinal.setDate(fechaactual);
/* 564 */         this.fechafinal.setMinSelectableDate(this.fechaini.getDate());
/* 565 */         this.fechafinal.setMaxSelectableDate(fechaactual);
/* 566 */         int año5 = this.fechafinal.getCalendar().get(1);
/* 567 */         int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/* 568 */         int dia5 = this.fechafinal.getCalendar().get(5);
/* 569 */         String dia6 = año5 + "-" + mes5 + "-" + dia5;
/*     */ 
/* 571 */         int año3 = this.fechaini.getCalendar().get(1);
/* 572 */         int mes3 = this.fechaini.getCalendar().get(2) + 1;
/* 573 */         int dia3 = this.fechaini.getCalendar().get(5);
/* 574 */         String dia4 = año3 + "-" + mes3 + "-" + dia3;
/* 575 */         this.fechacons = "AND DATE( fecha ) BETWEEN'" + dia4 + "' AND '" + dia6 + "'";
/*     */       }
/*     */       catch (ParseException ex) {
/* 578 */         Logger.getLogger(VentaFecha.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 584 */       JOptionPane.showMessageDialog(null, "Consulte con el admnistrador" + e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean validarfecha(int añoi, int mesi, int diai)
/*     */   {
/* 591 */     boolean t = false;
/* 592 */     int año5 = this.fechafinal.getCalendar().get(1);
/* 593 */     int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/* 594 */     int dia5 = this.fechafinal.getCalendar().get(5);
/*     */ 
/* 596 */     if (añoi < año5)
/*     */     {
/* 598 */       t = true;
/*     */     }
/* 600 */     else if ((añoi == año5) && (mesi < mes5))
/*     */     {
/* 602 */       t = true;
/*     */     }
/* 605 */     else if ((añoi == año5) && (mesi == mes5) && (diai <= dia5))
/*     */     {
/* 608 */       t = true;
/*     */     }
/*     */     else
/*     */     {
/* 612 */       t = false;
/*     */     }
/*     */ 
/* 615 */     return t;
/*     */   }
/*     */ 
/*     */   public void mostrar()
/*     */   {
/* 627 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 629 */         new VentaFecha().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.VentaFecha
 * JD-Core Version:    0.5.3
 */