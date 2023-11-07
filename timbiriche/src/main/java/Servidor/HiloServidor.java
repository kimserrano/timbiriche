/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE
 */
public class HiloServidor implements Runnable {
    private List<Socket> jugadores;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public HiloServidor(List<Socket> jugadores, Socket socket) {
        this.jugadores = jugadores;
        this.socket = socket;
    }

    @Override
    public void run() {
        //TO DO
    }

}
