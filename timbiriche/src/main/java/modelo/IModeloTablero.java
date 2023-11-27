/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;
import utils.JugadorDTO;
import utils.SalaDTO;
import utils.BtnTimbi;

/**
 *
 * @author JORGE
 */
public interface IModeloTablero {

    public JugadorDTO[] recuperarJugadores();

    public SalaDTO obtenerSala();

    public void salir();

    public void movimiento(BtnTimbi btn);

    public void generarTurnos(List<JugadorDTO> jugadores);

    public void otorgarPuntos();
}
