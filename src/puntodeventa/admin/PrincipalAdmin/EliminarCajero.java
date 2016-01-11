/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class EliminarCajero extends JFrame
/*     */ {
/*  26 */   ArrayList a = new ArrayList();
/*  27 */   ArrayList mar = new ArrayList();
/*     */   private JTextField cb;
/*     */   private JButton eliminar;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTable tablasm;
/*     */ 
/*     */   public EliminarCajero()
/*     */   {
/*  30 */     setUndecorated(true);
/*  31 */     initComponents();
/*  32 */     setSize(680, 160);
/*  33 */     setResizable(false);
/*  34 */     setLocationRelativeTo(null);
/*  35 */     getRootPane().setDefaultButton(this.eliminar);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  48 */     this.jPanel1 = new JPanel();
/*  49 */     this.eliminar = new JButton();
/*  50 */     this.cb = new JTextField();
/*  51 */     this.jButton3 = new JButton();
/*  52 */     this.jButton4 = new JButton();
/*  53 */     this.jScrollPane1 = new JScrollPane();
/*  54 */     this.tablasm = new JTable();
/*  55 */     this.jLabel1 = new JLabel();
/*     */ 
/*  57 */     setDefaultCloseOperation(3);
/*  58 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/*  60 */     this.jPanel1.setBackground(new Color(255, 0, 51));
/*  61 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/*  63 */     this.eliminar.setText("Eliminar");
/*  64 */     this.eliminar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  66 */         EliminarCajero.this.eliminarActionPerformed(evt);
/*     */       }
/*     */     });
/*  69 */     this.jPanel1.add(this.eliminar, new AbsoluteConstraints(430, 40, -1, -1));
/*  70 */     this.jPanel1.add(this.cb, new AbsoluteConstraints(140, 40, 166, -1));
/*     */ 
/*  72 */     this.jButton3.setText("Cancelar");
/*  73 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  75 */         EliminarCajero.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/*  78 */     this.jPanel1.add(this.jButton3, new AbsoluteConstraints(260, 130, 100, -1));
/*     */ 
/*  80 */     this.jButton4.setText("Buscar");
/*  81 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  83 */         EliminarCajero.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/*  86 */     this.jPanel1.add(this.jButton4, new AbsoluteConstraints(330, 40, -1, -1));
/*     */ 
/*  88 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null } }, new String[] { "Departamento", "Marca", "Codigo", "Articulo", "Existencia", "Descripcion" }));
/*     */ 
/*  96 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/*  98 */     this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(20, 70, 650, 50));
/*     */ 
/* 100 */     this.jLabel1.setText("Curp");
/* 101 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(40, 40, -1, -1));
/*     */ 
/* 103 */     getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 690, 160));
/*     */ 
/* 105 */     pack();
/*     */   }
/*     */ 
/*     */   private void eliminarActionPerformed(ActionEvent evt)
/*     */   {
/* 111 */     if (this.cb.getText().length() > 0)
/*     */     {
/*     */       try
/*     */       {
/* 116 */         int s = JOptionPane.showConfirmDialog(this, "Eliminar cajero?", "Confirme", 0, 3);
/* 117 */         if (s == 0)
/*     */         {
/* 121 */           if (validarUsuario(this.cb.getText()))
/*     */           {
/*     */             try
/*     */             {
/* 125 */               conexioninicio ci2 = new conexioninicio();
/* 126 */               Class.forName("org.gjt.mm.mysql.Driver");
/* 127 */               Connection con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 128 */               Connection con1 = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 129 */               Statement stmt = con.createStatement();
/* 130 */               Statement stmts = con1.createStatement();
/* 131 */               String cadenasql = "DELETE FROM persona WHERE curp='" + this.cb.getText() + "'";
/* 132 */               String cadenasql2 = "DELETE FROM cajero WHERE curp='" + this.cb.getText() + "'";
/* 133 */               stmts.executeUpdate(cadenasql2);
/* 134 */               stmt.executeUpdate(cadenasql);
/* 135 */               JOptionPane.showMessageDialog(null, "Eliminado");
/* 136 */               this.tablasm.setVisible(false);
/*     */             }
/*     */             catch (Exception e)
/*     */             {
/* 140 */               System.out.println("Consulte detalles del sistema" + e.getMessage());
/*     */             }
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 146 */             JOptionPane.showMessageDialog(null, "verifique curp");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 156 */         System.out.println(e.getMessage());
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 162 */       JOptionPane.showMessageDialog(null, "Ingrese curp.");
/*     */     }
/*     */   }
/*     */ 
/*     */   boolean validarUsuario(String elUsr)
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 172 */       conexioninicio ci2 = new conexioninicio();
/* 173 */       Connection con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/*     */ 
/* 176 */       Statement instruccionSQL = con.createStatement();
/* 177 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM persona WHERE curp='" + elUsr + "'");
/*     */ 
/* 180 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 191 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 196 */     if (this.cb.getText().length() > 0)
/*     */     {
/* 198 */       conexioninicio ci = new conexioninicio();
/*     */       try {
/* 200 */         Class.forName("org.gjt.mm.mysql.Driver");
/*     */       } catch (ClassNotFoundException ex) {
/* 202 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 204 */       Connection con = null;
/*     */       try
/*     */       {
/* 208 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 209 */         DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 211 */         this.tablasm.setModel(modelo);
/*     */ 
/* 213 */         Statement stmt = con.createStatement();
/*     */ 
/* 215 */         ResultSet rs = stmt.executeQuery("SELECT nombre as Nombre,apPat as Apellido,idcajero as Nicks FROM persona natural join cajero where curp= '" + this.cb.getText() + "'");
/* 216 */         ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 218 */         int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 220 */         for (int i = 1; i <= cantidadColumnas; ++i) {
/* 221 */           modelo.addColumn(rsMd.getColumnLabel(i));
/*     */         }
/* 223 */         while (rs.next()) {
/* 224 */           Object[] fila = new Object[cantidadColumnas];
/* 225 */           for (int i = 0; i < cantidadColumnas; ++i)
/*     */           {
/* 227 */             fila[i] = rs.getObject(i + 1);
/*     */           }
/* 229 */           modelo.addRow(fila);
/*     */         }
/* 231 */         if (!(rs.first())) JOptionPane.showMessageDialog(null, "Verifique curp", "Error", 0);
/*     */ 
/* 233 */         rs.close();
/* 234 */         con.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 238 */         if (con != null)
/*     */         {
/*     */           try {
/* 241 */             con.rollback();
/*     */           } catch (SQLException ex) {
/* 243 */             Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/* 245 */           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 255 */       JOptionPane.showMessageDialog(null, "Ingrese curp.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void eliminar()
/*     */   {
/* 264 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 266 */         new EliminarCajero().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.EliminarCajero
 * JD-Core Version:    0.5.3
 */