/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Cliente;

import datos.ipsDTO;
import dominio.Jugador;
import dominio.Sala;
import java.io.IOException;

/**
 *
 * @author JORGE
 */
public interface ICliente {

    public void unirseSala(String codigo, Jugador jugador) throws IOException;

    public int obtenerPuerto() throws IOException;

    public void crearSala(String codigo, String nickname) throws IOException;

    public ipsDTO agregarSala(String codigo) throws IOException;

    public ipsDTO obtenerNuevaSala(String codigo) throws IOException;
    
    public void eliminarPuerto(Solicitud solicitud) throws IOException;

    public void enviarEstado(Solicitud solicitud) throws IOException;
    
    public void enviarCoordenadas(Solicitud solicitud) throws IOException;

}
