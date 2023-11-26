/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import datos.ipsDTO;
import dominio.Jugador;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE
 */
public class ClienteOutput {

    private Set<Socket> jugadores;

    public ClienteOutput(Set<Socket> jug) {
        jugadores = jug;
    }

    public void enviarSolicitudPullSv(Socket pullSv, String codigo, String operacion, String nickname) throws IOException {
        DataOutputStream out = new DataOutputStream(pullSv.getOutputStream());

        out.writeUTF(operacion + " " + codigo + " " + nickname);
    }

    public void solicitarSala(Socket pullSv, String codigo, String operacion, String puerto) throws IOException {
        DataOutputStream out = new DataOutputStream(pullSv.getOutputStream());

        out.writeUTF(operacion + " " + codigo + " " + puerto);
    }

    public void avisar(String ip, int puerto, String codigo) throws IOException, ConnectException {
        Socket skt = new Socket(ip, puerto);

        DataOutputStream out = new DataOutputStream(skt.getOutputStream());

        out.writeUTF("jugadorNuevo");
    }

    public void solicitarNuevaSala(Socket pullSv, String codigo) throws IOException {
        DataOutputStream out = new DataOutputStream(pullSv.getOutputStream());

        out.writeUTF("solicitarIps" + " " + codigo);
    }

    public void eliminarConexion(int puerto, String codigo, Socket svSocket) throws IOException {
        DataOutputStream out = new DataOutputStream(svSocket.getOutputStream());

        out.writeUTF("eliminarPuerto" + " " + codigo + " " + puerto);
    }

    public void actualizarPeers(ipsDTO ips) throws IOException {
        for (String datos : ips.getIppuerto()) {
            String[] aux = datos.split(" ");

            String nickname = aux[0];
            String ip = aux[1].split(":")[0];
            int puerto = Integer.parseInt(aux[1].split(":")[1]);

            Socket skt = new Socket(ip, puerto);
            DataOutputStream out = new DataOutputStream(skt.getOutputStream());

            out.writeUTF("actualizarSala");

        }
    }

    public void solicitarIPs(Socket svSockets, String codigo, int puerto) throws IOException {
        DataOutputStream out = new DataOutputStream(svSockets.getOutputStream());

        out.writeUTF("solicitarIpsSinMi" + " " + codigo + " " + puerto);
    }

    void avisarEstadoSala(String operacion, Solicitud solicitud, ipsDTO ips) throws IOException {
        for (String ippuerto : ips.getIppuerto()) {
            String[] aux = ippuerto.split(" ");

            String nickname = aux[0];
            String ip = aux[1].split(":")[0];
            int puerto = Integer.parseInt(aux[1].split(":")[1]);

            Socket skt = new Socket(ip, puerto);
            DataOutputStream out = new DataOutputStream(skt.getOutputStream());
            out.writeUTF(operacion + " " + solicitud.obtenerDato("puerto") + " " + solicitud.obtenerDato("estadoEnSala"));

        }
    }
}
