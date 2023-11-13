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
import broker.Suscriptor;
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

    public static SalaNegocio getInstance() {
        return SalaNegocioHolder.INSTANCE;
    }

    private static class SalaNegocioHolder {

        private static final SalaNegocio INSTANCE = new SalaNegocio();
    }

    private SalaNegocio() {
        cln = new Cliente();
        evtBroker = EventBroker.getInstance();
    }

    @Override
    public Sala crearSala(Jugador anfitrion) throws NegocioException {
        if (anfitrion.getIp() == null) {
            throw new NegocioException("Error al crear la sala");
        }
        String codigo = this.generarCodigo();
        Sala sala = new Sala(anfitrion.getIp());
        ArrayList<Jugador> jug = new ArrayList<>();
        jug.add(anfitrion);
        sala.setJugadores(jug);
        this.sala = sala;
        return sala;
    }

    //TO DO con sockets
    @Override
    public void unirseSala(String codigo, String nombre) throws NegocioException {
        try {
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
    public void agregarJugador(Jugador jug) throws NegocioException {
        if (sala != null) {

            try {
                cln.enviarNuevoJugador(jug.getNickname(), jug.getIp());
                cln.agregarConexionNuevo(jug.getIp(), sala);
                sala.getJugadores().add(jug);

                evtBroker.notificar("", Procedencia.Sala);
            } catch (IOException ex) {
                Logger.getLogger(SalaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }
            evtBroker.notificar("", Procedencia.Sala);
        }
    }

    @Override
    public Sala actualizarSala() {
        return sala;
    }

    @Override
    public String obtenerSalaMensaje() {
        StringBuffer txt = new StringBuffer();

        for (Jugador jug : sala.getJugadores()) {
            txt.append(jug.getNickname() + " " + jug.getIp() + " ");
        }

        return txt.toString();
    }

    @Override
    public void agregarJugadorNuevo(Jugador jugador) throws NegocioException {
        if (sala != null) {
            sala.getJugadores().add(jugador);
            cln.agregarConexionNuevo(jugador.getIp(), sala);
            for (Jugador jug : sala.getJugadores()) {
                System.out.println(jug.getNickname());
            }
        }
    }

    @Override
    public void establecerSala(String[] sala) {
        List<Jugador> jug = new ArrayList<>();
        for (int i = 1; i < sala.length-1; i += 2) {
            jug.add(new Jugador(sala[i], "", sala[i + 1]));
        }
        this.sala = new Sala(sala[sala.length-1]);
        this.sala.setJugadores(jug);
        evtBroker.notificar("nuevasala", Procedencia.Sala);
    }

}
