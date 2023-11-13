/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Cliente;

import dominio.Jugador;
import dominio.Sala;
import java.io.IOException;


/**
 *
 * @author JORGE
 */
public interface ICliente {
    //TO DO
    public void unirseSala(String codigo, Jugador jugador) throws IOException;
//    
//    public Sala getSala(String codigo) throws IOException;

    public void enviarNuevoJugador(String nickname, String ip) throws IOException;

    public void agregarConexionNuevo(String ip, Sala sala);
}
