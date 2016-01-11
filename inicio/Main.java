/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package puntodeventa.inicio;
import javax.swing.*;
/**
 *
 * @author alberto
 */
public class Main {
 public static void main(String[]arg)
    {

     try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception e) {
	}

     new Thread(new splash()).start();
 }
}
