/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Cliente.Cliente;
import Cliente.ICliente;
import broker.EventBroker;
import broker.IEventBroker;
import broker.Procedencia;
import datos.ipsDTO;
import dominio.Jugador;
import dominio.Sala;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE
 */
public class SalaNegocio implements ISalaNegocio {

    private IEventBroker evtBroker;
    private Sala sala;
    private ICliente cln;
    private IJugadorNegocio jugadorNegocio;

    public static SalaNegocio getInstance() {
        return SalaNegocioHolder.INSTANCE;
    }

    private static class SalaNegocioHolder {

        private static final SalaNegocio INSTANCE = new SalaNegocio();
    }

    private SalaNegocio() {
        cln = new Cliente();
        evtBroker = EventBroker.getInstance();
        jugadorNegocio = JugadorNegocio.getInstance();
    }

    @Override
    public Sala crearSala(Jugador anfitrion) throws NegocioException {
        if (anfitrion.getIp() == null) {
            throw new NegocioException("Error al crear la sala");
        }
        String codigo = this.generarCodigo();
        Sala sala = new Sala(codigo);
        ArrayList<Jugador> jug = new ArrayList<>();
        jug.add(anfitrion);
        sala.setJugadores(jug);
        try {
            cln.crearSala(codigo, anfitrion.getNickname());
        } catch (IOException ex) {
            Logger.getLogger(SalaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No se pudo crear la sala");
        }
        this.sala = sala;
        return sala;
    }

    @Override
    public void unirseSala(String codigo, String nombre) throws NegocioException {
        try {
            sala = new Sala(codigo);
            sala.setJugadores(new ArrayList<>());
            cln.unirseSala(codigo, new Jugador(nombre, "", InetAddress.getLocalHost().getHostAddress()));

        } catch (IOException ex) {
            Logger.getLogger(SalaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al ingresar a la sala");
        }
    }

    private String generarCodigo() {
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int longitudCadena = 6;
        StringBuilder codigo = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < longitudCadena; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            char caracterAleatorio = caracteresPermitidos.charAt(indice);
            codigo.append(caracterAleatorio);
        }
        return codigo.toString();
    }

    @Override
    public void agregarJugadores() {
        ipsDTO ips = null;
        try {
            System.out.println("2");
            ips = cln.agregarSala(sala.getCodigo());
        } catch (IOException ex) {
            Logger.getLogger(SalaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Jugador> jugadores = new ArrayList<>();

        for (String datos : ips.getIppuerto()) {
            String[] aux = datos.split(" ");

            String nickname = aux[0];
            String ip = aux[1].split(":")[0];
            int puerto = Integer.parseInt(aux[1].split(":")[1]);

            Jugador jugador = new Jugador(nickname, ip, puerto);

            jugadores.add(jugador);
        }

        sala.setJugadores(jugadores);
        evtBroker.notificar("", Procedencia.Sala);
    }

    @Override
    public void revisarNuevosJugadores() {
        ipsDTO ips = null;
        try {
            ips = cln.obtenerNuevaSala(sala.getCodigo());
        } catch (IOException ex) {
            Logger.getLogger(SalaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Jugador> jugadores = new ArrayList<>();

        for (String datos : ips.getIppuerto()) {
            String[] aux = datos.split(" ");

            String nickname = aux[0];
            String ip = aux[1].split(":")[0];
            int puerto = Integer.parseInt(aux[1].split(":")[1]);

            Jugador jugador = new Jugador(nickname, ip, puerto);

            jugadores.add(jugador);
        }

        sala.setJugadores(jugadores);
        evtBroker.notificar("", Procedencia.Sala);
    }

    @Override
    public int obtenerPuerto() throws IOException {
        int puerto = cln.obtenerPuerto();
        jugadorNegocio.obtenerJugador().setPuerto(puerto);
        return puerto;
    }

    @Override
    public Sala actualizarSala() {
        return sala;
    }

}
