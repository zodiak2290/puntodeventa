/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricadeVentanas;

import FabricadeVentanas.Ventanas.Ventana;

/**
 *
 * @author mipc
 */
public abstract class FabricaVentanas {
    protected String tipo;
    protected Ventana ventana;
    public abstract Ventana crearVentana(String tipo);
}
