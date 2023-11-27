/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Jugador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elkur
 */
public class JugadorNegocio implements IJugadorNegocio {

    private Jugador jugador;
    private List<Color> coloresDisponibles;

    public static JugadorNegocio getInstance() {
        return JugadorNegocioHolder.INSTANCE;
    }

    private static class JugadorNegocioHolder {

        private static final JugadorNegocio INSTANCE = new JugadorNegocio();
    }

    private JugadorNegocio() {
        coloresDisponibles = new ArrayList<>();
        coloresDisponibles.add(new Color(255, 102, 153)); //Rosa
        coloresDisponibles.add(new Color(255, 255, 153)); //Amarillo
        coloresDisponibles.add(new Color(153, 204, 255)); //Azul
        coloresDisponibles.add(new Color(153, 255, 204)); //Verde

    }

    @Override
    public void establecerJugador(Jugador jugador) {
        this.jugador = jugador;
        int indexColor = coloresDisponibles.indexOf(generarColor(jugador.getColor()));
        Color local = coloresDisponibles.get(indexColor);
        coloresDisponibles.remove(local);
    }
    @Override
    public void actualizarJugador(Jugador jugador2) {
        String color = jugador.getColor();

        coloresDisponibles.add(generarColor(color));

        jugador = jugador2;
    }

    public Color generarColor(String color) {
        String rgb[] = color.split(",");
        return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
    }
    @Override
    public List<Color> getColoresDisponibles(){
        return coloresDisponibles;
    }
    
    @Override
    public Jugador obtenerJugador() {
        return jugador;
    }
}
