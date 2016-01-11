/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class AgregarSucursal extends JFrame
/*     */ {
/*  26 */   ArrayList mar = new ArrayList();
/*     */   private JTextField calle;
/*     */   private JTextField colonia;
/*     */   private JTextField cp;
/*     */   private JTextField email;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JComboBox jComboBox2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel17;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JPanel jPanel1;
            private JLabel jPrfc;
/*     */   private JTextField mens1;
/*     */   private JTextField mens2;
/*     */   private JTextField municipio;
/*     */   private JTextField nombre;
/*     */   private JTextField num;
/*     */   private JTextField numet;
/*     */   private JComboBox stado;
/*     */   private JTextField telefono;
/*     */    private JTextField rfc;
/*     */   public AgregarSucursal()
/*     */   {
/*  29 */     initComponents();
/*  30 */     conexioninicio ci = new conexioninicio();
/*  31 */     ci.conectar();
/*  32 */     setSize(455, 530);
/*  33 */     setLocationRelativeTo(null);
/*  34 */     setResizable(false);
/*  35 */     this.jComboBox2.setVisible(false);
/*     */     try {
/*  37 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/*  39 */       Statement stmt = con.createStatement();
/*     */ 
/*  41 */       ResultSet rs = stmt.executeQuery("SELECT * FROM tienda.estado WHERE idestado>0;");
/*     */ 
/*  43 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  45 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  49 */       while (rs.next()) {
/*  50 */         Object[] fila = new Object[cantidadColumnas];
/*  51 */         for (int i = 1; i < cantidadColumnas; ++i) {
/*  52 */           this.stado.addItem(rs.getObject(i + 1));
/*  53 */           this.mar.add(rs.getString("idestado"));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  58 */       rs.close();
/*  59 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  65 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  80 */     this.jPanel1 = new JPanel();
/*  81 */     this.jLabel1 = new JLabel();
/*  82 */     this.jLabel2 = new JLabel();
/*  83 */     this.jLabel4 = new JLabel();
/*  84 */     this.jLabel5 = new JLabel();
/*  85 */     this.jLabel7 = new JLabel();
/*  86 */     this.jLabel8 = new JLabel();
/*  87 */     this.jLabel9 = new JLabel();
/*  88 */     this.jLabel10 = new JLabel();
/*  89 */     this.jLabel11 = new JLabel();
               this.jPrfc = new JLabel();
/*  90 */     this.nombre = new JTextField();
/*  91 */     this.calle = new JTextField();
/*  92 */     this.num = new JTextField();
/*  93 */     this.colonia = new JTextField();
/*  94 */     this.municipio = new JTextField();
              this.rfc = new JTextField();
/*  95 */     this.stado = new JComboBox();
/*  96 */     this.cp = new JTextField();
/*  97 */     this.email = new JTextField();
/*  98 */     this.telefono = new JTextField();
/*  99 */     this.jButton1 = new JButton();
/* 100 */     this.jComboBox2 = new JComboBox();
/* 101 */     this.jLabel17 = new JLabel();
/* 102 */     this.mens1 = new JTextField();
/* 103 */     this.mens2 = new JTextField();
/* 104 */     this.jButton2 = new JButton();
/* 105 */     this.jButton3 = new JButton();
/* 106 */     this.numet = new JTextField();
/* 107 */     this.jButton4 = new JButton();
/*     */ 
/* 109 */     setDefaultCloseOperation(2);
/* 110 */     setTitle("Administrador");
/*     */ 
/* 112 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/* 114 */     this.jLabel1.setText("Datos de la sucursal");
/* 115 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 10, -1, -1));
            
/*     */ 
/* 117 */     this.jLabel2.setText("Nombre:");
/* 118 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(10, 34, 79, -1));

              this.jPrfc.setText("RFC:");
/* 115 */     this.jPanel1.add(this.jPrfc, new AbsoluteConstraints(10, 60, -1, -1));
/*     */ 
/* 120 */     this.jLabel4.setText("Calle y numero");
/* 121 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(10, 91, 79, -1));
/*     */ 
/* 123 */     this.jLabel5.setText("Colonia");
/* 124 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(10, 119, -1, -1));
/*     */ 
/* 126 */     this.jLabel7.setText("Municipio");
/* 127 */     this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(10, 156, -1, -1));
/*     */ 
/* 129 */     this.jLabel8.setText("Estado");
/* 130 */     this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(10, 191, -1, -1));
/*     */ 
/* 132 */     this.jLabel9.setText("Codigo Postal");
/* 133 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(10, 243, -1, -1));
/*     */ 
/* 135 */     this.jLabel10.setText("Email");
/* 136 */     this.jPanel1.add(this.jLabel10, new AbsoluteConstraints(10, 276, -1, -1));
/*     */ 
/* 138 */     this.jLabel11.setText("Telefono");
/* 139 */     this.jPanel1.add(this.jLabel11, new AbsoluteConstraints(10, 302, -1, -1));

/* 140 */     this.jPanel1.add(this.nombre, new AbsoluteConstraints(107, 31, 218, -1));

              this.jPanel1.add(this.rfc, new AbsoluteConstraints(107, 58, 218, -1));
/* 141 */     this.jPanel1.add(this.calle, new AbsoluteConstraints(107, 88, 218, -1));

/* 142 */     this.jPanel1.add(this.num, new AbsoluteConstraints(331, 88, 34, -1));
/* 143 */     this.jPanel1.add(this.colonia, new AbsoluteConstraints(107, 119, 218, -1));
/* 144 */     this.jPanel1.add(this.municipio, new AbsoluteConstraints(107, 150, 218, -1));
/*     */ 
/* 146 */     this.stado.setModel(new DefaultComboBoxModel(new String[0]));
/* 147 */     this.stado.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 149 */         AgregarSucursal.this.stadoItemStateChanged(evt);
/*     */       }
/*     */     });
/* 152 */     this.jPanel1.add(this.stado, new AbsoluteConstraints(107, 188, -1, -1));
/* 153 */     this.jPanel1.add(this.cp, new AbsoluteConstraints(107, 240, 76, -1));
/* 154 */     this.jPanel1.add(this.email, new AbsoluteConstraints(107, 273, 218, -1));
/* 155 */     this.jPanel1.add(this.telefono, new AbsoluteConstraints(107, 299, 218, -1));
/*     */ 
/* 157 */     this.jButton1.setText("Agregar");
/* 158 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 160 */         AgregarSucursal.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 163 */     this.jPanel1.add(this.jButton1, new AbsoluteConstraints(350, 430, -1, -1));
/*     */ 
/* 165 */     this.jComboBox2.setModel(new DefaultComboBoxModel(new String[0]));
/* 166 */     this.jComboBox2.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 168 */         AgregarSucursal.this.jComboBox2ItemStateChanged(evt);
/*     */       }
/*     */     });
/* 171 */     this.jPanel1.add(this.jComboBox2, new AbsoluteConstraints(107, 188, -1, -1));
/*     */ 
/* 173 */     this.jLabel17.setText("Mensaje de ticket de venta");
/* 174 */     this.jPanel1.add(this.jLabel17, new AbsoluteConstraints(10, 340, -1, -1));
/* 175 */     this.jPanel1.add(this.mens1, new AbsoluteConstraints(10, 360, 440, -1));
/* 176 */     this.jPanel1.add(this.mens2, new AbsoluteConstraints(10, 390, 440, -1));
/*     */ 
/* 178 */     this.jButton2.setText("Mostrar Datos sucursal");
/* 179 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 181 */         AgregarSucursal.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 184 */     this.jPanel1.add(this.jButton2, new AbsoluteConstraints(10, 440, -1, -1));
/*     */ 
/* 186 */     this.jButton3.setText("Modificar");
/* 187 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 189 */         AgregarSucursal.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 192 */     this.jPanel1.add(this.jButton3, new AbsoluteConstraints(210, 440, -1, -1));
/* 193 */     this.jPanel1.add(this.numet, new AbsoluteConstraints(50, 470, 90, -1));
/*     */ 
/* 195 */     this.jButton4.setText("Imprimir Ticket de prueba");
/* 196 */     this.jButton4.setBorder(null);
/* 197 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 199 */         AgregarSucursal.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 202 */     this.jPanel1.add(this.jButton4, new AbsoluteConstraints(290, 190, -1, -1));
/*     */ 
/* 204 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 205 */     getContentPane().setLayout(layout);
/* 206 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, 484, 32767));
/*     */ 
/* 210 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 500, 32767));
/*     */ 
/* 215 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 219 */     conexioninicio ci = new conexioninicio();
/*     */     try {
/* 221 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 223 */       Logger.getLogger(AgregarSucursal.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 225 */     Connection con = null;
/*     */     try
/*     */     {
/* 229 */       if (this.nombre.getText().length() > 0)
/*     */       {
/* 232 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 233 */         con.setAutoCommit(false);
/*     */ 
/* 235 */         String cadenasql = "insert into tienda.sucursal(nombresuc,calle,colonia,nume,municipio,cp,idestado,mensaje1,mensaje2 ,email ,tel,rfc ) values('" + this.nombre.getText().toUpperCase() + "','" + this.calle.getText().toUpperCase() + "','" + this.colonia.getText().toUpperCase() + "','" + this.num.getText().toUpperCase() + "','" + this.municipio.getText().toUpperCase() + "','" + this.cp.getText() + "','" + this.mar.get(this.stado.getSelectedIndex()) + "','" + this.mens1.getText() + "','" + this.mens2.getText() + "','" + this.email.getText() + "','" + this.telefono.getText() + "','" + this.rfc.getText() + "')";
/* 236 */         Statement stmt = con.createStatement();
/* 237 */         stmt.executeUpdate(cadenasql);
/* 238 */         con.commit();
/* 239 */         JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
/*     */       }
/*     */       else
/*     */       {
/* 243 */         JOptionPane.showMessageDialog(null, "Escriba el nombre de la empresa", "Error", 0);
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 248 */       if (con == null)
/*     */         return;
/*     */       try {
/* 251 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 253 */         Logger.getLogger(AgregarSucursal.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 255 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void stadoItemStateChanged(ItemEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jComboBox2ItemStateChanged(ItemEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 272 */     conexioninicio ci = new conexioninicio();
/* 273 */     Connection con = null;
/*     */     try
/*     */     {
/* 276 */       Class.forName("org.gjt.mm.mysql.Driver");
/* 277 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 278 */       Statement stmt = con.createStatement();
/* 279 */       String cadenasql = "select * from  sucursal natural join estado where numerotienda='" + this.numet.getText() + "' ";
/* 280 */       ResultSet rs = stmt.executeQuery(cadenasql);
/*     */ 
/* 282 */       while (rs.next()) {
/* 283 */         this.nombre.setText(rs.getString("nombresuc"));
/* 284 */         this.calle.setText(rs.getString("calle"));
/* 285 */         this.num.setText(rs.getString("nume"));
/* 286 */         this.colonia.setText(rs.getString("colonia"));
/* 287 */         this.municipio.setText(rs.getString("municipio"));
/* 288 */         this.cp.setText(rs.getString("cp"));
/* 289 */         this.email.setText(rs.getString("email"));
/* 290 */         this.mens1.setText(rs.getString("mensaje1"));
/* 291 */         this.mens2.setText(rs.getString("mensaje2"));
/* 292 */         this.telefono.setText(rs.getString("tel"));
/* 293 */         this.stado.setSelectedItem(rs.getString("nombreest"));
                   this.rfc.setText(rs.getString("rfc"));
/*     */       }
/*     */ 
/* 296 */       if (!(rs.first())) {
/* 297 */         JOptionPane.showMessageDialog(this, "El numero no es valido");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 302 */       System.out.println("for?" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 307 */     conexioninicio ci = new conexioninicio();
/* 308 */     Connection con = null;
/*     */ 
/* 310 */     if (this.numet.getText().length() > 0) {
/*     */       try
/*     */       {
/* 313 */         Class.forName("org.gjt.mm.mysql.Driver");
/* 314 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 316 */         Statement stmt = con.createStatement();
/*     */ 
/* 318 */         String cadenasql = "UPDATE sucursal  SET nombresuc='" + this.nombre.getText().toUpperCase() + "'" + "," + "calle=" + "'" + this.calle.getText().toUpperCase() + "'" + "," + "nume=" + "'" + this.num.getText() + "'" + "," + "colonia=" + "'" + this.colonia.getText() + "'" + "," + "idestado=" + "'" + this.mar.get(this.stado.getSelectedIndex()) + "'" + ",cp=" + "'" + this.cp.getText() + "',email=" + "'" + this.email.getText() + "',tel=" + "'" + this.telefono.getText() + "',mensaje1=" + "'" + this.mens1.getText() + "',mensaje2=" + "'" + this.mens2.getText()+ "',rfc=" + "'" + this.rfc.getText() + "' where numerotienda ='" + this.numet.getText() + "'";
/*     */ 
/* 320 */         stmt.executeUpdate(cadenasql);
/* 321 */         JOptionPane.showMessageDialog(this, "Actualizacion Exitosa");
/*     */       }
/*     */       catch (Exception e) {
/* 324 */         System.out.println(e.getMessage());
/*     */       }
/*     */     }
/*     */     else
/* 328 */       JOptionPane.showMessageDialog(null, "Ingrese numero de la sucursal.\n");
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void MostrarPirncipaladmin()
/*     */   {
/* 344 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 348 */         new AgregarSucursal().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.AgregarSucursal
 * JD-Core Version:    0.5.3
 */