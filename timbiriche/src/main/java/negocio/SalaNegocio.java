/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Jugador;
import dominio.Sala;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author JORGE
 */
public class SalaNegocio {

    public Sala crearSala(Jugador anfitrion) throws NegocioException {
        if (anfitrion.getIp() == null) {
            throw new NegocioException();
        }
        String codigo = this.generarCodigo();
        Sala sala = new Sala(codigo);
        sala.setJugadores(Arrays.asList(anfitrion));
        return sala;
    }
    
    //TO DO con sockets
    public void unirseSala(String codigo, Jugador jugador) throws NegocioException{
        
    }

    private String generarCodigo() {
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int longitudCadena = 6;
        StringBuilder codigo = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < longitudCadena; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            char caracterAleatorio = caracteresPermitidos.charAt(indice);
            codigo.append(caracterAleatorio);
        }
        return codigo.toString();
    }
}
