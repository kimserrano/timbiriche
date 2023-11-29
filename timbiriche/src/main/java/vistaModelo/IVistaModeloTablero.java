/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistaModelo;

import java.util.List;
import javax.swing.JLabel;
import utils.JugadorDTO;
import utils.SalaDTO;
import utils.BtnTimbi;

/**
 *
 * @author eruma
 */
public interface IVistaModeloTablero {

    public List<String> obtenerNicks(List<JLabel> nombres);

    public void imprimirJugadores();
    
    public JugadorDTO[] recuperarJugadores();
    
    public SalaDTO obtenerSala();
    
    public void salir();
    
    public void verificarMovimiento(BtnTimbi btn);
    
    public void otorgarPuntos();
    
    public void generarTurnos(List<JugadorDTO> jugadores);
    
    public void anotarPuntoLocal();
}

    
