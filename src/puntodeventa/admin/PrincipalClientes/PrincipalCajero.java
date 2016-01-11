/*     */ package puntodeventa.admin.PrincipalClientes;
/*     */ 
import VentanaPrincipalPrincipal.Principal;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
import puntodeventa.admin.PrincipalAdmin.PrincipalAdmin;
/*     */ import puntodeventa.admin.PrincipalAdmin.Ventas;
/*     */ import puntodeventa.inicio.EleccionLogin;
/*     */ 
/*     */ public class PrincipalCajero extends JFrame implements Principal
/*     */ {
/*     */   private Dimension dim;
/*     */   String elUsr,elPw;
/*     */   private JMenu jMenu2;
/*     */   private JMenu jMenu7;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JMenuItem jMenuItem1;
/*     */   private JMenuItem jMenuItem2;
/*     */   private JMenuItem jMenuItem7;
/*     */ 
/*     */   public PrincipalCajero()
/*     */   {
/*  30 */     setUndecorated(true);
/*  31 */     initComponents();
/*     */ 
/*  35 */     setSize(390, 145);
/*  36 */     setResizable(false);
/*  37 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */  public void recibirUsuario(String Useri,String pass)
/*     */   {
              this.elUsr = Useri;
              this.elPw=pass;
/*     */   }
/*     */ 
/*     */   public String EnviarUsuario() {
/*  46 */     return elUsr;
/*     */   }
/*     */ 
/*     */   public void initComponents()
/*     */   {
/*  58 */     this.jMenuBar1 = new JMenuBar();
/*  59 */     this.jMenu7 = new JMenu();
/*  60 */     this.jMenuItem7 = new JMenuItem();
/*  61 */     this.jMenu2 = new JMenu();
/*  62 */     this.jMenuItem1 = new JMenuItem();
/*  63 */     this.jMenuItem2 = new JMenuItem();
/*     */ 
/*  65 */     setDefaultCloseOperation(3);
/*  66 */     setTitle(EnviarUsuario());
/*     */ 
/*  68 */     this.jMenuBar1.setBackground(new Color(204, 0, 255));
/*  69 */     this.jMenuBar1.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 204), 7));
/*     */ 
/*  71 */     this.jMenu7.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/ventas.png")));
/*  72 */     this.jMenu7.setText("Ventas");
/*     */ 
/*  74 */     this.jMenuItem7.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/buy.png")));
/*  75 */     this.jMenuItem7.setText("Realizar Ventas");
/*  76 */     this.jMenuItem7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  78 */         PrincipalCajero.this.jMenuItem7ActionPerformed(evt);
/*     */       }
/*     */     });
/*  81 */     this.jMenu7.add(this.jMenuItem7);
/*     */ 
/*  83 */     this.jMenuBar1.add(this.jMenu7);
/*     */ 
/*  85 */     this.jMenu2.setBackground(new Color(0, 51, 255));
/*  86 */     this.jMenu2.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/login.png")));
/*  87 */     this.jMenu2.setText("Sesion");
/*     */ 
/*  89 */     this.jMenuItem1.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/cambiarsesion.png")));
/*  90 */     this.jMenuItem1.setText("Cerrar Sesion");
/*  91 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  93 */         PrincipalCajero.this.jMenuItem1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  96 */     this.jMenu2.add(this.jMenuItem1);
/*     */ 
/*  98 */     this.jMenuItem2.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/cerrarsesion.png")));
/*  99 */     this.jMenuItem2.setText("Cerrar");
/* 100 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 102 */         PrincipalCajero.this.jMenuItem2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 105 */     this.jMenu2.add(this.jMenuItem2);
/*     */ 
/* 107 */     this.jMenuBar1.add(this.jMenu2);
/*     */ 
/* 109 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 111 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 112 */     getContentPane().setLayout(layout);
/* 113 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 373, 32767));
/*     */ 
/* 117 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */ 
/* 122 */     pack();
/*     */   }
/*     */ 
/*     */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 126 */     EleccionLogin el = new EleccionLogin();
/* 127 */     el.elegir();
/* 128 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 132 */     int s = JOptionPane.showConfirmDialog(null, "Realmente desea salir de VentSoft", "Confirmar salida", 0, 3);
/* 133 */     if (s != 0)
/*     */       return;
/* 135 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   private void jMenuItem7ActionPerformed(ActionEvent evt)
/*     */   {
/* 140 */     Ventas v = new Ventas();
/* 141 */     v.recibir(elUsr);
/* 142 */     v.ventas();
/*     */   }
/*     */ 
/*     */   boolean validarUsuario()
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 155 */       Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost/tienda", "root", "");
/*     */ 
/* 157 */       Statement instruccionSQL = unaConexion.createStatement();
/* 158 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM cajero WHERE idcajero='" + elUsr + "' AND pass='" + elPw + "'");
/*     */ 
/* 161 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 167 */     return false;
/*     */   }
/*     */ 
/*     */   public void MostrarPirncipal()
/*     */   {
/* 175 */     EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 179 */         new PrincipalCajero().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */

    public boolean correcto() {
        try {
        return validarUsuario();
    } catch (IOException ex) {
        Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }
 }

