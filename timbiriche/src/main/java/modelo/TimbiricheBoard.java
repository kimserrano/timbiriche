package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TimbiricheBoard extends JPanel {

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int CELL_SIZE = 100;
    private static final int POINT_SIZE = 10;
    private static final int BUTTON_SIZE = 20;

    private ArrayList<Point> puntos = new ArrayList<>();
    //private ArrayList<JButton> botones = new ArrayList<>();
    //private ArrayList<Point[]> lineas = new ArrayList<>();

    public TimbiricheBoard() {
        setLayout(null);
        setSize(872, 573);
        calcularPuntos();
        crearBotones();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Point punto : puntos) {
            g2d.fillOval(punto.x, punto.y, POINT_SIZE, POINT_SIZE);
        }
    }

 private void crearBotones() {
    int separacionHor = getWidth() / ROWS;
    int separacionVer = getHeight() / COLS;

    for (int i = 0; i < COLS; i++) {
        for (int j = 0; j < ROWS; j++) {
            Point punto = puntos.get(i * ROWS + j);

            // horizontal
            if (j < ROWS - 1) {
                JButton botonHorizontal = new JButton();
                botonHorizontal.setBounds(punto.x + 9, punto.y + 1, separacionHor - 7, 7);
                configurarBoton(botonHorizontal);
                add(botonHorizontal);
            }

            // vertical
            if (i < COLS - 1) {
                JButton botonVertical = new JButton();
                botonVertical.setBounds(punto.x + 1, punto.y + 9, 7, separacionVer - 7);
                configurarBoton(botonVertical);
                add(botonVertical);
            }
        }
    }
}

    private void configurarBoton(JButton boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton.setOpaque(true);
                boton.setContentAreaFilled(true);
                boton.setBorderPainted(true);
                boton.setBackground(Color.BLACK);
                boton.setEnabled(false);
                //boton.setForeground(Color.BLACK);
            }
        });
    }

    private void calcularPuntos() {
        int width = getWidth();
        int height = getHeight();

        int separacionHor = width / ROWS;
        int separacionVer = height / COLS;

        int x = 32;
        int y = 20;
        for (int i = 0; i < COLS; i++) {
            for (int k = 0; k < ROWS; k++) {
                puntos.add(new Point(x, y));
                x += separacionHor;
            }
            y += separacionVer;
            x = 32;
        }
    }
}
