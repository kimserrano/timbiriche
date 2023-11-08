/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaModelo;

import java.net.InetAddress;
import utils.JugadorDTO;
import modelo.IModeloJugador;
import modelo.ModeloJugador;

/**
 *
 * @author JORGE
 */
public class VistaModelo implements IVistaModelo {

    private IModeloJugador modelo = ModeloJugador.getInstance();

    @Override
    public void extraerInformacion(String nickname, String color) {
        modelo.procesarDatos(nickname, color);
    }

    @Override
    public JugadorDTO solicitarJugador() {
        return modelo.solicitarJugador();
    }
}
