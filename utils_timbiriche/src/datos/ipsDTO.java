/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Elkur
 */
public class ipsDTO implements Serializable {

    private List<String> ippuerto;

    public ipsDTO(List<String> ippuerto) {
        this.ippuerto = ippuerto;
    }

    public List<String> getIppuerto() {
        return ippuerto;
    }

    public void setIppuerto(List<String> ippuerto) {
        this.ippuerto = ippuerto;
    }

}
