/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaModelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import modelo.ModeloTablero;
import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author eruma
 */
public class VistaModeloTablero implements IVistaModeloTablero{

    ModeloTablero modelTab=new ModeloTablero();
    
    @Override
    public List<String> obtenerNicks(List<JLabel> nombres) {
        List<String> nicks=new ArrayList<>();
        for(JLabel lbl: nombres){
            nicks.add(lbl.getText());
        }
        return nicks;
    }

    @Override
    public void imprimirJugadores() {
        modelTab.imprimirJugadores();
    }

    @Override
    public JugadorDTO[] recuperarJugadores() {
       return modelTab.recuperarJugadores();
    }

    @Override
    public SalaDTO obtenerSala() {
        return modelTab.obtenerSala();
    }

    @Override
    public void salir() {
       modelTab.salir();
    }

    
}
