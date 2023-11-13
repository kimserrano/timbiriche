/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import utils.JugadorDTO;

/**
 *
 * @author JORGE
 */
public interface IModeloJugador {
    public void procesarDatos(String nickname, String color);
    public JugadorDTO solicitarJugador();
}
