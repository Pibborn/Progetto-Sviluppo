/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptohelper.view;

import cryptohelper.controller.SessionController;
import cryptohelper.model.Soluzione;
import cryptohelper.model.UserInfo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Mattia Cerrato, mattia.cerrato[at]studenti.unito[dot]it
 */
public class CaricaSoluzioneDialog extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    private static UserInfo proprietario;

    /**
     * Creates new form CaricaSoluzioneDialog
     */
    public CaricaSoluzioneDialog(java.awt.Frame parent, boolean modal, UserInfo proprietario) {
        super(parent, modal);
        initComponents();
        setVisible(true);
        CaricaSoluzioneDialog.proprietario = proprietario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        caricaSoluzioneComboBox = new javax.swing.JComboBox();
        confermaCaricaButton = new javax.swing.JButton();
        annullaCaricaButton = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Seleziona una Soluzione da caricare");

        caricaSoluzioneComboBox.setModel(new javax.swing.DefaultComboBoxModel<Soluzione>());
        caricaSoluzioneComboBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                caricaSoluzioneComboBoxComponentShown(evt);
            }
        });
        caricaSoluzioneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caricaSoluzioneComboBoxActionPerformed(evt);
            }
        });
        caricaSoluzioneComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                caricaSoluzioneComboBoxAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        confermaCaricaButton.setText("Conferma");
        confermaCaricaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaCaricaButtonActionPerformed(evt);
            }
        });

        annullaCaricaButton.setText("Annulla");
        annullaCaricaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaCaricaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(confermaCaricaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(annullaCaricaButton)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(caricaSoluzioneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(caricaSoluzioneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaCaricaButton)
                    .addComponent(annullaCaricaButton))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confermaCaricaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaCaricaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confermaCaricaButtonActionPerformed

    private void annullaCaricaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaCaricaButtonActionPerformed
        doClose(RET_CANCEL, "");
    }//GEN-LAST:event_annullaCaricaButtonActionPerformed

    private void caricaSoluzioneComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_caricaSoluzioneComboBoxAncestorAdded
//        try {
//            sessionController.mostraSoluzioni(proprietario);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }//GEN-LAST:event_caricaSoluzioneComboBoxAncestorAdded

    private void caricaSoluzioneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricaSoluzioneComboBoxActionPerformed

    }//GEN-LAST:event_caricaSoluzioneComboBoxActionPerformed

    private void caricaSoluzioneComboBoxComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_caricaSoluzioneComboBoxComponentShown
        try {
            System.out.println("in dialog action");
            List<Soluzione> soluzioni = sessionController.mostraSoluzioni(proprietario);
            DefaultComboBoxModel<Soluzione> dlm = (DefaultComboBoxModel<Soluzione>) caricaSoluzioneComboBox.getModel();
            for (int i = 0; i < soluzioni.size(); i++) {
                Soluzione soluzione = soluzioni.get(i);
                dlm.addElement(soluzione);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_caricaSoluzioneComboBoxComponentShown

    private void doClose(int retStatus, String mot) {
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaricaSoluzioneDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaricaSoluzioneDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaricaSoluzioneDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaricaSoluzioneDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CaricaSoluzioneDialog dialog = new CaricaSoluzioneDialog(new javax.swing.JFrame(), true, proprietario);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    SessionController sessionController = SessionController.getInstance();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaCaricaButton;
    private javax.swing.JComboBox caricaSoluzioneComboBox;
    private javax.swing.JButton confermaCaricaButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
