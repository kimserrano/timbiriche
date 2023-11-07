/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import dominio.Jugador;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author JORGE
 */
public class Cliente implements ICliente{
    private Socket socket;
    private List<Socket> jugadores;

    @Override
    public void unirseSala(String codigo, Jugador jugador) {
        //TO DO
    }
}
