/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Jugador;

/**
 *
 * @author Elkur
 */
public class JugadorNegocio implements IJugadorNegocio{

    private Jugador jugador;

    public static JugadorNegocio getInstance() {
        return JugadorNegocioHolder.INSTANCE;
    }

    private static class JugadorNegocioHolder {

        private static final JugadorNegocio INSTANCE = new JugadorNegocio();
    }

    private JugadorNegocio() {

    }

    @Override
    public void establecerJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public Jugador obtenerJugador() {
        return jugador;
    }
}
