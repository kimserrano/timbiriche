/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import dominio.Jugador;
import dominio.Sala;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class ClienteInput {

    private HiloCliente thread;

    public ClienteInput() {
    }

    public Sala unirsePartida(Set<Socket> jugadores, String codigo) throws IOException {
        thread = new HiloCliente(jugadores);
        thread.start();
        String cadenaSala = thread.getCadenaSala();
        int i = 0;
        do {
            cadenaSala = thread.getCadenaSala();
            try {
                System.out.println(i);
                i++;
                thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClienteInput.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (cadenaSala == null);

        if (!cadenaSala.isBlank()) {
            Sala sala = obtenerSala(cadenaSala, codigo);
            for (Jugador jug : sala.getJugadores()) {
                synchronized (jugadores) {
                    jugadores.add(new Socket(jug.getIp(), 9999));

                }
            }
            return sala;
        }
        return null;
    }

    public Sala obtenerSalaActualizada(String codigo) throws IOException {
        return obtenerSala(thread.getCadenaSala(), codigo);
    }

    private Sala obtenerSala(String cadena, String codigo) throws IOException {
        Sala sala = new Sala(codigo);
        sala.setJugadores(obtenerJugadores(cadena));

        return sala;
    }

    private List<Jugador> obtenerJugadores(String txt) {
        String[] split = txt.split(" ");
        List<Jugador> jugs = new ArrayList<>();
        if (split.length > 0) {
            for (int i = 0; i < (split.length / 2); i += 2) {
                Jugador jug = new Jugador();
                jug.setNickname(split[i]);
                jug.setIp(split[i + 1]);
                jugs.add(jug);
            }
        }
        return jugs;
    }
}
