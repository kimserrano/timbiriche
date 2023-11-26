/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dominio.Jugador;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author eruma
 */
public class ModeloTablero {

    Jugador[] jugadores = {new Jugador("yorch", "255,0,0"), new Jugador("kim", "62,21,177"),
        new Jugador("marki", "0,255,0"), new Jugador("elmer", "54,165,201")};

    public ModeloTablero() {
        
        shuffleTurnos(jugadores);
        
    }

    private static <T> void shuffleTurnos(T[] array) {
        List<T> lista = Arrays.asList(array);
        Collections.shuffle(lista);
        lista.toArray(array); // Convierte la lista mezclada de nuevo a un array
    }
    
    public void imprimirJugadores(){
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }
}
