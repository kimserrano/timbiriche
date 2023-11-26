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

    public ModeloSala() {
        salaN = SalaNegocio.getInstance();
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
        sala = salaN.actualizarSala();
        return new SalaDTO(generarListaJugadores(sala.getJugadores()), sala.getCodigo());
    }
    
    private List<JugadorDTO> generarListaJugadores(List<Jugador> jug) {
        if (!jug.isEmpty()) {
            List<JugadorDTO> jugDTO = new ArrayList<>();
            for (Jugador juga : jug) {
                System.out.println("Nombre: "+juga.getNickname() +" puerto: "+juga.getPuerto());
                jugDTO.add(new JugadorDTO(juga.getNickname(), juga.getColor()));

            }
            return jugDTO;
        }
        return null;
    }

    @Override
    public void unirseSala(String codigo, String nombre) {
        try {
            salaN.unirseSala(codigo, nombre);
        } catch (NegocioException ex) {
            Logger.getLogger(ModeloSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void salir() {
        salaN.salirDeLaSala();
    }

}
