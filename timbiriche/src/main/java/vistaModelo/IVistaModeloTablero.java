/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistaModelo;

import java.util.List;
import javax.swing.JLabel;
import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author eruma
 */
public interface IVistaModeloTablero {

    public List<String> obtenerNicks(List<JLabel> nombres);

    public void shuffleTurnos();
    
}

    
