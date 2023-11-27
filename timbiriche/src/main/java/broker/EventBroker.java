/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package broker;

import Servidor.Servidor;
import java.util.HashSet;
import negocio.SalaNegocio;
import vista.ControlVistas;
import vista.SalaFrame;

/**
 *
 * @author Elkur
 */
public class EventBroker implements IEventBroker {

    private HashSet<Suscriptor> subsSala;
    private HashSet<Suscriptor> subsJuego;
    private HashSet<Suscriptor> subsServer;
    private HashSet<Suscriptor> subsTablero;

    private EventBroker() {
        subsJuego = new HashSet<>();
        subsSala = new HashSet<>();
        subsServer = new HashSet<>();
        subsTablero = new HashSet<>();
        subsSala.add(ControlVistas.getSalaF()); 
        subsServer.add(new Servidor());
        
    }

    public static EventBroker getInstance() {
        return EventBrokerHolder.INSTANCE;
    }

    private static class EventBrokerHolder {

        private static final EventBroker INSTANCE = new EventBroker();
    }
    
    @Override
    public void agregarSuscriptorTablero(Suscriptor sub){
        subsTablero.add(sub);
    }

    @Override
    public void notificar(String mensaje, Procedencia proc) {
        if (proc == Procedencia.Sala) {
            if (!subsSala.isEmpty()) {
                for (Suscriptor sub : subsSala) {
                    sub.update();
                }
            }
        }
        if (proc == Procedencia.input) {
            if (!subsServer.isEmpty()) {
                for (Suscriptor sub : subsServer) {
                    sub.update();
                }
            }
        }
        if(proc == Procedencia.tablero){
            if(!subsTablero.isEmpty()){
                for(Suscriptor sub : subsTablero){
                    sub.update();
                }
            }
        }
    }
}
