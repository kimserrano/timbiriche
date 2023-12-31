/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dominio.Jugador;
import dominio.Sala;
import java.io.IOException;

/**
 *
 * @author Elkur
 */
public interface ISalaNegocio {

    public Sala crearSala(Jugador anfitrion) throws NegocioException;

    public void unirseSala(String codigo, String nombre) throws NegocioException;

    public Sala actualizarSala();

    public void agregarJugadores();
    
    public int obtenerPuerto() throws IOException;
    
    public void revisarNuevosJugadores();

    public void salirDeLaSala();

    public void iniciar();

    public void indicarListo(String string, String string0);

    public boolean verificarInicio(int listos, int numJug);
    
    public void asignarColores();
}
