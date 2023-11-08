/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistaModelo;
import negocio.*;
import utils.JugadorDTO;

/**
 *
 * @author JORGE
 */
public interface IVistaModelo {
    public void extraerInformacion(String nickname, String color);
    public JugadorDTO solicitarJugador();
}
