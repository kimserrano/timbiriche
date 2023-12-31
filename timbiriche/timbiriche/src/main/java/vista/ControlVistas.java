/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;
import utils.SalaDTO;

/**
 *
 * @author JORGE
 */
public class ControlVistas {
    private static SalaFrame salaF = new SalaFrame();
    
    public static void cambiarVentana(JFrame ventana, int idVentana) {
        ventana.setVisible(false);
        switch (idVentana) {
            case 1:
                new PersonalizarFrame().setVisible(true);
                break;
            case 2:
                new MenuFrame().setVisible(true);
                break;
            case 3:
                new CodigoFrame().setVisible(true);
                break;
            case 4:                
                salaF.update();
                break;
            case 5:
                new Tablero().setVisible(true);
                break;
        }
    }
    
    public static SalaFrame getSalaF(){
        return salaF;
    }
}
