/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package modelo;

import dominio.Jugador;
import dominio.Sala;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ISalaNegocio;
import negocio.NegocioException;
import negocio.SalaNegocio;
import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author Elkur
 */
public class ModeloSala implements IModeloSala {

    private Sala sala;
    private ISalaNegocio salaN;

    private ModeloSala() {
        salaN = new SalaNegocio();
    }

    public static ModeloSala getInstance() {
        return ModeloSalaHolder.INSTANCE;
    }

    private static class ModeloSalaHolder {

        private static final ModeloSala INSTANCE = new ModeloSala();
    }

    @Override
    public void crearSala(JugadorDTO anfitrion) {

        try {
            Jugador jug = new Jugador(anfitrion.getNickname(), anfitrion.getColor(), InetAddress.getLocalHost().getHostAddress());
            sala = salaN.crearSala(jug);
        } catch (NegocioException ex) {
            Logger.getLogger(ModeloSala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SalaDTO obtenerSala() {
        return new SalaDTO(generarListaJugadores(sala.getJugadores()), sala.getCodigo());
    }

    private List<JugadorDTO> generarListaJugadores(List<Jugador> jug) {
        if (!jug.isEmpty()) {
            JugadorDTO jugador = new JugadorDTO(jug.get(0).getNickname(), jug.get(0).getColor());
            return Arrays.asList(jugador);
        }
        return null;
    }
}
