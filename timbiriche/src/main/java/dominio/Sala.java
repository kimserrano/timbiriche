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
public class Sala {

    private List<Jugador> jugadores;
    private boolean estadoSala;
    private String codigo;

    public Sala(String codigo) {
        this.codigo = codigo;
        this.estadoSala = false;
    }

    public Sala() {
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setJugador(Jugador jugador) {
        if (jugadores != null) {
            jugadores.add(jugador);
        }
    }

    public boolean isEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(boolean estadoSala) {
        this.estadoSala = estadoSala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
