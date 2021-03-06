/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrincipalCliente.java
 *
 * Created on 17-ago-2013, 19:22:51
 */

package puntodeventa.admin.PrincipalAdmin;
import java.awt.Dimension;
import java.io.IOException;
import puntodeventa.inicio.conexioninicio;
import java.sql.*;
import javax.swing.JOptionPane;
import puntodeventa.inicio.EleccionLogin;


/**
 *
 * @author alberto
 */
public class PrincipalAdmin extends javax.swing.JFrame {
 private Dimension dim;
 static String User;
    /** Creates new form PrincipalCliente */
    public PrincipalAdmin() {
         setUndecorated(true);
        initComponents();
        //this.makeWindowsOpacity(this, .7f);
        //dim=super.getToolkit().getScreenSize();//ajusta ventana al tamaño del monitor
        //super.setSize(dim);//ajusta ventana al tamaño del monitor
        this.setSize(770, 145);
        this.setResizable(false);
        this.setLocationRelativeTo(null); //Centra la ventana Splash
       
    }
    public void recibirUsuario(String Useri)
    {
        User=Useri;
    }
    public String EnviarUsuario()
    {
        return User;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(EnviarUsuario());

        jMenuBar1.setBackground(new java.awt.Color(204, 0, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204), 7));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/file.png"))); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/card-file-icon.png"))); // NOI18N
        jMenu3.setText("Registros");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/admon.png"))); // NOI18N
        jMenu4.setText("Aministradores");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/add.png"))); // NOI18N
        jMenuItem3.setText("Nuevo Administrador");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/delete.png"))); // NOI18N
        jMenuItem4.setText("Darse de baja ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/edit.png"))); // NOI18N
        jMenuItem5.setText("Modificar mis datos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/list.png"))); // NOI18N
        jMenuItem6.setText("Lista de administradores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenu3.add(jMenu4);

        jMenu5.setText("Cajeros");
        jMenu3.add(jMenu5);

        jMenu6.setText("Productos");
        jMenu3.add(jMenu6);

        jMenuBar1.add(jMenu3);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/ventas.png"))); // NOI18N
        jMenu7.setText("Ventas");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/buy.png"))); // NOI18N
        jMenuItem7.setText("Realizar Ventas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/ganancias.png"))); // NOI18N
        jMenuItem8.setText("Ganancias");
        jMenu7.add(jMenuItem8);

        jMenuBar1.add(jMenu7);

        jMenu2.setBackground(new java.awt.Color(0, 51, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/login.png"))); // NOI18N
        jMenu2.setText("Sesion");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/cambiarsesion.png"))); // NOI18N
        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/cerrarsesion.png"))); // NOI18N
        jMenuItem2.setText("Cerrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    EleccionLogin el=new EleccionLogin();
    el.elegir();
    dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
   int s=JOptionPane.showConfirmDialog(null, "Realmente desea salir de Hola Swing?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
   if (s==0)
   {
      System.exit(0);
   }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
  AgregarAdministrador aa=new AgregarAdministrador();
  aa.MostrarPirncipaladmin();
  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ModificarAdmin aa=new ModificarAdmin();
        aa.recibirUsuario(User);
 aa.MostrarPirncipaladmin();
 
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
  MostrarAdmin ma=new MostrarAdmin();
  ma.MostrarPirncipaladmin();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
//Ventas v=new Ventas();
//v.MostrarPirncipaladmin();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
  


int s=JOptionPane.showConfirmDialog(this, "Por su seguridad para darse de baja son requeridos algunos datos,Al proporciona tales datos usted quedara dado de baja automaticamente del sistema", "La aplicacion se cerrara al terminar el proceso de baja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 if (s==0)
   {
     String curp=JOptionPane.showInputDialog("Profecor Ingrese su CURP");
String idadmin=JOptionPane.showInputDialog("Por favor Ingrese su ID de administrador");
String contraseña=JOptionPane.showInputDialog("ingrese su contraseña ");
System.out.println("admin"+ idadmin);
System.out.println("pas " +contraseña);
System.out.println("crup "+ curp);
System.out.println("user "+ User);

try
                {
                    //chekar si el usuario escrbio el nombre de usuario y pw
                    if (idadmin.length() > 0 && contraseña.length() > 0 && curp.length() > 0 )
                    {
                        // Si el usuario si fue validado correctamente
                        
                        if( validarUsuario( idadmin, contraseña ) )    //enviar datos a validar
                        {
                            Connection con=null;
Connection con1=null;
try{
    conexioninicio ci2 = new conexioninicio();
           Class.forName("org.gjt.mm.mysql.Driver");
           con= DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
           con1= DriverManager.getConnection(ci2.getURl(), ci2.getLogin(), ci2.getPassword());
          Statement stmt = con.createStatement();
           Statement stmts = con1.createStatement();
          String cadenasql = "DELETE FROM persona WHERE curp="+ "'"+curp+"'";
       String cadenasql2 = "DELETE FROM admin WHERE idadmon="+ "'"+idadmin+"' and contraseña='"+ contraseña +"'";
       stmts.executeUpdate(cadenasql2);
        stmt.executeUpdate(cadenasql);
        System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println( "MENSO" + e.getMessage());
           
        }

                            

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contrasenia no son validos.");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Debe proporcionar los datos requeridos.\n" +
                            "NO deje campos vacios");
                    }

                } catch (Exception e)
                {
                }

    }// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed
boolean validarUsuario(String elUsr, String elPw)  throws IOException
    {
        try
        {
            //nombre de la BD: bdlogin
             //nombre de la tabla: usuarios
             //                             id      integer auto_increment not null     <--llave primaria
             //                   campos:    usuario    char(25)
             //                              password char(50)

            Connection unaConexion  = DriverManager.getConnection ("jdbc:mysql://localhost/tienda","root", "");
            // Preparamos la consulta
            Statement instruccionSQL = unaConexion.createStatement();
            ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM admin WHERE idadmon='"+elUsr+"' AND contraseña='"+ elPw+"'");

            if( resultadosConsulta.first() )        // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
                return true;        //usuario validado correctamente
            else
                return false;        //usuario validado incorrectamente

        } catch (Exception e)
        {
            return false;
        }

    }
    /**
    * @param args the command line arguments
    */
    public  void MostrarPirncipaladmin() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new PrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables

}
