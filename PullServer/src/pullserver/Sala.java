/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pullserver;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Elkur
 */
public class Sala {

    private List<Conexion> conexiones;
    private String codigo;

    public Sala(String codigo, Conexion conexionInicial) {
        this.codigo = codigo;
        this.conexiones = new ArrayList<>();
        this.conexiones.add(conexionInicial);
    }

    public Sala(String codigo) {
        this.codigo = codigo;
    }

    public void setConexion(Conexion skt) {
        this.conexiones.add(skt);
    }

    public List<Conexion> getConexiones() {
        return conexiones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean remove(Conexion con) {
        return conexiones.remove(con);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        return this.codigo.equalsIgnoreCase(other.codigo);
    }

}
