/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaModelo;

import modelo.IModeloSala;
import modelo.ModeloSala;
import utils.JugadorDTO;
import utils.SalaDTO;

/**
 *
 * @author Elkur
 */
public class VistaModeloSala implements IVistaModeloSala {

    private IModeloSala modeloSala = new ModeloSala();

    @Override
    public void crearSala(JugadorDTO jug) {
        modeloSala.crearSala(jug);
    }

    @Override
    public SalaDTO obtenerSala() {
        return modeloSala.obtenerSala();
    }

    @Override
    public void unirseSala(String codigo, String nombre) {
        modeloSala.unirseSala(codigo, nombre);
    }

    @Override
    public void salir() {
        modeloSala.salir();
    }

    @Override
    public void iniciar() {
        modeloSala.iniciar();
    }
    
    
}
