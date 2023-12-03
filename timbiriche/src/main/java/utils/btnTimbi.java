/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JButton;

/**
 *
 * @author berly
 */
public class BtnTimbi extends JButton {

    private int corX;
    private int corY;
    private boolean orientacion;
    private String nickAutor;
    private int puerto;
    private String color;

    public String getColor() {
        return color;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    

    public void setColor(String color) {
        this.color = color;
    }

    public BtnTimbi() {
        super();
    }

    public String getNickAutor() {
        return nickAutor;
    }

    public void setNickAutor(String nickAutor) {
        this.nickAutor = nickAutor;
    }

    public void setCoordenadas(int corX, int corY) {
        this.corY = corY;
        this.corX = corX;
    }

    public boolean getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(boolean orientacion) {
        this.orientacion = orientacion;
    }

    public int getCorX() {
        return corX;
    }

    public void setCorX(int corX) {
        this.corX = corX;
    }

    public int getCorY() {
        return corY;
    }

    public void setCorY(int corY) {
        this.corY = corY;
    }

    @Override
    public String toString() {
        return "BtnTimbi{" + "corX=" + corX + ", corY=" + corY + ", orientacion=" + orientacion + ", nickAutor=" + nickAutor + ", color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.corX;
        hash = 17 * hash + this.corY;
        hash = 17 * hash + (this.orientacion ? 1 : 0);
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
        final BtnTimbi other = (BtnTimbi) obj;
        if (this.corX != other.corX) {
            return false;
        }
        if (this.corY != other.corY) {
            return false;
        }
        return this.orientacion == other.orientacion;
    }

}
