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

import Consultas.Consultas;
import BaseDatos.BaseDatos;
import BaseDatos.ConsultaBaseDatos;
import BaseDatos.InsertBaseDatos;
import FabricadeVentanas.Ventanas.Ventana;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
/**
 *
 * @author alberto
 */
public class AgregarAdministrador extends javax.swing.JFrame implements Ventana{
    private static AgregarAdministrador instancia = null;
    /** Creates new form PrincipalCliente */
    
    private AgregarAdministrador () {
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
        initComponents();
         this.setSize(455, 500);
        this.setLocationRelativeTo(null); //Centra la ventana Splash
        this.setResizable(false);
        jComboBox2.setVisible(false);
         try{
            BaseDatos realizaCons=new ConsultaBaseDatos(new Consultas().getListaEstados()); 
            int cantidadColumnas=realizaCons.getResultSetMetaData().getColumnCount();
            while(realizaCons.getResultSet().next()){
                 for(int i=1;i<cantidadColumnas;i++){
                      jComboBox1.addItem(realizaCons.getResultSet().getObject(i+1));
                      jComboBox2.addItem(realizaCons.getResultSet().getObject(i));   
                    } 
                }
            
             }
         
        catch(Exception e)
         {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
         }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apPat = new javax.swing.JTextField();
        calle = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        colonia = new javax.swing.JTextField();
        municipio = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        cp = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idamin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        curp = new javax.swing.JTextField();
        apMat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        contraseña1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        contraseña2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Datos del administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel2.setText("Nombre(s)       *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 79, -1));

        jLabel3.setText("Apellidos        *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 79, -1));

        jLabel4.setText("Calle y numero");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 91, 79, -1));

        jLabel5.setText("Colonia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 119, -1, -1));

        jLabel7.setText("Municipio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, -1, -1));

        jLabel8.setText("Estado");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 191, -1, -1));

        jLabel9.setText("Codigo Postal");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 243, -1, -1));

        jLabel10.setText("Email");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 276, -1, -1));

        jLabel11.setText("Telefono");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 302, -1, -1));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 31, 218, -1));
        jPanel1.add(apPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 62, 105, -1));
        jPanel1.add(calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 88, 218, -1));
        jPanel1.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 88, 34, -1));
        jPanel1.add(colonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 119, 218, -1));
        jPanel1.add(municipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 150, 218, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 188, -1, -1));
        jPanel1.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 240, 76, -1));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 273, 218, -1));
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 299, 218, -1));

        jLabel6.setText("ID administrador   *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));
        jPanel1.add(idamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 364, 210, -1));

        jLabel14.setText("Curp");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 333, -1, -1));
        jPanel1.add(curp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 218, -1));
        jPanel1.add(apMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 62, 104, -1));

        jLabel12.setText("Contraseña           *");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 398, -1, -1));
        jPanel1.add(contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 165, -1));

        jLabel13.setText("Repetir Contraseña  *");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 429, -1, -1));
        jPanel1.add(contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 165, -1));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        jLabel16.setText("jLabel16");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 200, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 188, -1, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Aceptar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Cancelar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
    * @param args the command line arguments
    */
    private  static void MostrarPirncipaladmin() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new AgregarAdministrador().setVisible(true);
            }
        });
    }
         public static AgregarAdministrador getInstancia() {
		if (instancia == null) {
			instancia = new AgregarAdministrador();
                        MostrarPirncipaladmin();
			}
                else{
                    instancia.toFront();
                }
		return instancia;
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apMat;
    private javax.swing.JTextField apPat;
    private javax.swing.JTextField calle;
    private javax.swing.JTextField colonia;
    private javax.swing.JPasswordField contraseña1;
    private javax.swing.JPasswordField contraseña2;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField curp;
    private javax.swing.JTextField email;
    private javax.swing.JTextField idamin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField municipio;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField num;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables

public void Aceptar() {
    if  (curp.getText().length() > 0 && idamin.getText().length() > 0&& nombre.getText().length() > 0&& apPat.getText().length() > 0)
    {
      if(contraseña1.getText().equals(contraseña2.getText()) && contraseña1.getText().length()> 0)
        {
           jComboBox2.setSelectedIndex(jComboBox1.getSelectedIndex());
           BaseDatos bd=new InsertBaseDatos(new Consultas().getInsertPersona(curp.getText(),nombre.getText(),apPat.getText(),apMat.getText(),calle.getText(),colonia.getText(),num.getText(),municipio.getText(),jComboBox2.getSelectedItem(),cp.getText(),email.getText(),telefono.getText()));   
           BaseDatos bd2=new InsertBaseDatos(new Consultas().getInsertAdmin(idamin.getText(),curp.getText().toUpperCase(),contraseña1.getText()));
           JOptionPane.showMessageDialog(null,"Registro exitoso!","",JOptionPane.ERROR_MESSAGE);
           Cancelar();
        }
        else{
           JOptionPane.showMessageDialog(null,"ESCRIBA LA CONTRASEÑA EN AMBOS CAMPOS ","Error",JOptionPane.ERROR_MESSAGE);
        }
      }
     else{
         JOptionPane.showMessageDialog(null,"Hay campos indispensables para registrar al usuario","Error",JOptionPane.ERROR_MESSAGE);
     }
 
}

    public void Cancelar() {
        instancia=null;
        dispose();
    }
}
