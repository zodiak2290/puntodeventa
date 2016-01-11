           package puntodeventa.admin.PrincipalAdmin;
/*     */ 
import FabricadeVentanas.Ventanas.Ventana;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class MostrarCajero extends JFrame implements Ventana
         {
           private static MostrarCajero instancia = null;
/*     */   private Dimension dim;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JTable tablasm;
/*     */ 
/*     */   public MostrarCajero()
/*     */   {
/*  30 */     initComponents();
/*  31 */     setSize(1300, 350);
/*  32 */     setLocationRelativeTo(null);
/*  33 */     setResizable(false);
/*  34 */     Aceptar();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  96 */     this.jScrollPane2 = new JScrollPane();
/*  97 */     this.jScrollPane1 = new JScrollPane();
/*  98 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/* 100 */         return false;
/*     */       }
/*     */     };
/* 103 */     this.jMenuBar1 = new JMenuBar();
/*     */ 
/* 105 */     setDefaultCloseOperation(2);
/* 106 */     setTitle("Administrador");
/* 107 */     setBackground(new Color(255, 255, 255));
/* 108 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 110 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null } }, new String[] { "Curp", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Colonia", "Numero", "Municipio", "Email", "Fecha Nacimiento", "Nick", "Contraseña", "Fecha de registro" })
/*     */     {
/*     */       boolean[] canEdit;
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */       {
/* 126 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 129 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 131 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 1240, 210));
/* 132 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 134 */     pack();
/*     */   }
/*     */ 
/*     */   private static void MostrarLista()
/*     */   {
/* 141 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 145 */         new MostrarCajero().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
                  public static MostrarCajero getInstancia() {
        if (instancia == null) {
            instancia = new MostrarCajero();
                        MostrarLista();
            }
                else{
                    instancia.toFront();
                }
        return instancia;
    }

    public void Aceptar() {
        conexioninicio ci = new conexioninicio();
/*     */     try {
/*  36 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  38 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  40 */     Connection con = null;
/*     */     try
/*     */     {
/*  44 */       con = ci.getConexion();
/*  45 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/*  47 */       this.tablasm.setModel(modelo);
/*     */ 
/*  49 */       Statement stmt = con.createStatement();
/*     */ 
/*  51 */       ResultSet rs = stmt.executeQuery("Select curp as Curp,nombre as Nombre,apPat as 'Apellido Paterno' ,apMat as 'Apellido Materno',calle as Calle,colonia as Colonia,numExt as Numero,municipio as Municipio ,email as Email,idcajero as Nick,numTel as Telefono ,fechaini AS 'Fecha Registro',nombreest  as Estado  from persona natural join cajero natural join estado");
/*     */ 
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
/*  69 */       ci.cerrarConexxion();
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
    }

    public void Cancelar() {
        instancia=null;
        dispose();
    }
 }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.MostrarCajero
 * JD-Core Version:    0.5.3
 */