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
import utils.JugadorDTO;

/**
 *
 * @author Elkur
 */
public class ModeloJugador implements IModeloJugador {

    private Jugador jugador;

    private ModeloJugador() {
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
            jugador = new Jugador(nickname, color, InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModeloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public JugadorDTO solicitarJugador() {
        System.out.println(jugador);
        return new JugadorDTO(jugador.getNickname(), jugador.getColor());
    }
}
