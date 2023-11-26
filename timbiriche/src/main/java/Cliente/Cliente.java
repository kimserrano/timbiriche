/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Servidor.HiloServidor;
import broker.EventBroker;
import broker.IEventBroker;
import broker.Procedencia;
import datos.ipsDTO;
import dominio.Jugador;
import dominio.Sala;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class Cliente implements ICliente {

    private ClienteOutput clnOut;
    private ClienteInput clnIn;

    private IEventBroker evtBroker;

    private Set<Socket> jugadores;
    private Socket svSockets;

    public Cliente() {
        jugadores = new HashSet<>();
        clnOut = new ClienteOutput(jugadores);
        clnIn = new ClienteInput();
        evtBroker = EventBroker.getInstance();
    }

    private void iniciarSvSockets() throws IOException {

        svSockets = new Socket(InetAddress.getLocalHost().getHostAddress(), 9500);

    }

    @Override
    public void crearSala(String codigo, String nickname) throws IOException {
        iniciarSvSockets();
        clnOut.enviarSolicitudPullSv(svSockets, codigo, "crear", nickname);
        evtBroker.notificar("", Procedencia.input);
    }

    @Override
    public void unirseSala(String codigo, Jugador jugador) throws IOException {
        iniciarSvSockets();
        clnOut.enviarSolicitudPullSv(svSockets, codigo, "unirse", jugador.getNickname());
        evtBroker.notificar("", Procedencia.input);
    }

    @Override
    public ipsDTO agregarSala(String codigo) throws IOException {
        ObjectInputStream in = new ObjectInputStream(svSockets.getInputStream());
        try {
            ipsDTO ips = (datos.ipsDTO) in.readObject();
            avisarEntrada(ips, codigo);
            return ips;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int obtenerPuerto() throws IOException {
        return clnIn.obtenerPuerto(svSockets);
    }

    private void avisarEntrada(ipsDTO ips, String codigo) throws IOException {
        List<Integer> puertosMuertos = new ArrayList<>();
        for (String datos : ips.getIppuerto()) {
            String[] aux = datos.split(" ");

            String nickname = aux[0];
            String ip = aux[1].split(":")[0];
            int puerto = Integer.parseInt(aux[1].split(":")[1]);
            try {
                clnOut.avisar(ip, puerto, codigo);
            } catch (ConnectException e) {
                System.out.println("Puerto muerto: " + puerto);
                puertosMuertos.add(puerto);
            }
        }

        eliminarPuertos(puertosMuertos, codigo);

    }

    private void eliminarPuertos(List<Integer> puertos, String codigo) throws IOException {
        for (Integer puerto : puertos) {
            iniciarSvSockets();
            clnOut.eliminarConexion(puerto, codigo, svSockets);
        }
    }

    @Override
    public ipsDTO obtenerNuevaSala(String codigo) throws IOException {
        iniciarSvSockets();
        clnOut.solicitarNuevaSala(svSockets, codigo);

        ObjectInputStream in = new ObjectInputStream(svSockets.getInputStream());
        try {
            ipsDTO ips = (datos.ipsDTO) in.readObject();
            return ips;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    @Override
    public void eliminarPuerto(Solicitud solicitud) throws IOException {
        iniciarSvSockets();

        String codigo = solicitud.obtenerDato("codigo");
        int puerto = Integer.parseInt(solicitud.obtenerDato("puerto"));

        clnOut.eliminarConexion(puerto, codigo, svSockets);
        avisar(solicitud);
    }

    private void avisar(Solicitud solicitud) throws IOException {
        OperacionesCliente op = solicitud.getOperacion();
        switch (op) {
            case entrada:
                //To do
                break;
            case salida:
                int puerto = Integer.parseInt(solicitud.obtenerDato("puerto"));
                ipsDTO ips = obtenerIPs(solicitud.obtenerDato("codigo"), puerto);
                clnOut.actualizarPeers(ips);
        }
    }

    public ipsDTO obtenerIPs(String codigo, int puerto) throws IOException {
        iniciarSvSockets();
        clnOut.solicitarIPs(svSockets, codigo, puerto);
        return clnIn.obtenerIPs(svSockets);
    }

    @Override
    public void enviarEstado(Solicitud solicitud) throws IOException{
        
        int puerto = Integer.parseInt(solicitud.obtenerDato("puerto"));
        ipsDTO ips = obtenerIPs(solicitud.obtenerDato("codigo"), puerto);
        
        clnOut.avisarEstadoSala("estadoEnSala", solicitud, ips);
    }

}
