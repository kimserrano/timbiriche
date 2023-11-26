/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Elkur
 */
public class Solicitud {

    private OperacionesCliente operacion;
    private Map<String, String> mapaDatos = new HashMap<>();

    public static class SolicitudBuilder {

        private Solicitud solicitud;

        public SolicitudBuilder() {
            this.solicitud = new Solicitud();
        }

        public SolicitudBuilder agregarDatos(String nombre, String dato) {
            solicitud.mapaDatos.put(nombre, dato);
            return this;
        }

        public SolicitudBuilder agregarOperacion(OperacionesCliente op) {
            solicitud.setOperacion(op);
            return this;
        }

        public Solicitud construir() {
            return solicitud;
        }
    }

    public OperacionesCliente getOperacion() {
        return operacion;
    }

    public void setOperacion(OperacionesCliente operacion) {
        this.operacion = operacion;
    }

    public String obtenerDato(String nombre) {
        return mapaDatos.get(nombre);
    }

}
