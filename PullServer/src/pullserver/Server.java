/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pullserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class Server implements Runnable {

    private ServerSocket svSocket;
    private ServerNegocio svNegocio;

    public Server() throws IOException {
        svNegocio = new ServerNegocio();
        svSocket = new ServerSocket(9500);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket skt = svSocket.accept();
                evaluarOperacion(skt);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SalaException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void evaluarOperacion(Socket skt) throws IOException, SalaException {
        DataInputStream input = new DataInputStream(skt.getInputStream());

        String operacion = input.readUTF();
        System.out.println(operacion + " : " + skt.getInetAddress().getHostAddress());

        switch (obtenerOperacion(operacion)) {
            case "crear":
                int puerto1 = crearSala(skt, obtenerCodigo(operacion), obtenerNickname(operacion));
                enviarPuerto(skt, puerto1);
                enviarSala(skt, obtenerCodigo(operacion));

                break;

            case "unirse":
                int puerto2 = unirseSala(skt, obtenerCodigo(operacion), obtenerNickname(operacion));
                enviarPuerto(skt, puerto2);
                enviarSala(skt, obtenerCodigo(operacion));

                break;
            case "solicitarIps":
                enviarSala(skt, obtenerCodigo(operacion));
                break;

            case "eliminarPuerto":
                eliminarPuerto(obtenerCodigo(operacion), obtenerPuerto(operacion));
                break;

        }
    }

    private int crearSala(Socket skt, String codigo, String nickname) throws SalaException {
        return svNegocio.crearSala(skt, codigo, nickname);
    }

    private int unirseSala(Socket skt, String codigo, String nickname) throws SalaException {
        return svNegocio.unirseSala(skt, codigo, nickname);
    }

    private void eliminarPuerto(String codigo, String puerto) throws SalaException {
        svNegocio.eliminarPuerto(codigo, Integer.parseInt(puerto));
    }

    private void enviarSala(Socket skt, String codigo) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
        out.writeObject(svNegocio.obtenerSala(codigo));
    }

    private void enviarSala(Socket skt, String codigo, String puerto) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
        out.writeObject(svNegocio.obtenerSala(codigo, puerto));
    }

    private void enviarPuerto(Socket skt, int puerto) throws IOException {
        DataOutputStream out = new DataOutputStream(skt.getOutputStream());
        out.writeInt(puerto);
    }

    private String obtenerOperacion(String dato) {
        return dato.split(" ")[0];
    }

    private String obtenerCodigo(String dato) {
        return dato.split(" ")[1];
    }

    private String obtenerPuerto(String dato) {
        return dato.split(" ")[2];
    }

    private String obtenerNickname(String dato) {
        return dato.split(" ")[2];
    }

}
