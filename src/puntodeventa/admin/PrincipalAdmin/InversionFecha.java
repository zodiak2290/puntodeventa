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
/*     */ public class InversionFecha extends JFrame
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
/*     */   public InversionFecha()
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
/*  77 */     String consultasql = "SELECT  YEAR( fechacom ) AS Año,  sum( cantidadcomp ) AS 'Productos Comprados',  sum( cantidadcomp * preciocom ) AS 'Inversion Total $' FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras) AND DATE( fechacom ) BETWEEN'" + dia4 + "' AND '" + dia6 + "'" + " GROUP BY YEAR( fechacom ) ORDER BY YEAR( fechacom ) desc";
/*     */     try {
/*  79 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  81 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  83 */     Connection con = null;
/*     */     try
/*     */     {
/*  87 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*  88 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/*  90 */       this.tablasm.setModel(modelo);
/*     */ 
/*  92 */       Statement stmt = con.createStatement();
/*     */ 
/*  94 */       ResultSet rs = stmt.executeQuery(consultasql);
/*  95 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  97 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  99 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/* 100 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/* 102 */       while (rs.next()) {
/* 103 */         Object[] fila = new Object[cantidadColumnas];
/* 104 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/* 106 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/* 108 */         modelo.addRow(fila);
/*     */       }
/* 110 */       rs.close();
/* 111 */       con.close();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 115 */       if (con == null)
/*     */         return;
/*     */       try {
/* 118 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 120 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 122 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 138 */     this.buttonGroup1 = new ButtonGroup();
/* 139 */     this.buttonGroup2 = new ButtonGroup();
/* 140 */     this.buttonGroup3 = new ButtonGroup();
/* 141 */     this.buttonGroup4 = new ButtonGroup();
/* 142 */     this.buttonGroup5 = new ButtonGroup();
/* 143 */     this.jPanel1 = new JPanel();
/* 144 */     this.jScrollPane1 = new JScrollPane();
/* 145 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 147 */         return false;
/*     */       }
/*     */     };
/* 150 */     this.fechaini = new JDateChooser();
/* 151 */     this.fechafinal = new JDateChooser();
/* 152 */     this.jLabel1 = new JLabel();
/* 153 */     this.jLabel2 = new JLabel();
/* 154 */     this.jRadioButton1 = new JRadioButton();
/* 155 */     this.jRadioButton2 = new JRadioButton();
/* 156 */     this.jRadioButton3 = new JRadioButton();
/* 157 */     this.jRadioButton4 = new JRadioButton();
/* 158 */     this.jRadioButton5 = new JRadioButton();
/* 159 */     this.jRadioButton6 = new JRadioButton();
/* 160 */     this.jRadioButton7 = new JRadioButton();
/* 161 */     this.jButton1 = new JButton();
/* 162 */     this.jSeparator1 = new JSeparator();
/* 163 */     this.jSeparator2 = new JSeparator();
/* 164 */     this.gl = new JRadioButton();
/* 165 */     this.gb = new JRadioButton();
/* 166 */     this.jButton2 = new JButton();
/*     */ 
/* 168 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 169 */     this.jPanel1.setLayout(jPanel1Layout);
/* 170 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */ 
/* 174 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */ 
/* 179 */     setDefaultCloseOperation(2);
/* 180 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 182 */     this.tablasm.setBackground(new Color(102, 102, 255));
/* 183 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*     */ 
/* 194 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 196 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 990, 330));
/*     */ 
/* 198 */     this.fechaini.setDateFormatString("yyyy-MM-dd");
/* 199 */     getContentPane().add(this.fechaini, new AbsoluteConstraints(340, 380, 140, -1));
/*     */ 
/* 201 */     this.fechafinal.setDateFormatString("yyyy-MM-dd");
/* 202 */     getContentPane().add(this.fechafinal, new AbsoluteConstraints(530, 380, 160, 20));
/*     */ 
/* 204 */     this.jLabel1.setText("Fecha Inicial");
/* 205 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(410, 360, -1, -1));
/*     */ 
/* 207 */     this.jLabel2.setForeground(new Color(102, 204, 0));
/* 208 */     this.jLabel2.setText("Fecha Final");
/* 209 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(550, 360, -1, -1));
/*     */ 
/* 211 */     this.jRadioButton1.setBackground(new Color(204, 204, 255));
/* 212 */     this.jRadioButton1.setText("Por Departamento");
/* 213 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 215 */         InversionFecha.this.jRadioButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 218 */     getContentPane().add(this.jRadioButton1, new AbsoluteConstraints(380, 470, -1, -1));
/*     */ 
/* 220 */     this.jRadioButton2.setBackground(new Color(204, 204, 255));
/* 221 */     this.jRadioButton2.setText("Por Marca");
/* 222 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 224 */         InversionFecha.this.jRadioButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 227 */     getContentPane().add(this.jRadioButton2, new AbsoluteConstraints(520, 470, -1, -1));
/*     */ 
/* 229 */     this.jRadioButton3.setBackground(new Color(204, 204, 255));
/* 230 */     this.jRadioButton3.setText("Por Producto");
/* 231 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 233 */         InversionFecha.this.jRadioButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 236 */     getContentPane().add(this.jRadioButton3, new AbsoluteConstraints(620, 470, -1, -1));
/*     */ 
/* 238 */     this.jRadioButton4.setBackground(new Color(51, 102, 255));
/* 239 */     this.jRadioButton4.setText("Por año");
/* 240 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 242 */         InversionFecha.this.jRadioButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 245 */     this.jRadioButton4.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 247 */         InversionFecha.this.jRadioButton4FocusGained(evt);
/*     */       }
/*     */     });
/* 250 */     getContentPane().add(this.jRadioButton4, new AbsoluteConstraints(390, 420, -1, -1));
/*     */ 
/* 252 */     this.jRadioButton5.setBackground(new Color(51, 102, 255));
/* 253 */     this.jRadioButton5.setText("Por mes");
/* 254 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 256 */         InversionFecha.this.jRadioButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 259 */     getContentPane().add(this.jRadioButton5, new AbsoluteConstraints(470, 420, -1, -1));
/*     */ 
/* 261 */     this.jRadioButton6.setBackground(new Color(51, 102, 255));
/* 262 */     this.jRadioButton6.setText("Por dia");
/* 263 */     this.jRadioButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 265 */         InversionFecha.this.jRadioButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 268 */     getContentPane().add(this.jRadioButton6, new AbsoluteConstraints(550, 420, -1, -1));
/*     */ 
/* 270 */     this.jRadioButton7.setBackground(new Color(204, 204, 255));
/* 271 */     this.jRadioButton7.setText("Total");
/* 272 */     this.jRadioButton7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 274 */         InversionFecha.this.jRadioButton7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 277 */     this.jRadioButton7.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 279 */         InversionFecha.this.jRadioButton7FocusGained(evt);
/*     */       }
/*     */     });
/* 282 */     getContentPane().add(this.jRadioButton7, new AbsoluteConstraints(310, 470, -1, -1));
/*     */ 
/* 284 */     this.jButton1.setText("Mostrar");
/* 285 */     this.jButton1.setBorder(null);
/* 286 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 288 */         InversionFecha.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 291 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(720, 440, -1, -1));
/* 292 */     getContentPane().add(this.jSeparator1, new AbsoluteConstraints(330, 450, 380, -1));
/* 293 */     getContentPane().add(this.jSeparator2, new AbsoluteConstraints(340, 410, 350, 10));
/*     */ 
/* 295 */     this.gl.setText("Grafica de barras");
/* 296 */     this.gl.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 298 */         InversionFecha.this.glActionPerformed(evt);
/*     */       }
/*     */     });
/* 301 */     getContentPane().add(this.gl, new AbsoluteConstraints(30, 350, -1, -1));
/*     */ 
/* 303 */     this.gb.setText("Grafica lineal");
/* 304 */     this.gb.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 306 */         InversionFecha.this.gbActionPerformed(evt);
/*     */       }
/*     */     });
/* 309 */     getContentPane().add(this.gb, new AbsoluteConstraints(30, 390, -1, -1));
/*     */ 
/* 311 */     this.jButton2.setText("Generar");
/* 312 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 314 */         InversionFecha.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 317 */     getContentPane().add(this.jButton2, new AbsoluteConstraints(40, 430, -1, -1));
/*     */ 
/* 319 */     pack();
/*     */   }
/*     */ 
/*     */   private void jRadioButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 324 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton3.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton3.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton3.isSelected()))) {
/* 325 */       this.gl.setVisible(false); this.gb.setVisible(false); }
/* 326 */     this.consulta = "SELECT " + this.fecha + ", nombredep AS Departamento, nombremar AS Marca, codigobarras AS Codigo, nombreart Articulo, sum( cantidadcomp ) AS 'Cantidad Comprada', descripcion AS Descripcion, medida AS Medida, sum( cantidadcomp * preciocom ) AS 'Inversion por producto $' FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras)" + this.fechacons + " GROUP BY codigobarras," + this.finalcons;
/*     */   }
/*     */ 
/*     */   private void jRadioButton6ActionPerformed(ActionEvent evt)
/*     */   {
/* 331 */     this.jRadioButton1.setVisible(true);
/* 332 */     this.jRadioButton2.setVisible(true);
/* 333 */     this.jRadioButton3.setVisible(true);
/* 334 */     this.jRadioButton7.setVisible(true);
/* 335 */     this.fecha = " fechacom as Dia ";
/* 336 */     this.finalcons = " fechacom ORDER BY fechacom DESC , departamento, marca, articulo";
/* 337 */     this.finalcons2 = " fechacom ORDER BY fechacom DESC , departamento, marca";
/* 338 */     this.finalcons3 = " fechacom ORDER BY fechacom DESC , departamento";
/* 339 */     this.finalcons4 = " fechacom  ORDER BY  fechacom DESC";
/*     */   }
/*     */ 
/*     */   private void jRadioButton5ActionPerformed(ActionEvent evt)
/*     */   {
/* 344 */     this.jRadioButton1.setVisible(true);
/* 345 */     this.jRadioButton2.setVisible(true);
/* 346 */     this.jRadioButton3.setVisible(true);
/* 347 */     this.jRadioButton7.setVisible(true);
/* 348 */     this.fecha = " YEAR( fechacom ) AS Año, MONTHNAME( fechacom ) AS Mes";
/* 349 */     this.finalcons = " MONTHNAME( fechacom ) ORDER BY YEAR( fechacom ) desc, MONTHNAME( fechacom ) desc, departamento, marca, articulo";
/* 350 */     this.finalcons2 = " MONTHNAME( fechacom ) ORDER BY YEAR( fechacom ) desc, MONTHNAME( fechacom ) desc, departamento  , marca ";
/* 351 */     this.finalcons3 = "MONTHNAME( fechacom ) ORDER BY YEAR( fechacom )desc , MONTHNAME( fechacom ) desc , departamento ";
/* 352 */     this.finalcons4 = "MONTHNAME( fechacom ) ORDER BY YEAR (fechacom) desc, MONTHNAME( fechacom ) desc";
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 356 */     this.jRadioButton1.setVisible(false);
/* 357 */     this.jRadioButton2.setVisible(false);
/* 358 */     this.jRadioButton3.setVisible(false);
/* 359 */     this.jRadioButton7.setVisible(false);
/* 360 */     int año3 = this.fechaini.getCalendar().get(1);
/* 361 */     int mes3 = this.fechaini.getCalendar().get(2) + 1;
/* 362 */     int dia3 = this.fechaini.getCalendar().get(5);
/* 363 */     if (validarfecha(año3, mes3, dia3)) {
/* 364 */       conexioninicio ci = new conexioninicio();
/* 365 */       String consultasql = this.consulta;
/*     */       try {
/* 367 */         Class.forName("org.gjt.mm.mysql.Driver");
/*     */       } catch (ClassNotFoundException ex) {
/* 369 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 371 */       Connection con = null;
/*     */       try
/*     */       {
/* 375 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 376 */         DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 378 */         this.tablasm.setModel(modelo);
/*     */ 
/* 380 */         Statement stmt = con.createStatement();
/*     */ 
/* 382 */         ResultSet rs = stmt.executeQuery(consultasql);
/* 383 */         ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 385 */         int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 387 */         for (int i = 1; i <= cantidadColumnas; ++i) {
/* 388 */           modelo.addColumn(rsMd.getColumnLabel(i));
/*     */         }
/* 390 */         while (rs.next()) {
/* 391 */           Object[] fila = new Object[cantidadColumnas];
/* 392 */           for (int i = 0; i < cantidadColumnas; ++i)
/*     */           {
/* 394 */             fila[i] = rs.getObject(i + 1);
/*     */           }
/* 396 */           modelo.addRow(fila);
/*     */         }
/* 398 */         rs.close();
/* 399 */         con.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 403 */         if (con != null)
/*     */         {
/*     */           try {
/* 406 */             con.rollback();
/*     */           } catch (SQLException ex) {
/* 408 */             Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/* 410 */           JOptionPane.showMessageDialog(null, "Selecciones opciones", "Error", 0);
/*     */         }
/*     */       }
/*     */     } else {
/* 414 */       JOptionPane.showMessageDialog(null, "verifique las fechas", "error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jRadioButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 420 */     this.jRadioButton1.setVisible(true);
/* 421 */     this.jRadioButton2.setVisible(true);
/* 422 */     this.jRadioButton3.setVisible(true);
/* 423 */     this.jRadioButton7.setVisible(true);
/* 424 */     this.fecha = " YEAR( fechacom ) AS Año";
/* 425 */     this.finalcons = " YEAR( fechacom ) ORDER BY YEAR( fechacom ) desc, departamento, marca, articulo";
/* 426 */     this.finalcons2 = " YEAR( fechacom ) ORDER BY YEAR( fechacom ) desc, departamento, marca";
/* 427 */     this.finalcons3 = "YEAR( fechacom ) ORDER BY YEAR( fechacom ) desc , departamento";
/* 428 */     this.finalcons4 = "YEAR( fechacom ) ORDER BY YEAR( fechacom ) desc";
/*     */   }
/*     */ 
/*     */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 432 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton2.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton2.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton2.isSelected()))) {
/* 433 */       this.gl.setVisible(false); this.gb.setVisible(false); }
/* 434 */     cadenacons();
/* 435 */     this.consulta = "SELECT " + this.fecha + ", nombredep AS Departamento, nombremar AS Marca,  sum( cantidadcomp ) AS 'Cantidad Comprada',  sum( cantidadcomp * preciocom ) AS 'Inversion por Marca $' FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras) " + this.fechacons + "  GROUP BY idmarca," + this.finalcons2;
/*     */   }
/*     */ 
/*     */   private void jRadioButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 440 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton1.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton1.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton1.isSelected()))) {
/* 441 */       this.gl.setVisible(false); this.gb.setVisible(false); }
/* 442 */     cadenacons();
/* 443 */     this.consulta = "SELECT " + this.fecha + ", nombredep AS Departamento,  sum( cantidadcomp ) AS 'Productos Comprados',  sum( cantidadcomp * preciocom ) AS 'Inversion en Departamento $' FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras)" + this.fechacons + "  GROUP BY departamento," + this.finalcons3;
/*     */   }
/*     */ 
/*     */   private void jRadioButton7ActionPerformed(ActionEvent evt)
/*     */   {
/* 448 */     if (((this.jRadioButton6.isSelected()) && (this.jRadioButton7.isSelected())) || ((this.jRadioButton5.isSelected()) && (this.jRadioButton7.isSelected())) || ((this.jRadioButton4.isSelected()) && (this.jRadioButton7.isSelected()))) {
/* 449 */       this.gl.setVisible(true); this.gb.setVisible(true); }
/* 450 */     cadenacons();
/* 451 */     this.consulta = "SELECT " + this.fecha + ",   sum( cantidadcomp ) AS 'Productos Comprados',  sum( cantidadcomp * preciocom ) AS 'Inversion Total $' FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras)" + this.fechacons + "  GROUP BY " + this.finalcons4;
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
/* 464 */     String cos = null; String nomv = null; String horiz = null; String ver = null; String nombgraf = null;
/* 465 */     if ((this.jRadioButton6.isSelected()) && (this.jRadioButton7.isSelected()))
/*     */     {
/* 467 */       cos = "SELECT fechacom ,    sum( cantidadcomp * preciocom )  FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras)  GROUP BY fechacom  ORDER BY  fechacom";
/* 468 */       nomv = "Gastos";
/* 469 */       horiz = "Dia";
/* 470 */       ver = "Inversion";
/* 471 */       nombgraf = "Inversion al dia";
/*     */     }
/* 473 */     else if ((this.jRadioButton5.isSelected()) && (this.jRadioButton7.isSelected()))
/*     */     {
/* 475 */       cos = "SELECT DATE_FORMAT(fechacom, '%M %Y') ,    sum( cantidadcomp * preciocom )  FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras)  GROUP BY MONTHNAME( fechacom ) ORDER BY YEAR (fechacom) , MONTHNAME( fechacom )";
/* 476 */       nomv = "Gastos";
/* 477 */       horiz = "Mes";
/* 478 */       ver = "Inversion";
/* 479 */       nombgraf = "Inversion al Mes";
/*     */     }
/*     */     else {
/* 482 */       cos = "select YEAR( fechacom ) AS Año,  sum( cantidadcomp * preciocom )  FROM compra NATURAL JOIN articulo NATURAL JOIN departamento NATURAL JOIN marca WHERE codigobarras IN (SELECT codigobarras FROM compra GROUP BY codigobarras)  GROUP BY YEAR( fechacom ) ORDER BY YEAR( fechacom ) ";
/* 483 */       nomv = "Gastos";
/* 484 */       horiz = "Año";
/* 485 */       ver = "Inversion";
/* 486 */       nombgraf = "Inversion al Año";
/*     */     }
/* 488 */     GeneraGrafica gg = new GeneraGrafica();
/* 489 */     gg.recibirparametros(cos, nomv, horiz, ver, this.grafi, nombgraf);
/*     */   }
/*     */ 
/*     */   private void gbActionPerformed(ActionEvent evt) {
/* 493 */     this.grafi = 0;
/*     */   }
/*     */ 
/*     */   private void glActionPerformed(ActionEvent evt) {
/* 497 */     this.grafi = 1;
/*     */   }
/*     */ 
/*     */   public void cadenacons() {
/* 501 */     int año5 = this.fechafinal.getCalendar().get(1);
/* 502 */     int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/* 503 */     int dia5 = this.fechafinal.getCalendar().get(5);
/* 504 */     String dia6 = año5 + "-" + mes5 + "-" + dia5;
/*     */ 
/* 506 */     int año3 = this.fechaini.getCalendar().get(1);
/* 507 */     int mes3 = this.fechaini.getCalendar().get(2) + 1;
/* 508 */     int dia3 = this.fechaini.getCalendar().get(5);
/* 509 */     String dia4 = año3 + "-" + mes3 + "-" + dia3;
/* 510 */     this.fechacons = "AND DATE( fechacom ) BETWEEN'" + dia4 + "' AND '" + dia6 + "'";
/*     */   }
/*     */ 
/*     */   public final void fechaprimcompra()
/*     */   {
/* 515 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 517 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 519 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 521 */     Connection con = null;
/*     */     try
/*     */     {
/* 525 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 526 */       Statement stmt = con.createStatement();
/*     */ 
/* 528 */       ResultSet rs = stmt.executeQuery("SELECT fechacom  FROM compra where idcompra in (SELECT min(idcompra)  FROM compra) ");
/* 529 */       String dia = null;
/* 530 */       while (rs.next()) {
/* 531 */         dia = rs.getString("fechacom");
/* 532 */         System.out.println(dia);
/*     */       }
/*     */       try
/*     */       {
/* 536 */         Date fechaactual = new Date();
/* 537 */         Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dia);
/*     */ 
/* 539 */         this.fechaini.setDate(date);
/* 540 */         this.fechaini.setMinSelectableDate(date);
/* 541 */         this.fechaini.setMaxSelectableDate(fechaactual);
/* 542 */         this.fechafinal.setDate(fechaactual);
/* 543 */         this.fechafinal.setMinSelectableDate(this.fechaini.getDate());
/* 544 */         this.fechafinal.setMaxSelectableDate(fechaactual);
/* 545 */         int año5 = this.fechafinal.getCalendar().get(1);
/* 546 */         int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/* 547 */         int dia5 = this.fechafinal.getCalendar().get(5);
/* 548 */         String dia6 = año5 + "-" + mes5 + "-" + dia5;
/*     */ 
/* 550 */         int año3 = this.fechaini.getCalendar().get(1);
/* 551 */         int mes3 = this.fechaini.getCalendar().get(2) + 1;
/* 552 */         int dia3 = this.fechaini.getCalendar().get(5);
/* 553 */         String dia4 = año3 + "-" + mes3 + "-" + dia3;
/* 554 */         this.fechacons = "AND DATE( fechacom ) BETWEEN'" + dia4 + "' AND '" + dia6 + "'";
/*     */       }
/*     */       catch (ParseException ex) {
/* 557 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 563 */       JOptionPane.showMessageDialog(null, "Consulte con el admnistrador" + e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean validarfecha(int añoi, int mesi, int diai)
/*     */   {
/* 570 */     boolean t = false;
/* 571 */     int año5 = this.fechafinal.getCalendar().get(1);
/* 572 */     int mes5 = this.fechafinal.getCalendar().get(2) + 1;
/* 573 */     int dia5 = this.fechafinal.getCalendar().get(5);
/*     */ 
/* 575 */     if (añoi < año5)
/*     */     {
/* 577 */       t = true;
/*     */     }
/* 579 */     else if ((añoi == año5) && (mesi < mes5))
/*     */     {
/* 581 */       t = true;
/*     */     }
/* 584 */     else if ((añoi == año5) && (mesi == mes5) && (diai <= dia5))
/*     */     {
/* 587 */       t = true;
/*     */     }
/*     */     else
/*     */     {
/* 591 */       t = false;
/*     */     }
/*     */ 
/* 594 */     return t;
/*     */   }
/*     */ 
/*     */   public void mostrar()
/*     */   {
/* 606 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 608 */         new InversionFecha().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.InversionFecha
 * JD-Core Version:    0.5.3
 */