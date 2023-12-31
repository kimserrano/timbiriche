/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import broker.Suscriptor;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vistaModelo.IVistaModeloTablero;
import vistaModelo.VistaModeloTablero;

/**
 *
 * @author berly
 */
public class GanadorFrame extends javax.swing.JFrame  implements Suscriptor{

    IVistaModeloTablero vistaModeloTablero;
    String nombre;
    
    /**
     * Creates new form GanadorFrame
     */
    public GanadorFrame(String ganador) {
        initComponents();
        nombre=ganador;
        this.setLocationRelativeTo(this);
        setImageLabel(jLblTrofeo,"src\\main\\java\\imagenes\\trofeo.png");
        jLblNickGanadorT.setText(reemplazarComasPorEspacios(ganador));
        vistaModeloTablero = new VistaModeloTablero();
       
    }
    
    private void setImageLabel(JLabel lblNombre, String ruta){
        ImageIcon trofeo = new ImageIcon(ruta);
        Icon icon = new ImageIcon(trofeo.getImage().getScaledInstance(lblNombre.getWidth(), lblNombre.getHeight(), Image.SCALE_DEFAULT));
        lblNombre.setIcon(icon);
        this.repaint();
    }
    
    public static String reemplazarComasPorEspacios(String input) {
        return input.replace(",", " ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        pnlTablero = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLblNickGanadorT = new javax.swing.JLabel();
        jLblTrofeo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1282, 730));
        setSize(new java.awt.Dimension(1282, 730));

        pnlFondo.setBackground(new java.awt.Color(255, 207, 210));

        btnSalir.setBackground(new java.awt.Color(207, 186, 240));
        btnSalir.setFont(new java.awt.Font("Yu Gothic", 3, 12)); // NOI18N
        btnSalir.setText("Salir");

        pnlTablero.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitulo.setFont(new java.awt.Font("Trebuchet MS", 2, 36)); // NOI18N
        jLabelTitulo.setText("Fin de la partida");

        jLblNickGanadorT.setBackground(new java.awt.Color(0, 0, 0));
        jLblNickGanadorT.setFont(new java.awt.Font("Javanese Text", 0, 24)); // NOI18N
        jLblNickGanadorT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNickGanadorT.setText("El ganador es ");

        jLblTrofeo.setText("jLabel1");

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableroLayout.createSequentialGroup()
                        .addGap(0, 295, Short.MAX_VALUE)
                        .addComponent(jLabelTitulo)
                        .addGap(299, 299, 299))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableroLayout.createSequentialGroup()
                        .addComponent(jLblNickGanadorT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblTrofeo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableroLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLblTrofeo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLblNickGanadorT)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLblNickGanadorT;
    private javax.swing.JLabel jLblTrofeo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
         vistaModeloTablero.notificarGanador(reemplazarComasPorEspacios(nombre));
    }
}
