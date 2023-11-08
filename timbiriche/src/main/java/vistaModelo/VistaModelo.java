/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaModelo;

import java.net.InetAddress;
import modelo.IModelo;
import modelo.ModeloJugador;
import utils.JugadorDTO;

/**
 *
 * @author JORGE
 */
public class VistaModelo implements IVistaModelo{
private IModelo modelo = new ModeloJugador();
    
    @Override
    public void extraerInformacion(String nickname, String color) {
        modelo.procesarDatos(nickname, color);
    }

    @Override
    public JugadorDTO solicitarInformacionJugador() {
        return modelo.mandarJugador();
    }
    
}
