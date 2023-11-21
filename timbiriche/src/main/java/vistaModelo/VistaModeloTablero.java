/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaModelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import utils.JugadorDTO;

/**
 *
 * @author eruma
 */
public class VistaModeloTablero implements IVistaModeloTablero{

 
    @Override
    public List<String> obtenerNicks(List<JLabel> nombres) {
        List<String> nicks=new ArrayList<>();
        for(JLabel lbl: nombres){
            nicks.add(lbl.getText());
        }
        return nicks;
    }
    
}
