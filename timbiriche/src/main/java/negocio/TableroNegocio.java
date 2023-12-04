/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package negocio;

import Cliente.Cliente;
import Cliente.ICliente;
import static Cliente.OperacionesCliente.movimiento;
import Cliente.Solicitud;
import broker.EventBroker;
import broker.IEventBroker;
import broker.Procedencia;
import dominio.Jugador;
import dominio.Sala;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.JugadorDTO;
import utils.BtnTimbi;
import utils.BtnTimbiTrans;
import utils.SalaDTO;
import vistaModelo.IVistaModeloSala;
import vistaModelo.VistaModeloSala;

/**
 *
 * @author JORGE
 */
public class TableroNegocio implements ITableroNegocio {

    int turnoActual = 0;
    private IVistaModeloSala vistaModeloSala = new VistaModeloSala();
    private SalaDTO sala = vistaModeloSala.obtenerSala();
    private ICliente cln;
    private JugadorNegocio jugadorNegocio;
    private SalaNegocio salaNegocio = SalaNegocio.getInstance();
    private IEventBroker evtBroker;
    int cordX, cordY;
    boolean orientacion;
    String nick;

    private TableroNegocio() {
        cln = new Cliente();
        evtBroker = EventBroker.getInstance();
        jugadorNegocio = JugadorNegocio.getInstance();
    }

    public static TableroNegocio getInstance() {
        return TableroNegocioHolder.INSTANCE;
    }

    private static class TableroNegocioHolder {

        private static final TableroNegocio INSTANCE = new TableroNegocio();
    }

    private static <T> void shuffleTurnos(T[] array) {
        List<T> lista = Arrays.asList(array);
        Collections.shuffle(lista);
        lista.toArray(array); // Convierte la lista mezclada de nuevo a un array
    }

    @Override
    public void actualizarAccionesTablero(List<JugadorDTO> jugadores) {
//        BtnTimbi btn = BtnTimbiTrans.btnTransferible;
//        // for (int i = 0; i < jugadores.size(); i++) {
//        if (btn.getNickAutor().equalsIgnoreCase(esTurno(turnoActual).getNickname())) {
//            pintarMovimiento(cordX, cordY, orientacion, nick);
//            turnoActual++;
//        } else {
//            System.out.println("NO ES TU TURNOOOOOOOOO");
//            //}
//
//        }
    }

    @Override
    public void generarTurnos(List<JugadorDTO> jugadores) {
        System.out.println("TODAVIA NO ESTA HECHO EL GENERAR TURNOS");

    }

    @Override
    public void otorgarPuntos() {
        System.out.println("TODAVIA NO ESTA HECHO EL OTORGAR PUNTOS");
    }

    @Override
    public void realizarMovimiento(BtnTimbi btn) {
        try {
            Solicitud solicitud = new Solicitud.SolicitudBuilder()
                    .agregarDatos("codigo", sala.getCodigo())
                    .agregarDatos("puerto", jugadorNegocio.obtenerJugador().getPuerto() + "")
                    .agregarDatos("coordenadaX", String.valueOf(btn.getCorX()))
                    .agregarDatos("coordenadaY", String.valueOf(btn.getCorY()))
                    .agregarDatos("orientacion", String.valueOf(btn.getOrientacion()))
                    .agregarDatos("nombre", jugadorNegocio.obtenerJugador().getNickname())
                    .agregarOperacion(movimiento)
                    .construir();
            cln.enviarCoordenadas(solicitud);
//            cordX = Integer.valueOf(solicitud.obtenerDato("coordenadaX"));
//            cordY = Integer.valueOf(solicitud.obtenerDato("coordenadaY"));
//            orientacion = Boolean.valueOf(solicitud.obtenerDato("orientacion"));
//            nick = solicitud.obtenerDato("nombre");
        } catch (IOException ex) {
            Logger.getLogger(TableroNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void juegoTerminado(String ganador) {

        try {
            Solicitud solicitud = new Solicitud.SolicitudBuilder()
                    .agregarDatos("ganador", ganador)
                    .agregarDatos("puerto", jugadorNegocio.obtenerJugador().getPuerto() + "")
                    .agregarDatos("codigo", sala.getCodigo())
                    .construir();

            cln.enviarGanador(solicitud);
        } catch (IOException ex) {
            Logger.getLogger(TableroNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pintarMovimiento(int cordX, int cordY, boolean orientacion, String nick) {
        //Pintar el boton con las coordenadas
        //procesar movimiento
        BtnTimbi btnAPintar = BtnTimbiTrans.btnTransferible;
        Sala sala = this.salaNegocio.actualizarSala();
        HashMap<Integer, String> mapaColoresPorPuerto = new HashMap<>();
        List<Jugador> jugadores = sala.getJugadores();
        for (Jugador jug : jugadores) {
            mapaColoresPorPuerto.put(jug.getPuerto(), jug.getColor());
        }
        //if (btnAPintar.getNickAutor().equalsIgnoreCase(esTurno(turnoActual).getNickname())) {
        btnAPintar.setName("pintar");
        btnAPintar.setCorX(cordX);
        btnAPintar.setCorY(cordY);
        btnAPintar.setOrientacion(orientacion);
        btnAPintar.setNickAutor(nick);
        evtBroker.notificar("", Procedencia.tablero);
        // turnoActual++;
        // } else {
        // System.out.println("NO ES TU TURNOOOOOOOOO");
        //}

        // }
    }

    @Override
    public void mostrarGanador(String ganador) {
        BtnTimbi btnGanador = BtnTimbiTrans.btnTransferible;
        btnGanador.setNickAutor(ganador);
        btnGanador.setColor(null);
        evtBroker.notificar("", Procedencia.tablero);
    }

    @Override
    public void anotarPuntoLocal() {
        BtnTimbi btnParaAvisarPunto = BtnTimbiTrans.btnTransferible;
        btnParaAvisarPunto.setName("local");
        evtBroker.notificar("", Procedencia.tablero);
    }
}
