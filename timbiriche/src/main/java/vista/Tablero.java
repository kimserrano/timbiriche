/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import broker.Suscriptor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.BtnTimbi;
import utils.BtnTimbiTrans;
import utils.JugadorDTO;
import utils.SalaDTO;
import utils.Turno;
import utils.TurnoTrans;
import vistaModelo.IVistaModeloJugador;
import vistaModelo.IVistaModeloSala;
import vistaModelo.IVistaModeloTablero;
import vistaModelo.VistaModeloJugador;
import vistaModelo.VistaModeloTablero;

/**
 *
 * @author berly
 */
public class Tablero extends javax.swing.JFrame implements Suscriptor {

    Font customFontTitulos = new Font("Just Me Again Down Here", Font.BOLD, 50);
    Font customFontSubT = new Font("Just Me Again Down Here", Font.PLAIN, 30);

    IVistaModeloTablero vistaModeloTablero;
    IVistaModeloSala vistaModeloSala;
    IVistaModeloJugador vistaModeloJugador = new VistaModeloJugador();
    SalaDTO sala;
    TimbiricheBoard tmb;
    HashMap<String, JLabel> mapaLblsPuntos;
    // public static int turnoActual = 0;
    // public static String nickTurnoActual;
    List<JugadorDTO> jugadores;
    private Turno turno;

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        jLabelTurno.setFont(customFontTitulos);
        btnSalir.setFont(customFontTitulos);
        jLJugador1.setFont(customFontSubT);
        jLPtsJ1.setFont(customFontSubT);
        lblPts.setFont(customFontSubT);
        this.mapaLblsPuntos = new HashMap<>();
        this.jLJugador1.setVisible(false);
        this.pnlColorJ1.setVisible(false);
        this.jLPtsJ1.setVisible(false);
//      PRUEBAAA, VA EN MODELO SE SABE 
        tmb = new TimbiricheBoard();

        this.pnlTablero.add(tmb);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaModeloTablero.salir();
                System.exit(0);
            }
        });
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        vistaModeloTablero = new VistaModeloTablero();
        lblJugadorLocal.setText(vistaModeloJugador.solicitarJugador().getNickname());
        sala = vistaModeloTablero.obtenerSala();
        jugadores = sala.getJugadores();
        // nickTurnoActual = jugadores.get(turnoActual).getNickname();
        turno = TurnoTrans.TurnoTransferible;
        turno.setJugadores(jugadores);
        turno.setLblTurnoActual(jLabeTurnoNick);
        turno.setTurnoActual(0);
        turno.verificarTurno();
        jLabeTurnoNick.setText(turno.getNickTurnoActual());
        moduloJugadores();
        tmb.setColorLocal(getColorLocal());

    }

    private String getColorLocal() {
        List<JugadorDTO> jugs = this.sala.getJugadores();
        for (JugadorDTO jug : jugs) {
            if (jug.getNickname().equalsIgnoreCase(this.lblJugadorLocal.getText())) {

                return jug.getColor();

            }
        }
        return "255,255,255";
    }

    private void moduloJugadores() {
        System.out.println("ras");
        int paddingVertical = 0;
        if (sala != null) {
            if (sala.getJugadores() != null && !sala.getJugadores().isEmpty()) {
                int i = 0;
                for (JugadorDTO jugador : sala.getJugadores()) {

                    JLabel nomJugador = new JLabel(jugador.getNickname());
                    nomJugador.setBounds(this.jLJugador1.getX(), this.jLJugador1.getY() + paddingVertical, 96, 32);
                    nomJugador.setVisible(true);
                    this.pnlFondo.add(nomJugador);

                    JPanel pnlPts = new JPanel();
                    pnlPts.setBackground(generarColor(jugador.getColor()));
                    pnlPts.setBounds(this.pnlColorJ1.getX() + 30, this.pnlColorJ1.getY() + paddingVertical, 52, 26);
                    pnlPts.setVisible(true);

                    JLabel pts = new JLabel("0");
                    this.mapaLblsPuntos.put(jugador.getNickname(), pts);
                    pts.setForeground(Color.WHITE);
                    pts.setBounds(this.jLPtsJ1.getBounds());
                    pts.setVisible(true);
                    pnlPts.add(pts);

                    this.pnlFondo.add(pnlPts);
                    paddingVertical += 50;

                }
            }
        }

    }

    public Color generarColor(String color) {
        String rgb[] = color.split(",");
        return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pnlFondo = new javax.swing.JPanel();
        jLabelTurno = new javax.swing.JLabel();
        pnlColorJ1 = new javax.swing.JPanel();
        jLPtsJ1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLJugador1 = new javax.swing.JLabel();
        lblPts = new javax.swing.JLabel();
        pnlTablero = new javax.swing.JPanel();
        lblJugador = new javax.swing.JLabel();
        lblJugadorLocal = new javax.swing.JLabel();
        jugador1 = new javax.swing.JLabel();
        jLabeTurnoNick = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(255, 207, 210));

        jLabelTurno.setFont(new java.awt.Font("Trebuchet MS", 2, 36)); // NOI18N
        jLabelTurno.setText("Turno de:");

        pnlColorJ1.setBackground(new java.awt.Color(246, 255, 197));

        jLPtsJ1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLPtsJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPtsJ1.setText("0");

        javax.swing.GroupLayout pnlColorJ1Layout = new javax.swing.GroupLayout(pnlColorJ1);
        pnlColorJ1.setLayout(pnlColorJ1Layout);
        pnlColorJ1Layout.setHorizontalGroup(
            pnlColorJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPtsJ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );
        pnlColorJ1Layout.setVerticalGroup(
            pnlColorJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPtsJ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnSalir.setBackground(new java.awt.Color(207, 186, 240));
        btnSalir.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        btnSalir.setText("Salir");

        jLJugador1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLJugador1.setText("Jugador 1");

        lblPts.setText("Pts:");

        pnlTablero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 872, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        lblJugador.setBackground(new java.awt.Color(0, 0, 0));
        lblJugador.setFont(new java.awt.Font("Javanese Text", 0, 24)); // NOI18N
        lblJugador.setText("Jugador:");

        lblJugadorLocal.setBackground(new java.awt.Color(0, 0, 0));
        lblJugadorLocal.setFont(new java.awt.Font("Javanese Text", 0, 24)); // NOI18N
        lblJugadorLocal.setText("-----");

        jugador1.setBackground(new java.awt.Color(0, 0, 0));
        jugador1.setFont(new java.awt.Font("Javanese Text", 0, 24)); // NOI18N
        jugador1.setText("Jugador:");

        jLabeTurnoNick.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                    .addComponent(jLabelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(72, 72, 72))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                    .addComponent(jLabeTurnoNick, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPts, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)))
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(jLJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlColorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(lblJugadorLocal)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(596, 596, 596)
                    .addComponent(lblJugador)
                    .addContainerGap(596, Short.MAX_VALUE)))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jugador1)
                    .addContainerGap(1130, Short.MAX_VALUE)))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblJugadorLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(jLabelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPts)
                            .addComponent(jLabeTurnoNick))
                        .addGap(28, 28, 28)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLJugador1)
                            .addComponent(pnlColorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(509, Short.MAX_VALUE))))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(323, 323, 323)
                    .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(324, Short.MAX_VALUE)))
            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFondoLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jugador1)
                    .addContainerGap(643, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlFondo.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        Tablero tab = new Tablero();
        tab.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLJugador1;
    private javax.swing.JLabel jLPtsJ1;
    private javax.swing.JLabel jLabeTurnoNick;
    private javax.swing.JLabel jLabelTurno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jugador1;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblJugadorLocal;
    private javax.swing.JLabel lblPts;
    private javax.swing.JPanel pnlColorJ1;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables

//    private void verificarTurno() {
//        if (Tablero.turnoActual >= jugadores.size()) {
//            Tablero.turnoActual = 0;
//        }
//        JugadorDTO jugadorTurnoActual = jugadores.get(Tablero.turnoActual);
//        Tablero.nickTurnoActual = jugadorTurnoActual.getNickname();
//    }
    @Override
    public void update() {
        //    jLabeTurnoNick.setText(nickTurnoActual);
        BtnTimbi btnAPintar = BtnTimbiTrans.btnTransferible;
        if (btnAPintar.getColor() == null) {
            this.dispose();
            ControlVistas.cambiarFrameGanador(this, btnAPintar.getNickAutor());
            return;
        }
        if (btnAPintar.getName().equalsIgnoreCase("local")) {
            anotarPunto(this.lblJugadorLocal.getText(), tmb.getPtosAnotadosPorClick());
            return;
        }

//        if (sala.getJugadores() != null && !sala.getJugadores().isEmpty()) {
//            List<JugadorDTO> jugs = this.sala.getJugadores();
//            for (JugadorDTO jug : jugs) {
//                if (jug.getNickname().equalsIgnoreCase(btnAPintar.getNickAutor())) {
//                    btnAPintar.setColor(jug.getColor());
//                }
//            }
//        }
        turno.verificarTurno();
        if (btnAPintar.getNickAutor().equalsIgnoreCase(turno.getNickTurnoActual())) {
            if (tmb.pintarPorFuera(btnAPintar)) {
                anotarPunto(btnAPintar.getNickAutor(), tmb.getPtosAnotadosPorClick());
                //    turno.turnoLess();
            } else {
                turno.turnoAdd();
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Debes esperar tu turno",
                    "Error en movimiento",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        if (tmb.isCompleted()) {
            String ganador = reemplazarEspaciosPorComas(determinarGanador());
            this.vistaModeloTablero.notificarGanador(ganador);
            this.dispose();
            ControlVistas.cambiarFrameGanador(this, ganador);
        }
    }

    private String determinarGanador() {
        List<String> ganadores = new ArrayList<>();
        int maxPuntos = -1;

        for (Map.Entry<String, JLabel> entry : mapaLblsPuntos.entrySet()) {
            String nickname = entry.getKey();
            JLabel lbl = entry.getValue();
            int puntos = Integer.parseInt(lbl.getText());

            if (puntos > maxPuntos) {
                maxPuntos = puntos;
                ganadores.clear();  // Limpiar la lista de ganadores ya que encontramos un nuevo máximo
                ganadores.add(nickname);
            } else if (puntos == maxPuntos) {
                ganadores.add(nickname);  // Agregar al jugador a la lista de ganadores en caso de empate
            }
        }

        if (ganadores.size() == 1) {
            return "El ganador es: " + ganadores.get(0);
        } else {
            return "Empate entre: " + String.join(" y ", ganadores);
        }
    }

    private static String reemplazarEspaciosPorComas(String input) {
        return input.replace(" ", ",");
    }

    private void anotarPunto(String nickname, int numPtos) {
        JLabel lbl = this.mapaLblsPuntos.get(nickname);
        int pts = Integer.parseInt(lbl.getText());
        pts += numPtos;
        lbl.setText(String.valueOf(pts));
    }
}
