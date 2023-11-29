/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import java.util.List;
import utils.JugadorDTO;
import utils.BtnTimbi;

/**
 *
 * @author JORGE
 */
public interface ITableroNegocio {
    public void generarTurnos(List<JugadorDTO> jugadores);
    public void otorgarPuntos();
    public void realizarMovimiento(BtnTimbi btn);
    public void pintarMovimiento(int cordX, int cordY, boolean orientacion, String color);
}
