
package puntodeventa.inicio;

import VentanaPrincipalPrincipal.Principal;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public abstract class VentanaLogin extends JFrame
{       
        Principal ventana1;
        private JTextField txtUser, txtPass;
        public JLabel lblUser, lblPass;
        private JButton btnAceptar, btnCancelar;
        String usuari, pass;
   public VentanaLogin()
    {      
        Container contenedor = getContentPane();  
        contenedor.setLayout(new FlowLayout());
        // crear etiqueta y cuadro de texxto del usuario
        txtUser = new JTextField(10);
        lblUser = new JLabel("Usuario: ");
        txtUser.setToolTipText("Escriba su nombre de usuario");
        
        contenedor.add( Box.createVerticalStrut(50) );
        contenedor.add(lblUser);
        contenedor.add(txtUser);
        //crear etiqueta y cuadro de texxto del pw
        txtPass = new JPasswordField(10);
        lblPass = new JLabel("Contraseña: ");
        txtPass.setToolTipText("Escriba su contraseña");
        contenedor.add(lblPass);
        contenedor.add(txtPass);
        //Crear y agregar los botones
        btnAceptar = new JButton("Aceptar");
        //establecer Boton aceptar por defecto
        getRootPane().setDefaultButton(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        contenedor.add(btnAceptar);
        contenedor.add(btnCancelar);
                

      // Crear un escuchador al boton Aceptar
        ActionListener escuchadorbtnAceptar = new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    //chekar si el usuario escrbio el nombre de usuario y pw
                    if (txtUser.getText().length() > 0 && txtPass.getText().length() > 0 )
                    {
                        ventana1.recibirUsuario(txtUser.getText(),txtPass.getText());
                        // Si el usuario si fue validado correctamente
                        if( ventana1.correcto())    //enviar datos a validar
                        {
                            setUser(txtUser.getText());
                               setPass(txtPass.getText());
                            // Codigo para mostrar la ventana principal
                            setVisible(false);
                            ventana1.MostrarPirncipal();                        
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contrasenia no son validos.");
                            txtUser.setText("");    //limpiar campos
                            txtPass.setText("");

                            txtUser.requestFocusInWindow();
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contrasenia.\n" +
                            "NO puede dejar ningun campo vacio");
                    }

                } catch (Exception e)
                {
                }

            }
        };
        btnAceptar.addActionListener(escuchadorbtnAceptar);      // Asociar escuchador para el boton Aceptar


      // Agregar escuchador al boton Cancelar
        ActionListener escuchadorbtnCancelar=new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
         EleccionLogin vp=new EleccionLogin();
        vp.elegir();
        dispose();//cierra la ventana         // terminar el programa
            }
        };
        btnCancelar.addActionListener(escuchadorbtnCancelar);      // Asociar escuchador para el boton Cancelar
        
        setSize(400,150);           // Tamanio del Frame
        setResizable(false);       // que no se le pueda cambiar el tamanio
        //Centrar la ventana de autentificacion en la pantalla

        Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
        Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
        setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
        setVisible(true);           // Hacer visible al frame

    }   // fin de constructor

    // Metodo que conecta con el servidor MYSQL y valida los usuarios
   public abstract void nombreVentana();

    

    public void setUser(String us)
    {
     this.usuari=us;
    }
    public String getUser()
    {
        return usuari;
    }

    public void setPass(String pass)
    {
        this.pass=pass;
    }
    public String getPass()
    {
        return pass;
    }
    
     public void setPrincipal(Principal p){
            this.ventana1=p;
      }

}
