/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricadeVentanas;

import FabricadeVentanas.Ventanas.Ventana;
import puntodeventa.admin.PrincipalAdmin.AgregarCajero;
import puntodeventa.admin.PrincipalAdmin.ModificarCajero;
import puntodeventa.admin.PrincipalAdmin.MostrarCajero;

/**
 *
 * @author mipc
 */
public class VentanasCajero extends FabricaVentanas{

    @Override
    public Ventana crearVentana(String tipo) {
        this.tipo=tipo;
        if(tipo.equalsIgnoreCase("Crear")){
            ventana=AgregarCajero.getInstancia(); 
        }
        else if(tipo.equalsIgnoreCase("Update")){
            ventana=ModificarCajero.getInstancia();
        }
        else if(tipo.equalsIgnoreCase("Read")){
            ventana=MostrarCajero.getInstancia();
        }
        else{          
            //ventana=EliminarCajero().getInstancia();
        }
        return ventana;
    }
}
