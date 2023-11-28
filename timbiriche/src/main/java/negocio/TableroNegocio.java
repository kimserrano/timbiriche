/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package negocio;

import Cliente.Cliente;
import Cliente.ICliente;
import static Cliente.OperacionesCliente.movimiento;
import Cliente.Solicitud;
import dominio.Sala;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.JugadorDTO;
import utils.BtnTimbi;
import utils.SalaDTO;
import vistaModelo.IVistaModeloSala;
import vistaModelo.VistaModeloSala;

/**
 *
 * @author JORGE
 */
public class TableroNegocio implements ITableroNegocio {

    int turnoActual = 0;
    private IVistaModeloSala vistaModeloSala = new VistaModeloSala();
    private SalaDTO sala = vistaModeloSala.obtenerSala();
    private ICliente cln;
    private JugadorNegocio jugadorNegocio;

    private TableroNegocio() {
        cln = new Cliente();
        jugadorNegocio = JugadorNegocio.getInstance();
    }

    public static TableroNegocio getInstance() {
        return TableroNegocioHolder.INSTANCE;
    }

    private static class TableroNegocioHolder {

        private static final TableroNegocio INSTANCE = new TableroNegocio();
    }

    private static <T> void shuffleTurnos(T[] array) {
        List<T> lista = Arrays.asList(array);
        Collections.shuffle(lista);
        lista.toArray(array); // Convierte la lista mezclada de nuevo a un array
    }

    private void actualizarAccionesTablero(List<JugadorDTO> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {
            boolean esTurnoJugador = (i == turnoActual);
            // Habilitar o deshabilitar la interacción según el turno
            // Puedes adaptar esto según la lógica de tu aplicación y los componentes específicos que estás utilizando
            // Por ejemplo, si estás utilizando JButton, puedes usar setEnabled
            // Ejemplo: boton.setEnabled(esTurnoJugador);
        }
    }

    @Override
    public void generarTurnos(List<JugadorDTO> jugadores) {
        System.out.println("TODAVIA NO ESTA HECHO EL GENERAR TURNOS");
    }

    @Override
    public void otorgarPuntos() {
        System.out.println("TODAVIA NO ESTA HECHO EL OTORGAR PUNTOS");
    }

    @Override
    public void realizarMovimiento(BtnTimbi btn) {
        try {
            Solicitud solicitud = new Solicitud.SolicitudBuilder()
                    .agregarDatos("codigo", sala.getCodigo())
                    .agregarDatos("puerto", jugadorNegocio.obtenerJugador().getPuerto() + "")
                    .agregarDatos("coordenadaX", String.valueOf(btn.getCorX()))
                    .agregarDatos("coordenadaY", String.valueOf(btn.getCorY()))
                    .agregarDatos("orientacion", String.valueOf(btn.getOrientacion()))
                    .agregarOperacion(movimiento)
                    .construir();
            System.out.println("llego a realizarMovimiento teblero negocio");
            cln.enviarCoordenadas(solicitud);
        } catch (IOException ex) {
            Logger.getLogger(TableroNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pintarMovimiento(int cordX, int cordY, boolean orientacion) {
        //Pintar el boton con las coordenadas
        //procesar movimiento
        System.out.println("ESTE NO ESTA HECHO");
    }

}
