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
    private boolean estado;

    public Jugador(String nickname, String color, String ip) {
        this.nickname = nickname;
        this.color = color;
        this.ip = ip;
        this.estado = false;
    }

    public Jugador(String ip) {
        this.ip = ip;
    }

    public Jugador() {
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

}
