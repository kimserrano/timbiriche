package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import utils.btnTimbi;

public class TimbiricheBoard extends JPanel {

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int POINT_SIZE = 10;

    private ArrayList<Point> puntos = new ArrayList<>();
    private btnTimbi[][] botonesV = new btnTimbi[ROWS][COLS];
    private btnTimbi[][] botonesH = new btnTimbi[ROWS][COLS];

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
                    btnTimbi botonHorizontal = new btnTimbi();
                    botonHorizontal.setCoordenadas(j, i);
                    botonesH[j][i] = botonHorizontal;
                    botonHorizontal.setBounds(punto.x + 9, punto.y + 1, separacionHor - 7, 7);
                    configurarBotonHor(botonesH[j][i]);
                    add(botonHorizontal);
                }

                // vertical
                if (i < COLS - 1) {
                    btnTimbi botonVertical = new btnTimbi();
                    botonVertical.setCoordenadas(j, i);
                    botonesV[j][i] = botonVertical;
                    botonVertical.setBounds(punto.x + 1, punto.y + 9, 7, separacionVer - 7);
                    configurarBotonVer(botonesV[j][i]);
                    add(botonVertical);
                }
            }
        }
    }

    private void configurarBotonVer(btnTimbi boton) {
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
                repaint();
                System.out.println(boton.toString());
                verVDer(boton);
                verVIzq(boton);
            }
        });
    }

    private void configurarBotonHor(btnTimbi boton) {
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
                repaint();
                System.out.println(boton.toString());
                verHAbajo(boton);
                verHArriba(boton);

            }
        });
    }

    private void verVDer(btnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (!botonesV[x + 1][y].isEnabled()) {
            if (!botonesH[x][y].isEnabled()) {
                if (!botonesH[x][y + 1].isEnabled()) {
                    System.out.println("true");
                }
            }
        }
    }

    private void verVIzq(btnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (!botonesV[x - 1][y].isEnabled()) {
            if (!botonesH[x - 1][y].isEnabled()) {
                if (!botonesH[x - 1][y + 1].isEnabled()) {
                    System.out.println("true");
                }
            }
        }
    }

    private void verHAbajo(btnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (!botonesH[x][y + 1].isEnabled()) {
            if (!botonesV[x][y].isEnabled()) {
                if (!botonesV[x + 1][y].isEnabled()) {
                    System.out.println("true");
                }
            }
        }
    }

    private void verHArriba(btnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (!botonesH[x][y - 1].isEnabled()) {
            if (!botonesV[x][y - 1].isEnabled()) {
                if (!botonesV[x + 1][y - 1].isEnabled()) {
                    System.out.println("true");
                }
            }
        }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Timbiriche Board");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TimbiricheBoard timbiricheBoard = new TimbiricheBoard();
            frame.add(timbiricheBoard);
            frame.setSize(872, 573);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
