package puntodeventa.inicio;

import puntodeventa.admin.PrincipalClientes.PrincipalCajero;


public class VentanaLoginCaj extends VentanaLogin
{       

   public VentanaLoginCaj()
    {      
        this.nombreVentana();
       ventana1=new PrincipalCajero();
    }

    @Override
    public void nombreVentana() {
        setTitle("Cuenta Cajero");
    }

}
