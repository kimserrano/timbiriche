/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author berly
 */
public class TimbiricheBoard extends JPanel {
  
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int CELL_SIZE = 100;
    private static final int POINT_SIZE = 10;
    ArrayList<Point> puntos = new ArrayList<>();

 public TimbiricheBoard() {
    setSize(872, 573);
    calcularPuntos(); // Llamar al método para calcular los puntos
    setVisible(true);
}
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

       for(Point punto: puntos){
            g2d.fillOval(punto.x, punto.y, POINT_SIZE, POINT_SIZE);
       }
               
         
    }

    public void calcularPuntos() {
        int width = this.getWidth();
        int height = this.getHeight();

        int separacionHor = width / ROWS;
        int separacionVer = height / COLS;

        int x = 10;
        int y = 0;
        for (int i = 0; i < this.COLS; i++) {

            for (int k = 0; k < this.ROWS; k++) {
                puntos.add(new Point(x, y));
                x += separacionHor;
            }
            y += separacionVer;
            x = 10;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimbiricheBoard());
    }
}

    
