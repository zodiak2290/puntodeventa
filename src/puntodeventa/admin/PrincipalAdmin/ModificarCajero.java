/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
import FabricadeVentanas.Ventanas.Ventana;
/*     */ import java.awt.Color;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class ModificarCajero extends JFrame implements Ventana
{
/*     */   static String User;
            private static ModificarAdmin instancia = null;
/*     */   private JTextField apMat;
/*     */   private JTextField apPat;
/*     */   private JTextField calle;
/*     */   private JTextField colonia;
/*     */   private JTextField cp;
/*     */   private JTextField curp;
/*     */   private JTextField email;
/*     */   private JTextField idcajero;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JPanel jPanel1;
/*     */   private JTextField municipio;
/*     */   private JTextField nombre;
/*     */   private JTextField num;
/*     */   private JTextField telefono;
/*     */ 
/*     */   public ModificarCajero()
/*     */   {
                this.addWindowListener(new WindowListener(){
            public void windowActivated(WindowEvent e){}
            public void windowClosed(WindowEvent e){
            instancia=null;
            }
            public void windowDeactivated(WindowEvent e){}
            public void windowDeiconified(WindowEvent e){}
            public void windowIconified(WindowEvent e){}
            public void windowOpened(WindowEvent e){}
            public void windowClosing(WindowEvent e){
                System.out.println("Cerrando ventana...");
                e.getWindow().dispose();
            }
        });
/*  28 */     initComponents();
/*  29 */     conexioninicio ci = new conexioninicio();
/*  30 */     ci.conectar();
/*  31 */     setSize(420, 520);
/*  32 */     setResizable(false);
/*  33 */     setLocationRelativeTo(null);
/*  34 */     getRootPane().setDefaultButton(this.jButton3);
/*     */     try
/*     */     {
/*  37 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/*  39 */       Statement stmt = con.createStatement();
/*     */ 
/*  41 */       ResultSet rs = stmt.executeQuery("SELECT * FROM tienda.estado ;");
/*     */ 
/*  43 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  45 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  49 */       while (rs.next()) {
/*  50 */         Object[] fila = new Object[cantidadColumnas];
/*  51 */         for (int i = 1; i < cantidadColumnas; ++i) {
/*  52 */           this.jComboBox1.addItem(rs.getObject(i + 1));
/*     */         }
/*     */       }
/*     */ 
/*  56 */       rs.close();
/*  57 */       con.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  63 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void recibirUsuario(String Useri)
/*     */   {
/*  72 */     User = Useri;
/*     */   }
/*     */ 
/*     */   public String EnviarUsuario() {
/*  76 */     return User;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  90 */     this.jPanel1 = new JPanel();
/*  91 */     this.jLabel1 = new JLabel();
/*  92 */     this.jLabel2 = new JLabel();
/*  93 */     this.jLabel3 = new JLabel();
/*  94 */     this.jLabel4 = new JLabel();
/*  95 */     this.jLabel5 = new JLabel();
/*  96 */     this.jLabel7 = new JLabel();
/*  97 */     this.jLabel8 = new JLabel();
/*  98 */     this.jLabel9 = new JLabel();
/*  99 */     this.jLabel10 = new JLabel();
/* 100 */     this.jLabel11 = new JLabel();
/* 101 */     this.nombre = new JTextField();
/* 102 */     this.apPat = new JTextField();
/* 103 */     this.calle = new JTextField();
/* 104 */     this.num = new JTextField();
/* 105 */     this.colonia = new JTextField();
/* 106 */     this.municipio = new JTextField();
/* 107 */     this.jComboBox1 = new JComboBox();
/* 108 */     this.cp = new JTextField();
/* 109 */     this.email = new JTextField();
/* 110 */     this.telefono = new JTextField();
/* 111 */     this.jLabel6 = new JLabel();
/* 112 */     this.idcajero = new JTextField();
/* 113 */     this.jLabel14 = new JLabel();
/* 114 */     this.curp = new JTextField();
/* 115 */     this.apMat = new JTextField();
/* 116 */     this.jButton3 = new JButton();
/* 117 */     this.jButton2 = new JButton();
/* 118 */     this.jButton1 = new JButton();
/* 119 */     this.jMenuBar1 = new JMenuBar();
/*     */ 
/* 121 */     setDefaultCloseOperation(2);
/* 122 */     setTitle(EnviarUsuario());
/* 123 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 125 */     this.jPanel1.setBackground(new Color(153, 204, 255));
/* 126 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/* 128 */     this.jLabel1.setText("Modifique sus datos");
/* 129 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 11, -1, -1));
/*     */ 
/* 131 */     this.jLabel2.setText("Nombre(s)     *");
/* 132 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(10, 34, 79, -1));
/*     */ 
/* 134 */     this.jLabel3.setText("Apellidos       *");
/* 135 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(10, 65, 79, -1));
/*     */ 
/* 137 */     this.jLabel4.setText("Calle y numero");
/* 138 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(10, 91, 79, -1));
/*     */ 
/* 140 */     this.jLabel5.setText("Colonia");
/* 141 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(10, 119, -1, -1));
/*     */ 
/* 143 */     this.jLabel7.setText("Municipio");
/* 144 */     this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(10, 156, -1, -1));
/*     */ 
/* 146 */     this.jLabel8.setText("Estado");
/* 147 */     this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(10, 191, -1, -1));
/*     */ 
/* 149 */     this.jLabel9.setText("Codigo Postal");
/* 150 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(240, 190, -1, -1));
/*     */ 
/* 152 */     this.jLabel10.setText("Email");
/* 153 */     this.jPanel1.add(this.jLabel10, new AbsoluteConstraints(30, 230, -1, -1));
/*     */ 
/* 155 */     this.jLabel11.setText("Telefono");
/* 156 */     this.jPanel1.add(this.jLabel11, new AbsoluteConstraints(10, 267, -1, -1));
/* 157 */     this.jPanel1.add(this.nombre, new AbsoluteConstraints(107, 31, 218, -1));
/* 158 */     this.jPanel1.add(this.apPat, new AbsoluteConstraints(107, 62, 105, -1));
/* 159 */     this.jPanel1.add(this.calle, new AbsoluteConstraints(107, 88, 218, -1));
/* 160 */     this.jPanel1.add(this.num, new AbsoluteConstraints(331, 88, 34, -1));
/* 161 */     this.jPanel1.add(this.colonia, new AbsoluteConstraints(107, 119, 218, -1));
/* 162 */     this.jPanel1.add(this.municipio, new AbsoluteConstraints(107, 150, 218, -1));
/*     */ 
/* 164 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[0]));
/* 165 */     this.jComboBox1.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 167 */         ModificarCajero.this.jComboBox1ItemStateChanged(evt);
/*     */       }
/*     */     });
/* 170 */     this.jPanel1.add(this.jComboBox1, new AbsoluteConstraints(107, 188, -1, -1));
/* 171 */     this.jPanel1.add(this.cp, new AbsoluteConstraints(320, 190, 76, -1));
/* 172 */     this.jPanel1.add(this.email, new AbsoluteConstraints(107, 226, 218, -1));
/* 173 */     this.jPanel1.add(this.telefono, new AbsoluteConstraints(107, 264, 218, -1));
/*     */ 
/* 175 */     this.jLabel6.setText("ID Cajero");
/* 176 */     this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(10, 310, -1, -1));
/* 177 */     this.jPanel1.add(this.idcajero, new AbsoluteConstraints(110, 300, 158, -1));
/*     */ 
/* 179 */     this.jLabel14.setText("Curp");
/* 180 */     this.jPanel1.add(this.jLabel14, new AbsoluteConstraints(20, 450, -1, -1));
/* 181 */     this.jPanel1.add(this.curp, new AbsoluteConstraints(60, 450, 218, -1));
/* 182 */     this.jPanel1.add(this.apMat, new AbsoluteConstraints(221, 62, 104, -1));
/*     */ 
/* 184 */     this.jButton3.setText("Guardar");
/* 185 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 187 */         ModificarCajero.this.jButton3ActionPerformed1(evt);
/*     */       }
/*     */     });
/* 190 */     this.jPanel1.add(this.jButton3, new AbsoluteConstraints(30, 400, 99, -1));
/*     */ 
/* 192 */     this.jButton2.setText("Cambiar Contraseña");
/* 193 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 195 */         ModificarCajero.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 198 */     this.jPanel1.add(this.jButton2, new AbsoluteConstraints(250, 400, -1, -1));
/*     */ 
/* 200 */     this.jButton1.setText("Buscar");
/* 201 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 203 */         ModificarCajero.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 206 */     this.jPanel1.add(this.jButton1, new AbsoluteConstraints(290, 450, -1, -1));
/*     */ 
/* 208 */     getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 410, 490));
/* 209 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 211 */     pack();
/*     */   }
/*     */ 
/*     */   private void jComboBox1ItemStateChanged(ItemEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 219 */     CambiarContraseñaCaj cc = new CambiarContraseñaCaj();
/* 220 */     cc.MostrarPirncipaladmin();
/* 221 */     cc.recibirCurp(this.curp.getText());
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed1(ActionEvent evt)
/*     */   {
                Aceptar();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 258 */     conexioninicio ci = new conexioninicio();
/* 259 */     Connection con = null;
/*     */     try
/*     */     {
/* 262 */       Class.forName("org.gjt.mm.mysql.Driver");
/* 263 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 264 */       Statement stmt = con.createStatement();
/* 265 */       String cadenasql = "select nombre,apPat,apMat,calle,numExt,colonia,municipio,cp,email,numTel,curp,idcajero,pass,nombreest from persona natural join cajero natural join estado where curp='" + this.curp.getText() + "'";
/* 266 */       ResultSet rs = stmt.executeQuery(cadenasql);
/* 267 */       while (rs.next())
/*     */       {
/* 269 */         this.nombre.setText(rs.getString("nombre"));
/* 270 */         this.apPat.setText(rs.getString("apPat"));
/* 271 */         this.apMat.setText(rs.getString("apMat"));
/* 272 */         this.calle.setText(rs.getString("calle"));
/* 273 */         this.num.setText(rs.getString("numExt"));
/* 274 */         this.colonia.setText(rs.getString("colonia"));
/* 275 */         this.municipio.setText(rs.getString("municipio"));
/* 276 */         this.cp.setText(rs.getString("cp"));
/* 277 */         this.email.setText(rs.getString("email"));
/* 278 */         this.telefono.setText(rs.getString("numTel"));
/* 279 */         this.curp.setText(rs.getString("curp"));
/* 280 */         this.idcajero.setText(rs.getString("idcajero"));
/* 281 */         this.jComboBox1.setSelectedItem(rs.getString("nombreest"));
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 289 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void Modificarcaj()
/*     */   {
/* 297 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 301 */         new ModificarCajero().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
        public static ModificarAdmin getInstancia() {
        if (instancia == null) {
            instancia = new ModificarAdmin();
                        Modificarcaj();
            }
                else{
                    instancia.toFront();
                }
        return instancia;
    }

    public void Aceptar() {
          conexioninicio ci = new conexioninicio();
/* 231 */     Connection con = null;
/* 232 */     Connection con1 = null;
/*     */     try
/*     */     {
/* 235 */       Class.forName("org.gjt.mm.mysql.Driver");
/* 236 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 237 */       con1 = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 238 */       Statement stmt = con.createStatement();
/* 239 */       Statement stmts = con1.createStatement();
/* 240 */       String cadenasql = "UPDATE persona  SET nombre='" + this.nombre.getText().toUpperCase() + "'" + "," + "apPat=" + "'" + this.apPat.getText().toUpperCase() + "'" + "," + "apMat=" + "'" + this.apMat.getText().toUpperCase() + "'" + "," + "calle=" + "'" + this.calle.getText().toUpperCase() + "'" + "," + "colonia=" + "'" + this.colonia.getText().toUpperCase() + "'" + "," + "numExt=" + this.num.getText() + "," + "municipio=" + "'" + this.municipio.getText().toUpperCase() + "'" + "," + "numTel=" + "'" + this.telefono.getText() + "'" + "," + "cp=" + "'" + this.cp.getText() + "'," + "curp=" + "'" + this.curp.getText().toUpperCase() + "'," + "idestado=" + "'" + this.jComboBox1.getSelectedIndex() + "'," + "email=" + "'" + this.email.getText() + "' where curp = '" + this.curp.getText() + "'";
/*     */ 
/* 245 */       String cadenasql2 = "UPDATE cajero  SET idcajero='" + this.idcajero.getText() + "',curp=" + "'" + this.curp.getText().toUpperCase() + "' where curp = '" + this.curp.getText() + "'";
/*     */ 
/* 247 */       stmt.executeUpdate(cadenasql);
/* 248 */       stmts.executeUpdate(cadenasql2);
/*     */ 
/* 251 */       JOptionPane.showMessageDialog(this, "Actualizacion Exitosa");
/*     */     }
/*     */     catch (Exception e) {
/* 254 */       System.out.println(e.getMessage()); }
    }

    public void Cancelar() {
        instancia=null;
        dispose();
    }
 }


 