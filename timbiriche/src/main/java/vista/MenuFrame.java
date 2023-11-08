/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import utils.JugadorDTO;
import vistaModelo.IVistaModelo;
import vistaModelo.VistaModelo;

/**
 *
 * @author JORGE
 */
public class MenuFrame extends javax.swing.JFrame {
IVistaModelo vistaModelo = new VistaModelo();
private JugadorDTO jugador;

    /**
     * Creates new form MenuFrame
     */
    public MenuFrame() {
        initComponents();
        jugador = vistaModelo.solicitarInformacionJugador();
        this.lblJugador.setText(jugador.getNickname());
        this.lblColor.setText(jugador.getColor());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        lblTimbiriche = new javax.swing.JLabel();
        btnCrearSala = new javax.swing.JButton();
        btnUnirseSala = new javax.swing.JButton();
        lblJugador = new javax.swing.JLabel();
        lblNickname = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 730));

        panelFondo.setBackground(new java.awt.Color(255, 207, 210));
        panelFondo.setPreferredSize(new java.awt.Dimension(1280, 730));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        lblTimbiriche.setFont(new java.awt.Font("Javanese Text", 0, 48)); // NOI18N
        lblTimbiriche.setForeground(new java.awt.Color(0, 0, 0));
        lblTimbiriche.setText("Timbiriche");

        btnCrearSala.setBackground(new java.awt.Color(207, 186, 240));
        btnCrearSala.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        btnCrearSala.setForeground(new java.awt.Color(0, 0, 0));
        btnCrearSala.setText("Crear Sala");

        btnUnirseSala.setBackground(new java.awt.Color(241, 192, 232));
        btnUnirseSala.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        btnUnirseSala.setForeground(new java.awt.Color(0, 0, 0));
        btnUnirseSala.setText("Unirse a Sala");

        lblJugador.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        lblJugador.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador.setText("Jugador");

        lblNickname.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N

        lblColor.setText("jLabel1");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCrearSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUnirseSala, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(lblJugador))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(lblNickname)))
                .addContainerGap(334, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(lblTimbiriche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(lblColor)
                .addGap(101, 101, 101))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimbiriche)
                    .addComponent(lblColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJugador)
                .addGap(18, 18, 18)
                .addComponent(lblNickname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(btnCrearSala, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnUnirseSala, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearSala;
    private javax.swing.JButton btnUnirseSala;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblTimbiriche;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
}
