/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import broker.Suscriptor;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import negocio.ISalaNegocio;
import negocio.SalaNegocio;
import utils.SalaDTO;
import vistaModelo.VistaModeloJugador;
import vistaModelo.IVistaModeloJugador;
import vistaModelo.IVistaModeloSala;
import vistaModelo.VistaModeloSala;

/**
 *
 * @author JORGE
 */
public class SalaFrame extends javax.swing.JFrame implements Suscriptor {

    IVistaModeloSala vistaModeloSala;
    IVistaModeloJugador vistaModeloJugador;

    SalaDTO sala;
    List<JLabel> nombres;

    public SalaFrame() {
        initComponents();
        nombres = Arrays.asList(lblJugador1, lblJugador2, lblJugador3, lblJugador4);
    }

    public void iniciar() {

        //pnlJugador1.setBackground(generarColor(sala.getJugadores().get(0).getColor()));
    }

    public Color generarColor(String color) {
        String rgb[] = color.split(",");
        return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
    }

    public void insertarJugadores() {
        for (int i = 0; i < sala.getJugadores().size(); i++) {
            nombres.get(i).setText(sala.getJugadores().get(i).getNickname());
        }
    }

    @Override
    public void update() {
        vistaModeloSala = new VistaModeloSala();
        vistaModeloJugador = new VistaModeloJugador();
        sala = vistaModeloSala.obtenerSala();

        if (sala != null) {
            if (!sala.getJugadores().contains(vistaModeloJugador.solicitarJugador())) {
                sala.getJugadores().add(vistaModeloJugador.solicitarJugador());
            }
            lblCodigo.setText(sala.getCodigo());
            insertarJugadores();
            setVisible(true);
            this.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblSala = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlJugador1 = new javax.swing.JPanel();
        pblJugador3 = new javax.swing.JPanel();
        pblJugador2 = new javax.swing.JPanel();
        pnlJugador4 = new javax.swing.JPanel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 207, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblSala.setBackground(new java.awt.Color(0, 0, 0));
        lblSala.setFont(new java.awt.Font("Javanese Text", 0, 48)); // NOI18N
        lblSala.setForeground(new java.awt.Color(0, 0, 0));
        lblSala.setText("Sala");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(lblSala)
                .addGap(95, 95, 95))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSala, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnIniciar.setBackground(new java.awt.Color(207, 186, 240));
        btnIniciar.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciar.setText("Iniciar");
        btnIniciar.setPreferredSize(new java.awt.Dimension(150, 25));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(163, 196, 243));

        jLabel2.setFont(new java.awt.Font("Javanese Text", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Jugadores:");

        pnlJugador1.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pblJugador3.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout pblJugador3Layout = new javax.swing.GroupLayout(pblJugador3);
        pblJugador3.setLayout(pblJugador3Layout);
        pblJugador3Layout.setHorizontalGroup(
            pblJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pblJugador3Layout.setVerticalGroup(
            pblJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pblJugador2.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout pblJugador2Layout = new javax.swing.GroupLayout(pblJugador2);
        pblJugador2.setLayout(pblJugador2Layout);
        pblJugador2Layout.setHorizontalGroup(
            pblJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pblJugador2Layout.setVerticalGroup(
            pblJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlJugador4.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pnlJugador4Layout = new javax.swing.GroupLayout(pnlJugador4);
        pnlJugador4.setLayout(pnlJugador4Layout);
        pnlJugador4Layout.setHorizontalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlJugador4Layout.setVerticalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        lblJugador1.setFont(new java.awt.Font("Javanese Text", 1, 12)); // NOI18N
        lblJugador1.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador1.setText("------");

        lblJugador2.setFont(new java.awt.Font("Javanese Text", 1, 12)); // NOI18N
        lblJugador2.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador2.setText("------");

        lblJugador4.setFont(new java.awt.Font("Javanese Text", 1, 12)); // NOI18N
        lblJugador4.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador4.setText("------");

        lblJugador3.setFont(new java.awt.Font("Javanese Text", 1, 12)); // NOI18N
        lblJugador3.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador3.setText("------");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pblJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador3))
                    .addComponent(jLabel2))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblJugador1)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblJugador2)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pblJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblJugador3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJugador4))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Javanese Text", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Código:");

        lblCodigo.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigo.setText("---   ---");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(154, 154, 154))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCodigo)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(565, 565, 565)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JLabel lblSala;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pblJugador2;
    private javax.swing.JPanel pblJugador3;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador4;
    // End of variables declaration//GEN-END:variables
}