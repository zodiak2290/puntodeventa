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
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


import puntodeventa.inicio.conexioninicio;
/**
 *
 * @author alberto
 */
public class CambiarContraseña extends javax.swing.JFrame {
static String User;
    /** Creates new form PrincipalCliente */
    public CambiarContraseña() {
        initComponents();
   
        this.setLocationRelativeTo(null); //Centra la ventana Splash
       
    }
    public void recibirUsuario(String Useri)
    {
        User=Useri;
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        pass3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Contraseña Actual");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        jLabel2.setText("Nueva Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, -1));

        jLabel3.setText("Repita su nueva Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, -1, -1));
        getContentPane().add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 27, 144, -1));
        getContentPane().add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 74, 144, -1));
        getContentPane().add(pass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 120, 144, -1));

        jButton1.setText("Cambiar Contraseña");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 162, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/admin/images/fondoMP.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 200));
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 conexioninicio ci = new conexioninicio();
  Connection con1=null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");  
           con1= DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
 
          

if(  pass2.getText().equals(pass3.getText()))
{ 
    Statement stmts=con1.createStatement();
     String cadenasql2 = "UPDATE tienda.admin set contraseña ='" + pass2.getText()+ "'  where admin.idadmon ='" + User  +"' and contraseña='"+  pass1.getText() +"'";
        stmts.executeUpdate(cadenasql2);
        JOptionPane.showMessageDialog(this,"Su Contraseña ha sido cambiada con exito");
       dispose();
}
 else
{
   System.out.println("error la contraseña no es la indicada  o  los campos de nueva cntraseña no coiciden");
 }
}



        catch(Exception e)
        {
            System.out.println("error null??"+ e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public  void MostrarPirncipaladmin() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new CambiarContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JPasswordField pass3;
    // End of variables declaration//GEN-END:variables

}
