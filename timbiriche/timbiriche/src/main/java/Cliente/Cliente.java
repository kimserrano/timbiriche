/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Servidor.HiloServidor;
import dominio.Jugador;
import dominio.Sala;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class Cliente implements ICliente {
    
    private ClienteOutput clnOut;
    private Set<Socket> jugadores;
    
    public Cliente() {
        jugadores = new HashSet<>();
        clnOut = new ClienteOutput(jugadores);
    }
    
    @Override
    public void unirseSala(String codigo, Jugador jugador) throws IOException {
        clnOut.unirseSala(codigo, jugador);
    }

    @Override
    public void enviarNuevoJugador(String nickname, String ip) throws IOException {
        clnOut.enviarNuevoJugador(crearNuevoJugadorMensaje(nickname, ip));
    }
    
    private String crearNuevoJugadorMensaje(String nickname, String ip){
        String mensaje = "nuevo "+nickname+" "+ip;
        return mensaje;
    }

    @Override
    public void agregarConexionNuevo(String ip, Sala sala) {
        try {
            clnOut.agregarSv(ip, crearCadenaSala(sala));
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String crearCadenaSala(Sala sala){
        StringBuffer cadena = new StringBuffer();
        cadena.append("sala ");
        for(Jugador jug : sala.getJugadores()){
            cadena.append(jug.getNickname()+" "+jug.getIp()+" ");
        }
        cadena.append(sala.getCodigo());
        return cadena.toString();
    }
    
    
}
