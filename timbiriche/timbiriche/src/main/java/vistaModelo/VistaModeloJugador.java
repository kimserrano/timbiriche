/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaModelo;

import java.net.InetAddress;
import java.util.List;
import utils.JugadorDTO;
import modelo.IModeloJugador;
import modelo.IModeloSala;
import modelo.ModeloJugador;
import modelo.ModeloSala;
import utils.SalaDTO;

/**
 *
 * @author JORGE
 */
public class VistaModeloJugador implements IVistaModeloJugador {

    private IModeloJugador modeloJugador = ModeloJugador.getInstance();

    @Override
    public void extraerInformacion(String nickname, String color) {
        modeloJugador.procesarDatos(nickname, color);
    }

    @Override
    public JugadorDTO solicitarJugador() {
        return modeloJugador.solicitarJugador();
    } 
}
