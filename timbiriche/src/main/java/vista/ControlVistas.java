/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;
import utils.JugadorDTO;

/**
 *
 * @author JORGE
 */
public class ControlVistas {

    public static void cambiarMenu(JFrame jf, JugadorDTO jug) {
        new MenuFrame(jug).setVisible(true);
        jf.dispose();
    }
}
