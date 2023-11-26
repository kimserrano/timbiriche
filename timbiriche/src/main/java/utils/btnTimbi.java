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
public class btnTimbi extends JButton {

    private int corX;
    private int corY;

    public btnTimbi() {
        super();
    }

    public void setCoordenadas(int corX, int corY) {
        this.corY = corY;
        this.corX = corX;
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
        return "btnTimbi{" + "corX=" + corX + ", corY=" + corY + '}';
    }

}
