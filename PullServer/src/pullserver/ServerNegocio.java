package pullserver;

import datos.ipsDTO;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Elkur
 */
public class ServerNegocio {

    private List<Sala> salas = new ArrayList<>();
    private int intervaloPuertosInicio = 9990;
    private int intervaloPuertosFin = 9999;

    public int crearSala(Socket skt, String codigo, String nickname) throws SalaException {
        int puerto = getPuertoDisponible();

        if (puerto == -1) {
            throw new SalaException("No hay puertos disponibles");
        }

        Conexion con = new Conexion(skt.getLocalAddress().getHostAddress().replace("/", ""), puerto, nickname);
        salas.add(new Sala(codigo, con));
        return con.getPuerto();
    }

    public int unirseSala(Socket skt, String codigo, String nickname) throws SalaException {
        int i = salas.indexOf(new Sala(codigo));
        if (i == -1) {
            throw new SalaException("No se encontro la sala");
        }

        int puerto = getPuertoDisponible();

        if (puerto != -1) {
            Conexion con = new Conexion(skt.getLocalAddress().getHostAddress().replace("/", ""), puerto, nickname);
            salas.get(i).setConexion(con);

            return puerto;
        } else {
            throw new SalaException("No hay puertos disponibles");
        }
    }

    public ipsDTO obtenerSala(String codigo) {
        Sala sala = this.salas.get(salas.indexOf(new Sala(codigo)));
        List<String> ippuertos = new ArrayList<>();

        for (Conexion con : sala.getConexiones()) {
            String ip = con.getSkt();
            String nickname = con.getNickname();
            String ippuerto = nickname + " " + ip + ":" + con.getPuerto();
            ippuertos.add(ippuerto);
        }

        return new ipsDTO(ippuertos);
    }

    public ipsDTO obtenerSala(String codigo, String puerto) {
        Sala sala = this.salas.get(salas.indexOf(new Sala(codigo)));
        List<String> ippuertos = new ArrayList<>();
        int port = Integer.parseInt(puerto);

        for (Conexion con : sala.getConexiones()) {
            if (con.getPuerto() != port) {
                String ip = con.getSkt();
                String nickname = con.getNickname();
                String ippuerto = nickname + " " + ip + ":" + con.getPuerto();
                ippuertos.add(ippuerto);
            }
        }

        return new ipsDTO(ippuertos);
    }

    private int getPuertoDisponible() {
        int puertoDisponible = -1;

        for (int puerto = intervaloPuertosInicio; puerto <= intervaloPuertosFin; puerto++) {
            boolean puertoEncontrado = false;

            for (Sala sala : salas) {
                for (Conexion con : sala.getConexiones()) {
                    if (con.getPuerto() == puerto) {
                        puertoEncontrado = true;
                        break;
                    }
                }

                if (puertoEncontrado) {
                    break;
                }
            }

            if (!puertoEncontrado) {
                puertoDisponible = puerto;
                break;
            }
        }

        return puertoDisponible;
    }

//    private int getPuertoDisponible() {
//        int puertoFaltante = -1;
//
//        for (int puerto = intervaloPuertosInicio; puerto <= intervaloPuertosFin; puerto++) {
//            boolean puertoEncontrado = false;
//            for (Sala sala : salas) {
//                for (Conexion con : sala.getConexiones()) {
//                    if (con.getPuerto() == puerto) {
//                        puertoEncontrado = true;
//                        break;
//                    }
//                }
//                if (!puertoEncontrado) {
//                    puertoFaltante = puerto;
//                    break;
//                }
//
//            }
//            if (!puertoEncontrado) {
//                puertoFaltante = puerto;
//                break;
//            }
//        }
//        return puertoFaltante;
//
//    }
}
