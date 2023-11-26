/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistaModelo;

import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author Elkur
 */
public interface IVistaModeloSala {

    public void crearSala(JugadorDTO jug);

    public SalaDTO obtenerSala();
    
    public void unirseSala(String codigo, String nombre);

    public void salir();

    public void iniciar();

    public boolean verificarInicio(int listos, int numJug);
}
