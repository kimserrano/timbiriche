/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import dominio.Jugador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ISalaNegocio;
import negocio.ITableroNegocio;
import negocio.NegocioException;
import negocio.SalaNegocio;
import negocio.TableroNegocio;

/**
 *
 * @author JORGE
 */
public class HiloServidor implements Runnable {

    private Set<Socket> jugadores;
    private ServerSocket svSocket;
    private ISalaNegocio salaN;
    private ITableroNegocio tableroN;

    public HiloServidor() throws IOException {
        salaN = SalaNegocio.getInstance();
        int puerto = salaN.obtenerPuerto();
        System.out.println("Puerto a iniciar: " + puerto);
        svSocket = new ServerSocket(puerto);
        jugadores = new HashSet<>();
    }

    @Override
    public void run() {
        salaN.agregarJugadores();
        while (true) {
            try {
                Socket skt = svSocket.accept();
                DataInputStream dis = new DataInputStream(skt.getInputStream());
                String operacion = dis.readUTF();
                procesaMensaje(operacion, skt);

            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NegocioException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String getName(String cadena) {
        String[] texto = cadena.split(" ");

        String nombre = texto[1];

        return nombre;
    }

    private void procesaMensaje(String mensaje, Socket skt) throws NegocioException, IOException {
        String[] operacion = mensaje.split(" ");
        if (operacion[0].equalsIgnoreCase("jugadorNuevo")) {
            salaN.revisarNuevosJugadores();
        }else if(operacion[0].equalsIgnoreCase("actualizarSala")){
            salaN.revisarNuevosJugadores();
        }else if(operacion[0].equalsIgnoreCase("estadoEnSala")){
            salaN.indicarListo(operacion[1],operacion[2]);
        }else if(operacion[0].equalsIgnoreCase("movimiento")){
            tableroN=TableroNegocio.getInstance();
            tableroN.pintarMovimiento(Integer.parseInt(operacion[1]), Integer.parseInt(operacion[2]), Boolean.parseBoolean(operacion[3]), String.valueOf(operacion[4]), Integer.parseInt(operacion[5]));
        }else if(operacion[0].equalsIgnoreCase("ganador")){
            tableroN=TableroNegocio.getInstance();
            tableroN.mostrarGanador(String.valueOf(operacion[1]));
        }
    }
}
