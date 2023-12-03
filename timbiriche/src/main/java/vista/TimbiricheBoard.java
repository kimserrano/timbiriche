package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import utils.BtnTimbi;
import utils.JugadorDTO;
import utils.PntoTimbi;
import utils.SalaDTO;
import vistaModelo.IVistaModeloJugador;
import vistaModelo.IVistaModeloTablero;
import vistaModelo.VistaModeloJugador;
import vistaModelo.VistaModeloTablero;

public class TimbiricheBoard extends JPanel {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final int POINT_SIZE = 10;
    private String colorLocal;
    private int ptosAnotadosPorClick = 0;

    private ArrayList<Point> puntos = new ArrayList<>();
    private BtnTimbi[][] botonesV = new BtnTimbi[ROWS][COLS];
    private BtnTimbi[][] botonesH = new BtnTimbi[ROWS][COLS];
    private ArrayList<PntoTimbi> cuadrosCompletados = new ArrayList<>();
    private IVistaModeloTablero vistaModeloTablero = new VistaModeloTablero();
    SalaDTO sala = vistaModeloTablero.obtenerSala();
    IVistaModeloJugador vistaModeloJugador = new VistaModeloJugador();
    String nickJugadorLocal = vistaModeloJugador.solicitarJugador().getNickname();
    List<JugadorDTO> jugadores = sala.getJugadores();

    public TimbiricheBoard() {
        setLayout(null);
        setSize(872, 573);
        calcularPuntos();
        crearBotones();
    }

    public int getPtosAnotadosPorClick() {
        return ptosAnotadosPorClick;
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
        for (PntoTimbi cuadro : cuadrosCompletados) {
            int separacionHor = getWidth() / ROWS;
            int separacionVer = getHeight() / COLS;

            int xCuadro = puntos.get(cuadro.y * ROWS + cuadro.x).x + 4;
            int yCuadro = puntos.get(cuadro.y * ROWS + cuadro.x).y + 6;

            g2d.setColor(cuadro.getColor()); // Puedes cambiar este color
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

    public boolean pintarPorFuera(BtnTimbi boton) {
        BtnTimbi btn = buscarBoton(boton);
        this.reiniciarPtosAnotadosPorClick();

        configurarFinalBtn(btn);
        boolean retorno = false;
        if (boton.getOrientacion()) {

            if (verHAbajo(btn)) {
                this.ptosAnotadosPorClick++;

                retorno = true;
            }
            if (verHArriba(btn)) {
                this.ptosAnotadosPorClick++;

                retorno = true;
            }

        } else {
            if (verVDer(btn)) {
                this.ptosAnotadosPorClick++;

                retorno = true;
            }
            if (verVIzq(btn)) {
                this.ptosAnotadosPorClick++;

                retorno = true;
            }
        }

        return retorno;
    }

    private BtnTimbi buscarBoton(BtnTimbi boton) {
        BtnTimbi btn = new BtnTimbi();
        if (boton.getOrientacion()) {
            for (int i = 0; i < this.botonesH.length; i++) {
                for (int j = 0; j < this.botonesH[i].length; j++) {
                    // Comparar el objeto en la posición actual con el objeto buscado utilizando equals
                    if (boton.equals(this.botonesH[i][j])) {
                        btn = this.botonesH[i][j]; // Salir del método si se encuentra el objeto
                        btn.setColor(boton.getColor());
                    }
                }
            }
            return btn;
        } else {
            for (int i = 0; i < this.botonesV.length; i++) {
                for (int j = 0; j < this.botonesV[i].length; j++) {
                    // Comparar el objeto en la posición actual con el objeto buscado utilizando equals
                    if (boton.equals(this.botonesV[i][j])) {
                        btn = this.botonesV[i][j]; // Salir del método si se encuentra el objeto
                        btn.setColor(boton.getColor());
                    }
                }
            }
            return btn;
        }

    }

    private void configurarFinalBtn(BtnTimbi boton) {
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(true);
        boton.setBackground(Color.BLACK);
        boton.setEnabled(false);
        repaint();
    }

    private boolean verificarBtnHorizontal(BtnTimbi boton) {
        vistaModeloTablero.verificarMovimiento(boton);
        boolean retorno = false;
        if (verHAbajo(boton)) {
            retorno = true;
            this.ptosAnotadosPorClick++;

        }
        if (verHArriba(boton)) {
            retorno = true;
            this.ptosAnotadosPorClick++;

        }
        return retorno;
    }

    private boolean verificarBtnVertical(BtnTimbi boton) {
        vistaModeloTablero.verificarMovimiento(boton);
        boolean retorno = false;
        if (verVDer(boton)) {
            retorno = true;
            this.ptosAnotadosPorClick++;

        }
        if (verVIzq(boton)) {
            retorno = true;
            this.ptosAnotadosPorClick++;

        }
        return retorno;

    }

    private boolean verificarOrientacionBtn(BtnTimbi boton) {
        if (boton.getColor() == null) {
            boton.setColor(colorLocal);
        }
        if (boton.getOrientacion()) {
            return verificarBtnHorizontal(boton);
        } else {
            return verificarBtnVertical(boton);
        }
    }

    private void reiniciarPtosAnotadosPorClick() {
        this.ptosAnotadosPorClick = 0;
    }

    private void verificarTurno() {
        if (Tablero.turnoActual >= jugadores.size()) {
            Tablero.turnoActual = 0;
        }
        JugadorDTO jugadorTurnoActual = jugadores.get(Tablero.turnoActual);
        Tablero.nickTurnoActual = jugadorTurnoActual.getNickname();

    }

    private void activarBtn(BtnTimbi boton) {
        configurarInicioBtn(boton);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarTurno();

                if (nickJugadorLocal.equalsIgnoreCase(Tablero.nickTurnoActual)) {
                    reiniciarPtosAnotadosPorClick();
                    Tablero.turnoActual++;
                    if (verificarOrientacionBtn(boton)) {
                        vistaModeloTablero.anotarPuntoLocal();
                    }

                    configurarFinalBtn(boton);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Debes esperar tu turno",
                            "Movimiento",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }
        });
    }

//            BtnTimbi btnAPintar = BtnTimbiTrans.btnTransferible;
//        if (!btnAPintar.getNickAutor().equalsIgnoreCase(esTurno(turnoActual).getNickname())) {
//            turnoActual++;
//            return;
//        }
    private boolean verVDer(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();
        if (x != ROWS - 1 && y != COLS - 1) {
            if (!botonesV[x + 1][y].isEnabled()) {
                if (!botonesH[x][y].isEnabled()) {
                    if (!botonesH[x][y + 1].isEnabled()) {
                        colorearCuadro(x, y, boton.getColor());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verVIzq(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();
        if (x != ROWS && x != 0) {
            if (!botonesV[x - 1][y].isEnabled()) {
                if (!botonesH[x - 1][y].isEnabled()) {
                    if (!botonesH[x - 1][y + 1].isEnabled()) {
                        colorearCuadro(x - 1, y, boton.getColor());

                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verHAbajo(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (y != COLS - 1 && x != ROWS - 1) {
            if (!botonesH[x][y + 1].isEnabled()) {
                if (!botonesV[x][y].isEnabled()) {
                    if (!botonesV[x + 1][y].isEnabled()) {
                        colorearCuadro(x, y, boton.getColor());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verHArriba(BtnTimbi boton) {
        int x = boton.getCorX();
        int y = boton.getCorY();

        if (y != 0 && x != ROWS - 1) {
            if (!botonesH[x][y - 1].isEnabled()) {
                if (!botonesV[x][y - 1].isEnabled()) {
                    if (!botonesV[x + 1][y - 1].isEnabled()) {
                        colorearCuadro(x, y - 1, boton.getColor());

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Color generarColor(String color) {
        String rgb[] = color.split(",");
        return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
    }

    private void colorearCuadro(int x, int y, String color) {
        PntoTimbi pt = new PntoTimbi(x, y);
        Color clr = generarColor(color);
        pt.setColor(clr);
        cuadrosCompletados.add(pt);
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

    public void setColorLocal(String colorLocal) {
        this.colorLocal = colorLocal;
    }

    public boolean isCompleted() {
        int cuadrosTotales = (this.ROWS - 1) * (this.COLS - 1);
        if (cuadrosCompletados.size() == cuadrosTotales) {
            return true;
        }
        return false;
    }

}
