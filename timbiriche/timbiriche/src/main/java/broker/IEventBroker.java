/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package broker;

/**
 *
 * @author Elkur
 */
public interface IEventBroker {
    
    public void notificar(String mensaje, Procedencia proc);
    
}
