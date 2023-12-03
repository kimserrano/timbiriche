/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author berly
 */
public class PntTimbi extends Point{
    
    private Color color;

    public PntTimbi() {
        super();
    }

    public PntTimbi(int x, int y, Color color) {
        super(x, y);
        this.color=color;
    }
    
    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   
}
