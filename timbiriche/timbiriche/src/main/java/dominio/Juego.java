/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

/**
 *
 * @author JORGE
 */
public class Juego {

    private List<Puntaje> puntajes;
    private List<Jugador> turnos;

    public Juego() {
    }

    public List<Puntaje> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(List<Puntaje> puntajes) {
        this.puntajes = puntajes;
    }

    public List<Jugador> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Jugador> turnos) {
        this.turnos = turnos;
    }

}
