/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dominio.Jugador;
import dominio.Sala;

/**
 *
 * @author Elkur
 */
public interface ISalaNegocio {

    public Sala crearSala(Jugador anfitrion) throws NegocioException;

    public void unirseSala(String codigo, Jugador jugador) throws NegocioException;
}
