
package puntodeventa.inicio;

import puntodeventa.admin.PrincipalAdmin.PrincipalAdmin;


public class VentanaLoginAdmin extends VentanaLogin
{       

   public VentanaLoginAdmin()
    {      
       this.nombreVentana();
       ventana1=new PrincipalAdmin();
    }
   @Override
    public void nombreVentana() {
        setTitle("Cuenta Administrador");
    }

}
