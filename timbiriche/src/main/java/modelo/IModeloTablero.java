/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author JORGE
 */
public interface IModeloTablero {

      public JugadorDTO[] recuperarJugadores();
      
      public SalaDTO obtenerSala();
      
      public void salir();
}
