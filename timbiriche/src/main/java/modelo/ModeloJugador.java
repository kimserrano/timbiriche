/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author JORGE
 */
public class ModeloJugador implements IModelo {

    private Jugador jugador;

    @Override
    public JugadorDTO procesarDatos(String nickname, String color) {
        try {
            jugador = new Jugador(nickname, color, InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModeloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JugadorDTO(jugador.getNickname(), jugador.getColor());
    }
}
