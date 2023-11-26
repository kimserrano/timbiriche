/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author JORGE
 */
public class Jugador {

    private String nickname;
    private String color;
    private String ip;
    private int puerto;
    private boolean estado;

    public Jugador(String nickname, String color, String ip) {
        this.nickname = nickname;
        this.color = color;
        this.ip = ip;
        this.estado = false;
    }

    public Jugador(String nickname, String ip, int puerto) {
        this.nickname = nickname;
        this.ip = ip;
        this.puerto = puerto;
    }

    public Jugador(String nickname, String color) {
        this.nickname = nickname;
        this.color = color;
    }

    public Jugador(String ip) {
        this.ip = ip;
    }

    public Jugador(int puerto) {
        this.puerto = puerto;
    }

    public Jugador() {
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    

    @Override
    public String toString() {
        return "Jugador{" + "nickname=" + nickname + ", color=" + color + ", ip=" + ip + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.puerto;
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
        final Jugador other = (Jugador) obj;
        return this.puerto == other.puerto;
    }

}
