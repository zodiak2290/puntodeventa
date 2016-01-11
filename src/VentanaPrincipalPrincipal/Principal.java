/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipalPrincipal;

/**
 *
 * @author mipc
 */
public interface Principal {
    //JFrame ventanaPrincipal=new JFrame("Ventana Pricipal");
    public void MostrarPirncipal();
    public void recibirUsuario(String Useri,String pass);
    public String EnviarUsuario();
    public void initComponents();
    boolean correcto();
}
