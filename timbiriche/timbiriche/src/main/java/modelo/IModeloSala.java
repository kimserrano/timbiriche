/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author Elkur
 */
public interface IModeloSala {
    public void crearSala(JugadorDTO anfitrion);
    public SalaDTO obtenerSala();
    public void unirseSala(String codigo, String nombre);
}
