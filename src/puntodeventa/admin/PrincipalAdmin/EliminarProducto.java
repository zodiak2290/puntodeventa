/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
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
/*     */ import javax.swing.ImageIcon;
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
/*     */ public class EliminarProducto extends JFrame
/*     */ {
/*  26 */   ArrayList a = new ArrayList();
/*  27 */   ArrayList mar = new ArrayList();
/*     */   private JTextField cb;
/*     */   private JButton eliminar;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTable tablasm;
/*     */ 
/*     */   public EliminarProducto()
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
/*  56 */     this.jLabel2 = new JLabel();
/*     */ 
/*  58 */     setDefaultCloseOperation(3);
/*  59 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/*  61 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/*  63 */     this.eliminar.setText("Eliminar");
/*  64 */     this.eliminar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  66 */         EliminarProducto.this.eliminarActionPerformed(evt);
/*     */       }
/*     */     });
/*  69 */     this.jPanel1.add(this.eliminar, new AbsoluteConstraints(430, 40, -1, -1));
/*  70 */     this.jPanel1.add(this.cb, new AbsoluteConstraints(140, 40, 166, -1));
/*     */ 
/*  72 */     this.jButton3.setText("Cancelar");
/*  73 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  75 */         EliminarProducto.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/*  78 */     this.jPanel1.add(this.jButton3, new AbsoluteConstraints(260, 130, 100, -1));
/*     */ 
/*  80 */     this.jButton4.setText("Buscar");
/*  81 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  83 */         EliminarProducto.this.jButton4ActionPerformed(evt);
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
/* 100 */     this.jLabel1.setText("Codigo de barras");
/* 101 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(40, 40, -1, -1));
/*     */ 
/* 103 */     this.jLabel2.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/deleteprod.png")));
/* 104 */     this.jLabel2.setText("jLabel2");
/* 105 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(0, 0, 690, 160));
/*     */ 
/* 107 */     getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 690, 160));
/*     */ 
/* 109 */     pack();
/*     */   }
/*     */ 
/*     */   private void eliminarActionPerformed(ActionEvent evt)
/*     */   {
/* 115 */     if (this.cb.getText().length() > 0)
/*     */     {
/*     */       try
/*     */       {
/* 120 */         int s = JOptionPane.showConfirmDialog(this, "Eliminar el producto?,Estac accion eliminara el historial de ventas y compras del producto", "Confirme", 0, 3);
/* 121 */         if (s == 0)
/*     */         {
/* 125 */           if (validarUsuario(this.cb.getText()))
/*     */           {
/*     */             try
/*     */             {
/* 129 */               conexioninicio ci2 = new conexioninicio();
/* 130 */               Class.forName("org.gjt.mm.mysql.Driver");
/* 131 */               Connection con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 132 */               Connection con1 = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/* 133 */               Statement stmt = con.createStatement();
/* 134 */               Statement stmts = con1.createStatement();
/* 135 */               String cadenasql = "DELETE FROM articulo WHERE codigobarras='" + this.cb.getText() + "'";
/* 136 */               String cadenasql2 = "DELETE FROM almacen WHERE codigobarras='" + this.cb.getText() + "'";
/* 137 */               stmts.executeUpdate(cadenasql2);
/* 138 */               stmt.executeUpdate(cadenasql);
/* 139 */               JOptionPane.showMessageDialog(null, "Eliminado");
/* 140 */               this.tablasm.setVisible(false);
/*     */             }
/*     */             catch (Exception e)
/*     */             {
/* 144 */               System.out.println("Consulte detalles del sistema" + e.getMessage());
/*     */             }
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 150 */             JOptionPane.showMessageDialog(null, "El codigo no existe");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 160 */         System.out.println(e.getMessage());
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 166 */       JOptionPane.showMessageDialog(null, "Ingrese codigo de barras.");
/*     */     }
/*     */   }
/*     */ 
/*     */   boolean validarUsuario(String elUsr)
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 176 */       conexioninicio ci2 = new conexioninicio();
/* 177 */       Connection con = DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
/*     */ 
/* 180 */       Statement instruccionSQL = con.createStatement();
/* 181 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM articulo WHERE codigobarras='" + elUsr + "'");
/*     */ 
/* 184 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 190 */     return false;
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 195 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 200 */     if (this.cb.getText().length() > 0)
/*     */     {
/* 202 */       conexioninicio ci = new conexioninicio();
/*     */       try {
/* 204 */         Class.forName("org.gjt.mm.mysql.Driver");
/*     */       } catch (ClassNotFoundException ex) {
/* 206 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 208 */       Connection con = null;
/*     */       try
/*     */       {
/* 212 */         con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/* 213 */         DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/* 215 */         this.tablasm.setModel(modelo);
/*     */ 
/* 217 */         Statement stmt = con.createStatement();
/*     */ 
/* 219 */         ResultSet rs = stmt.executeQuery("SELECT nombredep as Departamento,nombremar as Marca,codigobarras as Codigo,nombreart Articulo ,cantidad as Existencia,descripcion as Descripcion FROM articulo natural join almacen natural join departamento natural join marca where codigobarras= '" + this.cb.getText() + "'");
/* 220 */         ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/* 222 */         int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/* 224 */         for (int i = 1; i <= cantidadColumnas; ++i) {
/* 225 */           modelo.addColumn(rsMd.getColumnLabel(i));
/*     */         }
/* 227 */         while (rs.next()) {
/* 228 */           Object[] fila = new Object[cantidadColumnas];
/* 229 */           for (int i = 0; i < cantidadColumnas; ++i)
/*     */           {
/* 231 */             fila[i] = rs.getObject(i + 1);
/*     */           }
/* 233 */           modelo.addRow(fila);
/*     */         }
/* 235 */         if (!(rs.first())) JOptionPane.showMessageDialog(null, "El Codigo no existe", "Error", 0);
/*     */ 
/* 237 */         rs.close();
/* 238 */         con.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 242 */         if (con != null)
/*     */         {
/*     */           try {
/* 245 */             con.rollback();
/*     */           } catch (SQLException ex) {
/* 247 */             Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/* 249 */           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 254 */       this.tablasm.setVisible(true);
/*     */     }
/*     */     else
/*     */     {
/* 259 */       JOptionPane.showMessageDialog(null, "Ingrese codigo de barras.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void eliminar()
/*     */   {
/* 268 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 270 */         new EliminarProducto().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.EliminarProducto
 * JD-Core Version:    0.5.3
 */