/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pullserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class PullServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hilo;
        try {
            hilo = new Thread(new Server());
            hilo.start();
        } catch (IOException ex) {
            Logger.getLogger(PullServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
