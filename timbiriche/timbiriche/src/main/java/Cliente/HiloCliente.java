/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import broker.EventBroker;
import broker.IEventBroker;
import broker.Procedencia;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class HiloCliente extends Thread{
    
    private String cadenaSala;
    private Set<Socket> jugadores;
    private IEventBroker evtBroker;
    
    public HiloCliente(Set<Socket> jugadores) {
        this.jugadores = jugadores;
        evtBroker = EventBroker.getInstance();
    }
    
    @Override
    public void run() {
        while(true){
            for(Socket skt : jugadores){
                try {
                    DataInputStream dis = new DataInputStream(skt.getInputStream());
                    cadenaSala = dis.readUTF();
                    
                    if(cadenaSala != null){
                        evtBroker.notificar(cadenaSala, Procedencia.Sala);
                        break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    public String getCadenaSala(){
        return cadenaSala;
    }
}
