/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import dominio.Jugador;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JORGE
 */
public class ClienteOutput {

    private Set<Socket> jugadores;

    public ClienteOutput(Set<Socket> jug) {
        jugadores = jug;
    }

    public void agregarSv(String host, String sala) throws IOException {
        Socket skt = new Socket(host, 9999);
        enviarSala(sala, skt);
        jugadores.add(skt);
    }

    public void unirseSala(String codigo, Jugador jugador) throws IOException {
        Socket skt = new Socket(codigo, 9999);
        if (skt.isConnected()) {
            enviarNombre(skt, jugador.getNickname());
            jugadores.add(skt);
        }
    }

    private void enviarSala(String sala, Socket skt) throws IOException {
        DataOutputStream salida = new DataOutputStream(skt.getOutputStream());
        salida.writeUTF(sala);
    }

    private void enviarNombre(Socket skt, String nombre) throws IOException {
        DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
        dos.writeUTF("nombre " + nombre);
    }

    public Set<Socket> getJugadores() {
        return jugadores;
    }

    public void enviarNuevoJugador(String nuevoJugadorMensaje) throws IOException {
        for (Socket skt : jugadores) {
            DataOutputStream salida = new DataOutputStream(skt.getOutputStream());
            salida.writeUTF(nuevoJugadorMensaje);
        }
    }

}
