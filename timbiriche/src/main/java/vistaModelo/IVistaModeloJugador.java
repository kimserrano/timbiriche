/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistaModelo;
import java.util.List;
import negocio.*;
import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author JORGE
 */
public interface IVistaModeloJugador {
    public void extraerInformacion(String nickname, String color);
    public JugadorDTO solicitarJugador();
    
}
