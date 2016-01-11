/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
          import FabricadeVentanas.Ventanas.Ventana;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
         public class MostrarAdmin extends JFrame implements Ventana
         {
           private static MostrarAdmin instancia = null;
           private Dimension dim;
           private JLabel jLabel1;
           private JMenu jMenu1;
           private JMenuBar jMenuBar1;
           private JScrollPane jScrollPane1;
           private JScrollPane jScrollPane2;
           private JTable tablasm;
/*     */   public MostrarAdmin()
/*     */   {
              
/*  29 */     initComponents();
/*  30 */     setSize(1300, 350);
/*  31 */     setLocationRelativeTo(null);
/*  32 */     setResizable(false);
              Aceptar();
           }
/*     */   private void initComponents()
/*     */   {
/*  95 */     this.jScrollPane2 = new JScrollPane();
/*  96 */     this.jScrollPane1 = new JScrollPane();
/*  97 */     this.tablasm = new JTable() {
/*     */       public boolean isCellEditable(int rowIndex, int colIndex) {
/*  99 */         return false;
/*     */       }
/*     */     };
/* 102 */     this.jLabel1 = new JLabel();
/* 103 */     this.jMenuBar1 = new JMenuBar();
/* 104 */     this.jMenu1 = new JMenu();
/*     */ 
/* 106 */     setDefaultCloseOperation(2);
/* 107 */     setTitle("Administrador");
/* 108 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 110 */     this.tablasm.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null, null, null, null } }, new String[] { "Curp", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Colonia", "Numero", "Municipio", "Email", "Fecha Nacimiento", "Nick", "Contraseña", "Fecha de registro" })
/*     */     {
/*     */       boolean[] canEdit;
/*     */ 
       @Override
       public boolean isCellEditable(int rowIndex, int columnIndex)
               {
/* 126 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/* 129 */     this.jScrollPane1.setViewportView(this.tablasm);
/*     */ 
/* 131 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(6, 0, 1250, 270));
/*     */ 
/* 133 */     this.jLabel1.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/findoMAdmin.png")));
/* 134 */     this.jLabel1.setText("jLabel1");
/* 135 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(0, 0, 1260, 600));
/*     */ 
/* 137 */     this.jMenu1.setText("Archivo");
/* 138 */     this.jMenuBar1.add(this.jMenu1);
/*     */ 
/* 140 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 142 */     pack();
/*     */   }
/*     */ 
/*     */   public static void MostrarPrincipalAdmin()
/*     */   {
/* 149 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 153 */         new MostrarAdmin().setVisible(true);
/*     */       }
/*     */     });
/*     */   }

 
             public static MostrarAdmin getInstancia() {
        if (instancia == null) {
            instancia = new MostrarAdmin();
                        MostrarPrincipalAdmin();
            }
                else{
                    instancia.toFront();
                }
        return instancia;
    }
/*     */

    public void Aceptar() {
        conexioninicio ci = new conexioninicio();
/*     */     try {
/*  35 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */     } catch (ClassNotFoundException ex) {
/*  37 */       Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  39 */     Connection con = null;
/*     */     try
/*     */     {
/*  43 */       con = ci.getConexion();
/*  44 */       DefaultTableModel modelo = new DefaultTableModel();
/*     */ 
/*  46 */       this.tablasm.setModel(modelo);
/*     */ 
/*  48 */       Statement stmt = con.createStatement();
/*     */ 
/*  50 */       ResultSet rs = stmt.executeQuery("Select curp as Curp,nombre as Nombre,apPat as 'Apellido Paterno' ,apMat as 'Apellido Materno',calle as Calle,colonia as Colonia,numExt as Numero,municipio as Municipio ,email as Email,idadmon as Nick,numTel as Telefono ,fechainicio AS 'Fecha Registro',nombreest  as Estado  from persona natural join admin natural join estado");
/*     */ 
/*  52 */       ResultSetMetaData rsMd = rs.getMetaData();
/*     */ 
/*  54 */       int cantidadColumnas = rsMd.getColumnCount();
/*     */ 
/*  56 */       for (int i = 1; i <= cantidadColumnas; ++i) {
/*  57 */         modelo.addColumn(rsMd.getColumnLabel(i));
/*     */       }
/*  59 */       while (rs.next()) {
/*  60 */         Object[] fila = new Object[cantidadColumnas];
/*  61 */         for (int i = 0; i < cantidadColumnas; ++i)
/*     */         {
/*  63 */           fila[i] = rs.getObject(i + 1);
/*     */         }
/*  65 */         modelo.addRow(fila);
/*     */       }
/*  67 */       rs.close();
/*  68 */       ci.cerrarConexxion();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  72 */       if (con == null)
/*     */         return;
/*     */       try {
/*  75 */         con.rollback();
/*     */       } catch (SQLException ex) {
/*  77 */         Logger.getLogger(AgregarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*  79 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
    }

    public void Cancelar() {
        this.dispose();
    }
 }

