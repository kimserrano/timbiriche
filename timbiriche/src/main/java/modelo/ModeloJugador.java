/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package modelo;

import dominio.Jugador;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IJugadorNegocio;
import negocio.JugadorNegocio;
import utils.JugadorDTO;

/**
 *
 * @author Elkur
 */
public class ModeloJugador implements IModeloJugador {

    private IJugadorNegocio jugadorN;
    
    private ModeloJugador() {
        this.jugadorN = JugadorNegocio.getInstance();
    }

    public static ModeloJugador getInstance() {
        return ModeloJugadorHolder.INSTANCE;
    }

    private static class ModeloJugadorHolder {

        private static final ModeloJugador INSTANCE = new ModeloJugador();
    }

    @Override
    public void procesarDatos(String nickname, String color) {
        try {
            Jugador jugador = new Jugador(nickname, color, InetAddress.getLocalHost().getHostAddress());
            jugadorN.establecerJugador(jugador);
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModeloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public JugadorDTO solicitarJugador() {
        Jugador jugador = jugadorN.obtenerJugador();
        return new JugadorDTO(jugador.getNickname(), jugador.getColor());
    }
}
