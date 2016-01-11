/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ 
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.io.IOException;

/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class ModificarArticulo extends JFrame
/*     */ {
/*  26 */   ArrayList a = new ArrayList();
/*  27 */   ArrayList mar = new ArrayList();
/*     */   private JTextField cb;
/*     */   private JComboBox dep;
/*     */   private JTextField desc;
/*     */   private JButton guardar;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel9;
/*     */   private JPanel jPanel1;
/*     */   private JTextField jTextField2;
/*     */   private JComboBox marca;
/*     */   private JTextField med;
/*     */   private JTextField name;
/*     */   private JTextField nombmarfv;
/*     */ 
/*     */   public ModificarArticulo()
/*     */   {
/*  30 */     setUndecorated(true);
/*  31 */     initComponents();
/*  32 */     setSize(430, 360);
/*  33 */     setResizable(false);
/*  34 */     setLocationRelativeTo(null);
/*  35 */     getRootPane().setDefaultButton(this.jButton4);
/*  36 */     this.cb.setToolTipText("Escriba el codigo de barras");
/*  37 */     this.marca.removeAllItems();
/*  38 */     this.mar.clear();
/*  39 */     conexioninicio ci = new conexioninicio();
/*  40 */     ci.conectar();
/*     */     Connection con;
/*     */     Statement stmt;
/*     */     ResultSet rs;
/*     */     ResultSetMetaData rsMd;
/*     */     int cantidadColumnas;
/*     */     Object[] fila;
/*     */     int i;
/*     */     try
/*     */     {
/*  42 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/*  44 */       stmt = con.createStatement();
/*     */ 
/*  46 */       rs = stmt.executeQuery("SELECT * FROM tienda.marca ");
/*     */ 
/*  48 */       rsMd = rs.getMetaData();
/*     */ 
/*  50 */       cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  54 */       while (rs.next()) {
/*  55 */         fila = new Object[cantidadColumnas];
/*  56 */         for (i = 1; i < cantidadColumnas; ++i) {
/*  57 */           this.marca.addItem(rs.getObject(i + 1));
/*  58 */           this.mar.add(rs.getString("idmarca"));
/*     */         }
/*     */       }
/*     */ 
/*  62 */       rs.close();
/*  63 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  67 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */ 
/*  72 */     this.dep.removeAllItems();
/*  73 */     this.a.clear();
/*  74 */     ci.conectar();
           
/*     */     try {
/*  76 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/*  78 */       stmt = con.createStatement();
/*     */ 
/*  80 */       rs = stmt.executeQuery("SELECT * FROM tienda.departamento order by nombredep ;");
/*     */ 
/*  82 */       rsMd = rs.getMetaData();
/*     */ 
/*  84 */       cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  88 */       while (rs.next()) {
/*  89 */         fila = new Object[cantidadColumnas];
/*  90 */         this.a.add(rs.getString("iddepartamento"));
/*  91 */         for (i = 1; i < cantidadColumnas; ++i) {
/*  92 */           this.dep.addItem(rs.getObject(i + 1));
/*     */         }
/*     */       }
/*     */ 
/*  96 */       rs.close();
/*  97 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 103 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 117 */     this.jPanel1 = new JPanel();
/* 118 */     this.jLabel1 = new JLabel();
/* 119 */     this.jLabel2 = new JLabel();
/* 120 */     this.jLabel3 = new JLabel();
/* 121 */     this.jLabel5 = new JLabel();
/* 122 */     this.marca = new JComboBox();
/* 123 */     this.dep = new JComboBox();
/* 124 */     this.guardar = new JButton();
/* 125 */     this.cb = new JTextField();
/* 126 */     this.name = new JTextField();
/* 127 */     this.med = new JTextField();
/* 128 */     this.desc = new JTextField();
/* 129 */     this.jLabel6 = new JLabel();
/* 130 */     this.nombmarfv = new JTextField();
/* 131 */     this.jButton1 = new JButton();
/* 132 */     this.jLabel7 = new JLabel();
/* 133 */     this.jTextField2 = new JTextField();
/* 134 */     this.jButton2 = new JButton();
/* 135 */     this.jButton3 = new JButton();
/* 136 */     this.jButton4 = new JButton();
/* 137 */     this.jLabel9 = new JLabel();
/*     */ 
/* 139 */     setDefaultCloseOperation(3);
/* 140 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 142 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/* 144 */     this.jLabel1.setText("Codigo de barras");
/* 145 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(40, 50, -1, -1));
/*     */ 
/* 147 */     this.jLabel2.setText("Nombre");
/* 148 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(60, 80, -1, -1));
/*     */ 
/* 150 */     this.jLabel3.setText("Medida");
/* 151 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(96, 105, -1, -1));
/*     */ 
/* 153 */     this.jLabel5.setText("Descripcion");
/* 154 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(30, 140, -1, -1));
/*     */ 
/* 156 */     this.marca.addFocusListener(new FocusAdapter() {
/*     */   @Override
       public void focusGained(FocusEvent evt) {
/* 158 */         ModificarArticulo.this.marcaFocusGained(evt);
/*     */       }
/*     */     });
/* 161 */     this.jPanel1.add(this.marca, new AbsoluteConstraints(80, 180, -1, -1));
/*     */ 
/* 163 */     this.dep.addFocusListener(new FocusAdapter() {
/*     */   @Override
       public void focusGained(FocusEvent evt) {
/* 165 */         ModificarArticulo.this.depFocusGained(evt);
/*     */       }
/*     */     });
/* 168 */     this.jPanel1.add(this.dep, new AbsoluteConstraints(250, 180, -1, -1));
/*     */ 
/* 170 */     this.guardar.setText("Guardar");
/* 171 */     this.guardar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 173 */         ModificarArticulo.this.guardarActionPerformed(evt);
/*     */       }
/*     */     });
/* 176 */     this.jPanel1.add(this.guardar, new AbsoluteConstraints(160, 10, 100, 20));
/* 177 */     this.jPanel1.add(this.cb, new AbsoluteConstraints(140, 40, 166, -1));
/* 178 */     this.jPanel1.add(this.name, new AbsoluteConstraints(140, 70, 92, -1));
/* 179 */     this.jPanel1.add(this.med, new AbsoluteConstraints(140, 102, 74, -1));
/* 180 */     this.jPanel1.add(this.desc, new AbsoluteConstraints(103, 140, 310, -1));
/*     */ 
/* 182 */     this.jLabel6.setText("Nueva Marca");
/* 183 */     this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(40, 230, -1, -1));
/* 184 */     this.jPanel1.add(this.nombmarfv, new AbsoluteConstraints(120, 230, 127, -1));
/*     */ 
/* 186 */     this.jButton1.setText("Guadar");
/* 187 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 189 */         ModificarArticulo.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 192 */     this.jPanel1.add(this.jButton1, new AbsoluteConstraints(270, 230, -1, -1));
/*     */ 
/* 194 */     this.jLabel7.setText("Nuevo Departamento");
/* 195 */     this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(30, 280, -1, -1));
/* 196 */     this.jPanel1.add(this.jTextField2, new AbsoluteConstraints(140, 270, 127, -1));
/*     */ 
/* 198 */     this.jButton2.setText("Guardar");
/* 199 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 201 */         ModificarArticulo.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 204 */     this.jPanel1.add(this.jButton2, new AbsoluteConstraints(280, 270, -1, -1));
/*     */ 
/* 206 */     this.jButton3.setText("Regresar");
/* 207 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 209 */         ModificarArticulo.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 212 */     this.jPanel1.add(this.jButton3, new AbsoluteConstraints(10, 310, 100, -1));
/*     */ 
/* 214 */     this.jButton4.setText("Buscar");
/* 215 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 217 */         ModificarArticulo.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 220 */     this.jPanel1.add(this.jButton4, new AbsoluteConstraints(340, 40, -1, -1));
/*     */ 
/* 222 */     this.jLabel9.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/fondoMP.png")));
/* 223 */     this.jLabel9.setText("jLabel9");
/* 224 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(0, 0, 470, 370));
/*     */ 
/* 226 */     getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 470, 440));
/*     */ 
/* 228 */     pack();
/*     */   }
/*     */ 
/*     */   private void marcaFocusGained(FocusEvent evt) {
/* 232 */     this.marca.removeAllItems();
/* 233 */     this.mar.clear();
/* 234 */     conexioninicio ci = new conexioninicio();
/* 235 */     ci.conectar();
/*     */     try {
/* 237 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 239 */       Statement stmt = con.createStatement();
/*     */ 
/* 241 */       ResultSet rs = stmt.executeQuery("SELECT * FROM tienda.marca ");
/*     */ 
/* 243 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 245 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 249 */       while (rs.next()) {
/* 250 */         Object[] fila = new Object[cantidadColumnas];
/* 251 */         for (int i = 1; i < cantidadColumnas; ++i) {
/* 252 */           this.marca.addItem(rs.getObject(i + 1));
/* 253 */           this.mar.add(rs.getString("idmarca"));
/*     */         }
/*     */       }
/*     */ 
/* 257 */       rs.close();
/* 258 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void depFocusGained(FocusEvent evt)
/*     */   {
/* 268 */     this.dep.removeAllItems();
/* 269 */     this.a.clear();
/* 270 */     conexioninicio ci = new conexioninicio();
/* 271 */     ci.conectar();
/*     */     try {
/* 273 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 275 */       Statement stmt = con.createStatement();
/*     */ 
/* 277 */       ResultSet rs = stmt.executeQuery("SELECT * FROM tienda.departamento order by nombredep ;");
/*     */ 
/* 279 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 281 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 285 */       while (rs.next()) {
/* 286 */         Object[] fila = new Object[cantidadColumnas];
/* 287 */         this.a.add(rs.getString("iddepartamento"));
/* 288 */         for (int i = 1; i < cantidadColumnas; ++i) {
/* 289 */           this.dep.addItem(rs.getObject(i + 1));
/*     */         }
/*     */       }
/*     */ 
/* 293 */       rs.close();
/* 294 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 300 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 309 */       if (this.nombmarfv.getText().length() > 0)
/*     */       {
/* 312 */         conexioninicio ci = new conexioninicio();
/* 313 */         Connection con = null;
/*     */         try {
/* 315 */           con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 317 */           String cadenasql = "insert into tienda.marca(idmarca,nombremar) values(NULL,'" + this.nombmarfv.getText().toUpperCase() + "')";
/* 318 */           Statement stmt = con.createStatement();
/* 319 */           stmt.executeUpdate(cadenasql);
/* 320 */           JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
/* 321 */           this.nombmarfv.setText("");
/*     */         }
/*     */         catch (SQLException e)
/*     */         {
/* 326 */           JOptionPane.showMessageDialog(null, "La marca ya esta registrada", "Error", 0);
/* 327 */           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 333 */         JOptionPane.showMessageDialog(null, "Escriba el nombre de la marca.\n");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 343 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 345 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 347 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 349 */     Connection con = null;
/*     */     try
/*     */     {
/* 352 */       if (this.jTextField2.getText().length() > 0) {
/* 353 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 355 */         String cadenasql = "insert into tienda.departamento(iddepartamento,nombredep) values(NULL,'" + this.jTextField2.getText().toUpperCase() + "')";
/* 356 */         Statement stmt = con.createStatement();
/* 357 */         stmt.executeUpdate(cadenasql);
/*     */ 
/* 359 */         JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
/* 360 */         this.jTextField2.setText(""); } else {
/* 361 */         JOptionPane.showMessageDialog(null, "Ingrese el nombre del departamento", "", 0);
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 366 */       JOptionPane.showMessageDialog(null, "La marca ya esta registrada", "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void guardarActionPerformed(ActionEvent evt) {
/* 371 */     conexioninicio ci = new conexioninicio();
/* 372 */     Connection con = null;
/* 373 */     Connection con1 = null;
/* 374 */     if (this.cb.getText().length() > 0) {
/*     */       try
/*     */       {
/* 377 */         Class.forName("org.gjt.mm.mysql.Driver");
/* 378 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 379 */         con1 = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 380 */         Statement stmt = con.createStatement();
/*     */ 
/* 382 */         String cadenasql = "UPDATE articulo  SET codigobarras='" + this.cb.getText().toUpperCase() + "'" + "," + "nombreart=" + "'" + this.name.getText().toUpperCase() + "'" + "," + "medida=" + "'" + this.med.getText() + "'" + "," + "descripcion=" + "'" + this.desc.getText() + "'" + "," + "idmarca=" + "'" + this.mar.get(this.marca.getSelectedIndex()) + "'" + ",iddepartamento=" + "'" + this.a.get(this.dep.getSelectedIndex()) + "' where codigobarras ='" + this.cb.getText() + "'";
/*     */ 
/* 384 */         stmt.executeUpdate(cadenasql);
/* 385 */         JOptionPane.showMessageDialog(this, "Actualizacion Exitosa");
/*     */       }
/*     */       catch (Exception e) {
/* 388 */         System.out.println(e.getMessage());
/*     */       }
/*     */     }
/*     */     else {
/* 392 */       JOptionPane.showMessageDialog(null, "Ingrese el codidigo de barras porfavor.\n");
/*     */     }
/*     */ 
/* 396 */     this.name.setText("");
/* 397 */     this.desc.setText("");
/* 398 */     this.med.setText("");
/* 399 */     this.marca.setSelectedIndex(0);
/* 400 */     this.dep.setSelectedIndex(0);
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 407 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 411 */     conexioninicio ci = new conexioninicio();
/* 412 */     Connection con = null;
/*     */     try
/*     */     {
/* 415 */       Class.forName("org.gjt.mm.mysql.Driver");
/* 416 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 417 */       Statement stmt = con.createStatement();
/* 418 */       String cadenasql = "select * from  articulo natural join marca natural join departamento where codigobarras='" + this.cb.getText() + "' ";
/* 419 */       ResultSet rs = stmt.executeQuery(cadenasql);
/*     */ 
/* 421 */       while (rs.next()) {
/* 422 */         this.name.setText(rs.getString("nombreart"));
/* 423 */         this.desc.setText(rs.getString("descripcion"));
/* 424 */         this.med.setText(rs.getString("medida"));
/* 425 */         this.marca.setSelectedItem(rs.getString("nombremar"));
/* 426 */         this.dep.setSelectedItem(rs.getString("nombredep"));
/*     */       }
/* 428 */       if (!(rs.first())) {
/* 429 */         JOptionPane.showMessageDialog(this, "El codigo no es valido");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 434 */       System.out.println("for?" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   boolean verificarProducto(String elUsr, String elPw) throws IOException
/*     */   {
/*     */     try {
/* 441 */       conexioninicio ci = new conexioninicio();
/* 442 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 445 */       Statement instruccionSQL = con.createStatement();
/* 446 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM marca WHERE nombremar='" + elUsr + "' AND iddepartamento='" + elPw + "'");
/*     */ 
/* 449 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 455 */     return false;
/*     */   }
/*     */ 
/*     */   public void iniciaarMod()
/*     */   {
/* 463 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 465 */         new ModificarArticulo().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   boolean verificarCo(String co) throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 474 */       conexioninicio ci = new conexioninicio();
/* 475 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 478 */       Statement instruccionSQL = con.createStatement();
/* 479 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM articulo WHERE codigobarras='" + co + "'");
/*     */ 
/* 482 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 488 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.ModificarArticulo
 * JD-Core Version:    0.5.3
 */