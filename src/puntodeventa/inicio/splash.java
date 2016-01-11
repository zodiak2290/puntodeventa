/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * splash.java
 *
 * Created on 17-ago-2013, 15:00:57
 */

package puntodeventa.inicio;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
//import com.sun.awt.AWTUtilities;
/**
 *
 * @author alberto
 */
public final class splash extends javax.swing.JFrame implements Runnable {
Thread t;
HiloProgreso hilo;//segunda ite
    /** Creates new form splash */
    public splash() {
        setUndecorated(true);//elimina botones de cerra, minimizar
getRootPane().setWindowDecorationStyle(JRootPane.NONE);//elimina botones de cerra, minimizar
//AWTUtilities.setWindowOpacity (this,0.5f);
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(0);

        //Método por defecto
    iniciarSplash();
    //Creamos un objeto HiloProgreso al cual
    //le pasamos por parámetro la barra de progreso
    hilo=new HiloProgreso(getProgreso());
    //Iniciamos el Hilo
    hilo.start();
    //Le damos tamaño y posición a nuestro Frame
    //Liberamos recursos
    hilo=null;
    }
    @SuppressWarnings("static-access")
     public void run() {
     try
        {
        this.setLocationRelativeTo(null); //Centra la ventana Splash
        this.setVisible(true);//Visualiza la pantalla
        t.sleep(10000);//tiempo que se mantiene la pantalla ()milisegundos
        EleccionLogin vp=new EleccionLogin();
        vp.elegir();
        this.dispose();//cierra la ventana
             
        }catch (InterruptedException ex){
            Logger.getLogger(splash.class.getName()).log(Level.SEVERE,null,ex);}
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
        progreso = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Punto de Venta");
        setBackground(new java.awt.Color(153, 0, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puntodeventa/inicio/images/marcas.jpg"))); // NOI18N

        progreso.setForeground(new java.awt.Color(204, 255, 51));

        jLabel2.setText("Cargando....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progreso, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the progreso
     */
    public javax.swing.JProgressBar getProgreso() {
        return progreso;
    }
    public void iniciarSplash() {
    this.getProgreso().setBorderPainted(true);
    this.getProgreso().setForeground(new Color(60, 80, 153, 100));
    this.getProgreso().setStringPainted(true);
}

    /**
     * @param progreso the progreso to set
     */
    public void setProgreso(javax.swing.JProgressBar progreso) {
        this.progreso = progreso;
    }



}