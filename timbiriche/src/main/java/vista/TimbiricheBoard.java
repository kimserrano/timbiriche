package vista;

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
import utils.BtnTimbi;
import vistaModelo.IVistaModeloTablero;
import vistaModelo.VistaModeloTablero;

public class TimbiricheBoard extends JPanel {

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int POINT_SIZE = 10;

    private ArrayList<Point> puntos = new ArrayList<>();
    private BtnTimbi[][] botonesV = new BtnTimbi[ROWS][COLS];
    private BtnTimbi[][] botonesH = new BtnTimbi[ROWS][COLS];
    private ArrayList<Point> cuadrosCompletados = new ArrayList<>();
    private IVistaModeloTablero vistaModeloTablero = new VistaModeloTablero();

    public TimbiricheBoard() {
        setLayout(null);
        setSize(872, 573);
        calcularPuntos();
        crearBotones();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja los puntos
        for (Point punto : puntos) {
            g2d.fillOval(punto.x, punto.y, POINT_SIZE, POINT_SIZE);
        }

        // Colorea los cuadros completados
        for (Point cuadro : cuadrosCompletados) {
            int separacionHor = getWidth() / ROWS;
            int separacionVer = getHeight() / COLS;

            int xCuadro = puntos.get(cuadro.y * ROWS + cuadro.x).x + 4;
            int yCuadro = puntos.get(cuadro.y * ROWS + cuadro.x).y + 6;

            g2d.setColor(Color.PINK); // Puedes cambiar este color
            g2d.fillRect(xCuadro, yCuadro, separacionHor - 1, separacionVer - 1);
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
                    BtnTimbi botonHorizontal = new BtnTimbi();
                    botonHorizontal.setOrientacion(true);
                    botonHorizontal.setCoordenadas(j, i);
                    botonesH[j][i] = botonHorizontal;
                    botonHorizontal.setBounds(punto.x + 9, punto.y + 1, separacionHor - 7, 7);
                    activarBtn(botonesH[j][i]);
                    add(botonHorizontal);
                }

                // vertical
                if (i < COLS - 1) {
                    BtnTimbi botonVertical = new BtnTimbi();
                    botonVertical.setOrientacion(false);
                    botonVertical.setCoordenadas(j, i);
                    botonesV[j][i] = botonVertical;
                    botonVertical.setBounds(punto.x + 1, punto.y + 9, 7, separacionVer - 7);
                    activarBtn(botonesV[j][i]);
                    add(botonVertical);
                }
            }
        }
    }

    private void configurarInicioBtn(BtnTimbi boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }

    private void configurarFinalBtn(BtnTimbi boton) {
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(true);
        boton.setBackground(Color.BLACK);
        boton.setEnabled(false);
        repaint();
    }

    private void verificarBtnHorizontal(BtnTimbi boton) {
        vistaModeloTablero.verificarMovimiento(boton);
        verHAbajo(boton);
        verHArriba(boton);
    }

    private void verificarBtnVertical(BtnTimbi boton) {
        vistaModeloTablero.verificarMovimiento(boton);
        verVDer(boton);
        verVIzq(boton);
    }

    private void verificarOrientacionBtn(BtnTimbi boton) {
        if (boton.getOrientacion()) {
            verificarBtnHorizontal(boton);
        } else {
            verificarBtnVertical(boton);
        }
    }

    private void activarBtn(BtnTimbi boton) {
        configurarInicioBtn(boton);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarOrientacionBtn(boton);
                configurarFinalBtn(boton);
            }
        });
    }

    private void verVDer(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (x != ROWS - 1 && y != COLS - 1) {
            if (!botonesV[x + 1][y].isEnabled()) {
                if (!botonesH[x][y].isEnabled()) {
                    if (!botonesH[x][y + 1].isEnabled()) {
                        colorearCuadro(x, y);
                    }
                }
            }
        }
    }

    private void verVIzq(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (x != ROWS && x != 0) {
            if (!botonesV[x - 1][y].isEnabled()) {
                if (!botonesH[x - 1][y].isEnabled()) {
                    if (!botonesH[x - 1][y + 1].isEnabled()) {
                        colorearCuadro(x - 1, y);
                    }
                }
            }
        }
    }

    private void verHAbajo(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (y != COLS - 1 && x != ROWS - 1) {
            if (!botonesH[x][y + 1].isEnabled()) {
                if (!botonesV[x][y].isEnabled()) {
                    if (!botonesV[x + 1][y].isEnabled()) {
                        colorearCuadro(x, y);
                    }
                }
            }
        }
    }

    private void verHArriba(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (y != 0 && x != ROWS - 1) {
            if (!botonesH[x][y - 1].isEnabled()) {
                if (!botonesV[x][y - 1].isEnabled()) {
                    if (!botonesV[x + 1][y - 1].isEnabled()) {
                        colorearCuadro(x, y - 1);
                    }
                }
            }
        }
    }

    private void colorearCuadro(int x, int y) {
        System.out.println("Cuadro completado en (" + x + ", " + y + ")");
        cuadrosCompletados.add(new Point(x, y));
        repaint();
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