
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import javax.swing.JLabel;
import vista.Tablero;

/**
 *
 * @author eruma
 */
public class Turno {

    int turnoActual = 0;
    String nickTurnoActual="";
    JLabel lblTurnoActual=new JLabel();
    List<JugadorDTO> jugadores;

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }
    
  
    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public String getNickTurnoActual() {
        return nickTurnoActual;
    }

    public void setNickTurnoActual(String nickTurnoActual) {
        this.nickTurnoActual = nickTurnoActual;
    }

    public JLabel getLblTurnoActual() {
        return lblTurnoActual;
    }

    public void setLblTurnoActual(JLabel lblTurnoActual) {
        this.lblTurnoActual = lblTurnoActual;
    }
    
    public void turnoAdd(){
        this.turnoActual++;
        verificarTurno();
    }
    
    public void verificarTurno() {
        if (turnoActual >= jugadores.size()) {
            turnoActual = 0;
        }
        JugadorDTO jugadorTurnoActual = jugadores.get(turnoActual);
        nickTurnoActual = jugadorTurnoActual.getNickname();
        this.lblTurnoActual.setText(nickTurnoActual);
    }
    
    public void turnoLess(){
        this.turnoActual--;
        verificarTurno();
    }
}
