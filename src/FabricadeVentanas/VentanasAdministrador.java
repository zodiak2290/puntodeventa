/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricadeVentanas;

import FabricadeVentanas.Ventanas.Ventana;
import puntodeventa.admin.PrincipalAdmin.AgregarAdministrador;
import puntodeventa.admin.PrincipalAdmin.ModificarAdmin;
import puntodeventa.admin.PrincipalAdmin.MostrarAdmin;

/**
 *
 * @author mipc
 */
public class VentanasAdministrador extends FabricaVentanas{

    @Override
    public Ventana crearVentana(String tipo) {
        this.tipo=tipo;
        if(tipo.equalsIgnoreCase("Crear")){
            ventana=AgregarAdministrador.getInstancia(); 
        }
        else if(tipo.equalsIgnoreCase("Update")){
            ventana=ModificarAdmin.getInstancia();
        }
        else if(tipo.equalsIgnoreCase("Read")){
            ventana=MostrarAdmin.getInstancia();
        }
        else{          
        }
        return ventana;
    }
    
}
