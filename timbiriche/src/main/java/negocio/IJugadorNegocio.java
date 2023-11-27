/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dominio.Jugador;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author Elkur
 */
public interface IJugadorNegocio {

    public void establecerJugador(Jugador jugador);

    public Jugador obtenerJugador();

    public void actualizarJugador(Jugador jugador2);

    public List<Color> getColoresDisponibles();
}
