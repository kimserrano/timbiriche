/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Servidor.HiloServidor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.ControlVistas;
import vista.PersonalizarFrame;

/**
 *
 * @author Elkur
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try { 
            new Thread(new HiloServidor()).start();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        new PersonalizarFrame().setVisible(true);
    }
    
}
