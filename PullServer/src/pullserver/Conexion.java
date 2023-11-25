/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pullserver;

/**
 *
 * @author Elkur
 */
public class Conexion {

    private String ip;
    private int puerto;
    private String nickname;

    public Conexion(String ip, int puerto, String nickname) {
        this.ip = ip;
        this.puerto = puerto;
        this.nickname = nickname;
    }

    public Conexion(int puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSkt() {
        return ip;
    }

    public void setSkt(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.puerto;
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
        final Conexion other = (Conexion) obj;
        return this.puerto == other.puerto;
    }

}
