/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntodeventa.MDP;

/**
 *
 * @author mipc
 */
public interface SubjectAddProducto {
        public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
