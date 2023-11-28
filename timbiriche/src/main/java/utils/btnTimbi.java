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

    public BtnTimbi() {
        super();
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
        return "btnTimbi{" + "corX=" + corX + ", corY=" + corY + ", orientacion=" + orientacion + '}';
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
