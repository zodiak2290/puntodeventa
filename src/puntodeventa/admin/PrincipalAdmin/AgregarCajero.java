/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
import FabricadeVentanas.Ventanas.Ventana;
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
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class AgregarCajero extends JFrame implements Ventana{
            private static AgregarCajero instancia = null;
/*     */   private JTextField apMat;
/*     */   private JTextField apPat;
/*     */   private JTextField calle;
/*     */   private JTextField colonia;
/*     */   private JPasswordField contraseña1;
/*     */   private JPasswordField contraseña2;
/*     */   private JTextField cp;
/*     */   private JTextField curp;
/*     */   private JTextField email;
/*     */   private JTextField idamin;
/*     */   private JButton jButton1;
/*     */   private JComboBox jComboBox1;
/*     */   private JComboBox jComboBox2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel16;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JPanel jPanel1;
/*     */   private JTextField municipio;
/*     */   private JTextField nombre;
/*     */   private JTextField num;
/*     */   private JTextField telefono;
/*     */ 
/*     */   public AgregarCajero()
/*     */   {
/*  28 */     initComponents();
/*  29 */     conexioninicio ci = new conexioninicio();
/*  30 */     
/*  31 */     setSize(455, 500);
/*  32 */     setLocationRelativeTo(null);
/*  33 */     setResizable(false);
/*  34 */     this.jComboBox2.setVisible(false);
/*     */     try {
/*  36 */       Connection con = ci.getConexion();
/*     */ 
/*  38 */       Statement stmt = con.createStatement();
/*     */ 
/*  40 */       ResultSet rs = stmt.executeQuery("SELECT * FROM tienda.estado WHERE idestado>4;");
/*     */ 
/*  42 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  44 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  48 */       while (rs.next()) {
/*  49 */         Object[] fila = new Object[cantidadColumnas];
/*  50 */         for (int i = 1; i < cantidadColumnas; ++i) {
/*  51 */           this.jComboBox1.addItem(rs.getObject(i + 1));
/*  52 */           this.jComboBox2.addItem(rs.getObject(i));
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
/*     */   private void initComponents()
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
/*  78 */     this.jPanel1 = new JPanel();
/*  79 */     this.jLabel1 = new JLabel();
/*  80 */     this.jLabel2 = new JLabel();
/*  81 */     this.jLabel3 = new JLabel();
/*  82 */     this.jLabel4 = new JLabel();
/*  83 */     this.jLabel5 = new JLabel();
/*  84 */     this.jLabel7 = new JLabel();
/*  85 */     this.jLabel8 = new JLabel();
/*  86 */     this.jLabel9 = new JLabel();
/*  87 */     this.jLabel10 = new JLabel();
/*  88 */     this.jLabel11 = new JLabel();
/*  89 */     this.nombre = new JTextField();
/*  90 */     this.apPat = new JTextField();
/*  91 */     this.calle = new JTextField();
/*  92 */     this.num = new JTextField();
/*  93 */     this.colonia = new JTextField();
/*  94 */     this.municipio = new JTextField();
/*  95 */     this.jComboBox1 = new JComboBox();
/*  96 */     this.cp = new JTextField();
/*  97 */     this.email = new JTextField();
/*  98 */     this.telefono = new JTextField();
/*  99 */     this.jLabel6 = new JLabel();
/* 100 */     this.idamin = new JTextField();
/* 101 */     this.jLabel14 = new JLabel();
/* 102 */     this.curp = new JTextField();
/* 103 */     this.apMat = new JTextField();
/* 104 */     this.jLabel12 = new JLabel();
/* 105 */     this.contraseña1 = new JPasswordField();
/* 106 */     this.jLabel13 = new JLabel();
/* 107 */     this.contraseña2 = new JPasswordField();
/* 108 */     this.jButton1 = new JButton();
/* 109 */     this.jLabel16 = new JLabel();
/* 110 */     this.jComboBox2 = new JComboBox();
/* 111 */     this.jLabel15 = new JLabel();
/*     */ 
/* 113 */     setDefaultCloseOperation(2);
/* 114 */     setTitle("Administrador");
/*     */ 
/* 116 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/* 118 */     this.jLabel1.setText("Datos del cajero");
/* 119 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 10, -1, -1));
/*     */ 
/* 121 */     this.jLabel2.setText("Nombre(s)       *");
/* 122 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(10, 34, 79, -1));
/*     */ 
/* 124 */     this.jLabel3.setText("Apellidos        *");
/* 125 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(10, 65, 79, -1));
/*     */ 
/* 127 */     this.jLabel4.setText("Calle y numero");
/* 128 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(10, 91, 79, -1));
/*     */ 
/* 130 */     this.jLabel5.setText("Colonia");
/* 131 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(10, 119, -1, -1));
/*     */ 
/* 133 */     this.jLabel7.setText("Municipio");
/* 134 */     this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(10, 156, -1, -1));
/*     */ 
/* 136 */     this.jLabel8.setText("Estado");
/* 137 */     this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(10, 191, -1, -1));
/*     */ 
/* 139 */     this.jLabel9.setText("Codigo Postal");
/* 140 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(10, 243, -1, -1));
/*     */ 
/* 142 */     this.jLabel10.setText("Email");
/* 143 */     this.jPanel1.add(this.jLabel10, new AbsoluteConstraints(10, 276, -1, -1));
/*     */ 
/* 145 */     this.jLabel11.setText("Telefono");
/* 146 */     this.jPanel1.add(this.jLabel11, new AbsoluteConstraints(10, 302, -1, -1));
/* 147 */     this.jPanel1.add(this.nombre, new AbsoluteConstraints(107, 31, 218, -1));
/* 148 */     this.jPanel1.add(this.apPat, new AbsoluteConstraints(107, 62, 105, -1));
/* 149 */     this.jPanel1.add(this.calle, new AbsoluteConstraints(107, 88, 218, -1));
/* 150 */     this.jPanel1.add(this.num, new AbsoluteConstraints(331, 88, 34, -1));
/* 151 */     this.jPanel1.add(this.colonia, new AbsoluteConstraints(107, 119, 218, -1));
/* 152 */     this.jPanel1.add(this.municipio, new AbsoluteConstraints(107, 150, 218, -1));
/*     */ 
/* 154 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[0]));
/* 155 */     this.jComboBox1.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 157 */         AgregarCajero.this.jComboBox1ItemStateChanged(evt);
/*     */       }
/*     */     });
/* 160 */     this.jPanel1.add(this.jComboBox1, new AbsoluteConstraints(107, 188, -1, -1));
/* 161 */     this.jPanel1.add(this.cp, new AbsoluteConstraints(107, 240, 76, -1));
/* 162 */     this.jPanel1.add(this.email, new AbsoluteConstraints(107, 273, 218, -1));
/* 163 */     this.jPanel1.add(this.telefono, new AbsoluteConstraints(107, 299, 218, -1));
/*     */ 
/* 165 */     this.jLabel6.setText("ID Cajero   *");
/* 166 */     this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(10, 370, -1, -1));
/* 167 */     this.jPanel1.add(this.idamin, new AbsoluteConstraints(115, 364, 210, -1));
/*     */ 
/* 169 */     this.jLabel14.setText("Curp");
/* 170 */     this.jPanel1.add(this.jLabel14, new AbsoluteConstraints(10, 333, -1, -1));
/* 171 */     this.jPanel1.add(this.curp, new AbsoluteConstraints(110, 330, 218, -1));
/* 172 */     this.jPanel1.add(this.apMat, new AbsoluteConstraints(221, 62, 104, -1));
/*     */ 
/* 174 */     this.jLabel12.setText("Contraseña           *");
/* 175 */     this.jPanel1.add(this.jLabel12, new AbsoluteConstraints(10, 398, -1, -1));
/* 176 */     this.jPanel1.add(this.contraseña1, new AbsoluteConstraints(140, 400, 165, -1));
/*     */ 
/* 178 */     this.jLabel13.setText("Repetir Contraseña  *");
/* 179 */     this.jPanel1.add(this.jLabel13, new AbsoluteConstraints(10, 429, -1, -1));
/* 180 */     this.jPanel1.add(this.contraseña2, new AbsoluteConstraints(140, 430, 165, -1));
/*     */ 
/* 182 */     this.jButton1.setText("Agregar");
/* 183 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 185 */         AgregarCajero.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 188 */     this.jPanel1.add(this.jButton1, new AbsoluteConstraints(350, 430, -1, -1));
/*     */ 
/* 190 */     this.jLabel16.setText("jLabel16");
/* 191 */     this.jPanel1.add(this.jLabel16, new AbsoluteConstraints(120, 330, 200, -1));
/*     */ 
/* 193 */     this.jComboBox2.setModel(new DefaultComboBoxModel(new String[0]));
/* 194 */     this.jComboBox2.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 196 */         AgregarCajero.this.jComboBox2ItemStateChanged(evt);
/*     */       }
/*     */     });
/* 199 */     this.jPanel1.add(this.jComboBox2, new AbsoluteConstraints(107, 188, -1, -1));
/*     */ 
/* 201 */     this.jLabel15.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/FondoCaj.png")));
/* 202 */     this.jLabel15.setText("jLabel15");
/* 203 */     this.jPanel1.add(this.jLabel15, new AbsoluteConstraints(0, 0, 450, 480));
/*     */ 
/* 205 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 206 */     getContentPane().setLayout(layout);
/* 207 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, 450, 32767));
/*     */ 
/* 211 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 480, 32767));
/*     */ 
/* 216 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 220 */     Aceptar();
/*     */   }
/*     */ 
/*     */   private void jComboBox1ItemStateChanged(ItemEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jComboBox2ItemStateChanged(ItemEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private static void MostrarPirncipalcajero()
/*     */   {
/* 282 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 286 */         new AgregarCajero().setVisible(true);
/*     */       }
/*     */     });
/*     */   }

         public static AgregarCajero getInstancia() {
		if (instancia == null) {
			instancia = new AgregarCajero();
                        MostrarPirncipalcajero();
			}
                else{
                    instancia.toFront();
                }
		return instancia;
	}

    public void Aceptar() {
        conexioninicio ci = new conexioninicio();
/*     */     try {
/* 222 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/* 224 */       Logger.getLogger(AgregarCajero.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 226 */     Connection con = null;
/*     */     try
/*     */     {
/* 230 */       if ((this.curp.getText().length() > 0) && (this.idamin.getText().length() > 0) && (this.nombre.getText().length() > 0) && (this.apPat.getText().length() > 0))
/*     */       {
/* 232 */         if ((this.contraseña1.getText().equals(this.contraseña2.getText())) && (this.contraseña1.getText().length() > 0))
/*     */         {
/* 234 */           con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 235 */           con.setAutoCommit(false);
/* 236 */           this.jComboBox2.setSelectedIndex(this.jComboBox1.getSelectedIndex());
/* 237 */           String cadenasql = "insert into tienda.persona(curp ,nombre ,apPat,apMat ,calle,colonia,numExt,municipio,idestado,cp ,email ,numTel ) values('" + this.curp.getText().toUpperCase() + "','" + this.nombre.getText().toUpperCase() + "','" + this.apPat.getText().toUpperCase() + "','" + this.apMat.getText().toUpperCase() + "','" + this.calle.getText().toUpperCase() + "','" + this.colonia.getText().toUpperCase() + "','" + this.num.getText().toUpperCase() + "','" + this.municipio.getText().toUpperCase() + "','" + this.jComboBox2.getSelectedItem() + "','" + this.cp.getText() + "','" + this.email.getText() + "','" + this.telefono.getText() + "')";
/* 238 */           Statement stmt = con.createStatement();
/* 239 */           stmt.executeUpdate(cadenasql);
/* 240 */           String cadenasql2 = "insert into tienda.cajero(idcajero ,curp ,pass,fechaini) values('" + this.idamin.getText() + "','" + this.curp.getText().toUpperCase() + "','" + this.contraseña1.getText() + "'," + "CURRENT_DATE)";
/* 241 */           stmt.executeUpdate(cadenasql2);
/* 242 */           con.commit();
/* 243 */           JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
/*     */         }
/*     */         else {
/* 246 */           JOptionPane.showMessageDialog(null, "ESCRIBA LA CONTRASEÑA EN AMBOS CAMPOS ", "Error", 0);
/*     */         }
/*     */       }
/*     */       else {
/* 250 */         JOptionPane.showMessageDialog(null, "Hay campos indispensables para registrar al usuario", "Error", 0);
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 255 */       if (con == null)
/*     */         return;
/*     */       try {
/* 258 */         con.rollback();
/*     */       } catch (SQLException ex) {
/* 260 */         Logger.getLogger(AgregarCajero.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 262 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
    }

    public void Cancelar() {
        dispose();
    }
 }

