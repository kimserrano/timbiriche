/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dominio.Jugador;
import dominio.Sala;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import negocio.ISalaNegocio;
import negocio.ITableroNegocio;
import negocio.SalaNegocio;
import static negocio.SalaNegocio.getInstance;
import negocio.TableroNegocio;
import utils.JugadorDTO;
import utils.SalaDTO;
import utils.BtnTimbi;

/**
 *
 * @author eruma
 */
public class ModeloTablero implements IModeloTablero {

    Jugador[] jugadores = {new Jugador("yorch", "255,0,0"), new Jugador("kim", "62,21,177"),
        new Jugador("marki", "0,255,0"), new Jugador("elmer", "54,165,201")};

    private int turnoActual = 0;
    private Sala sala;
    private ISalaNegocio salaN;
    private ITableroNegocio tableroN;

    public ModeloTablero() {
        salaN = SalaNegocio.getInstance();
        tableroN = TableroNegocio.getInstance();
        shuffleTurnos(this.obtenerSala().getJugadores().toArray());
    }

    private static <T> void shuffleTurnos(T[] array) {
        List<T> lista = Arrays.asList(array);
        Collections.shuffle(lista);
        lista.toArray(array); // Convierte la lista mezclada de nuevo a un array
    }

    public void imprimirJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    @Override
    public JugadorDTO[] recuperarJugadores() {
        JugadorDTO[] jugadoresDTO = new JugadorDTO[this.jugadores.length];
        int i = 0;
        for (Jugador jugador : this.jugadores) {
            JugadorDTO jugadorDTO = new JugadorDTO(jugador.getNickname(), jugador.getColor());
            jugadoresDTO[i] = jugadorDTO;
            i++;
        }
        return jugadoresDTO;
    }

    @Override
    public SalaDTO obtenerSala() {
        if (!salaN.actualizarSala().getJugadores().isEmpty()) {
            salaN.asignarColores();
        }
        sala = salaN.actualizarSala();
        return new SalaDTO(generarListaJugadores(sala.getJugadores()), sala.getCodigo());
    }

    private List<JugadorDTO> generarListaJugadores(List<Jugador> jug) {
        if (!jug.isEmpty()) {
            List<JugadorDTO> jugDTO = new ArrayList<>();
            for (Jugador juga : jug) {
                JugadorDTO jugador = new JugadorDTO(juga.getNickname(), juga.getColor());
                jugador.setReady(juga.isEstado());
                jugDTO.add(jugador);

            }
            return jugDTO;
        }
        return null;
    }

    @Override
    public void salir() {
        salaN.salirDeLaSala();
    }

    @Override
    public void movimiento(BtnTimbi btn) {
        tableroN.realizarMovimiento(btn);
    }

    @Override
    public void otorgarPuntos() {
        tableroN.otorgarPuntos();
    }

    @Override
    public void generarTurnos(List<JugadorDTO> jugadores) {
        tableroN.generarTurnos(jugadores);
    }

    @Override
    public void anotarPuntoLocal() {
        tableroN.anotarPuntoLocal();
    }


}
