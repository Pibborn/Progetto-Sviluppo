/*
 * Copyright (C) 2014 glaxy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cryptohelper.view;

import cryptohelper.controller.SessionController;
import cryptohelper.model.AnalisiFrequenze;
import cryptohelper.model.Cifratore;
import cryptohelper.model.Mappatura;
import cryptohelper.model.Messaggio;
import cryptohelper.model.MessaggioSpia;
import cryptohelper.model.Sessione;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.CellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author glaxy
 */
public class SessioneApertaPanel extends javax.swing.JPanel {

    /**
     * Creates new form SessioneAperta
     *
     * @param s la sessione aperta
     */
    public SessioneApertaPanel(Sessione s) {
        sessione = s;
        messaggio = sessione.getMessaggio();
        initComponents();
        provaMappaturaCorrente();

        for (int i = 0; i < 26; i++) {
            JLabel label = new JLabel(alfabeto[i] + " = ");
            label.setHorizontalAlignment(JLabel.RIGHT);
            jPanel8.add(label);
            CharField charField = new CharField(alfabeto[i]);
            charField.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    CharField charField = (CharField) e.getSource();
                    Character internalChar = charField.getInternalChar();
                    String newValue = charField.getText();
                    if (newValue.equals("") && mapCorrente.map(internalChar) != null) {
                        //mapCorrente.
                    }
                    System.out.println(internalChar);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

            });
            jPanel8.add(charField);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        faiAssunzioniButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        undoButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(getFrequencyData(false), new String[] {"Carattere", "Frequenza"});
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        feedbackSessione = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);

        jTextArea2.setColumns(200);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2);

        jPanel1.add(jPanel2);

        faiAssunzioniButton.setText("Fai Assunzioni");
        faiAssunzioniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faiAssunzioniButtonActionPerformed(evt);
            }
        });

        undoButton.setText("Annulla...");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(undoButton)
                        .addGap(85, 85, 85)
                        .addComponent(faiAssunzioniButton))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faiAssunzioniButton)
                    .addComponent(undoButton))
                .addContainerGap(355, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assunzioni", jPanel3);

        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Frequenze", jPanel4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Informazioni", jPanel6);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel8.setLayout(new java.awt.GridLayout(13, 4));
        jScrollPane4.setViewportView(jPanel8);

        jPanel7.add(jScrollPane4);

        jTabbedPane1.addTab("Assunzioni Test", jPanel7);

        jPanel1.add(jTabbedPane1);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Salva Sessione");
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new java.awt.GridBagConstraints());

        jButton2.setText("Salva Soluzione");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jButton2, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        jPanel5.add(feedbackSessione, gridBagConstraints);

        add(jPanel5, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void faiAssunzioniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faiAssunzioniButtonActionPerformed
        Mappatura nuoveAssunzioni = new Mappatura(jTextField1.getText());
        jButton1.setEnabled(true);
        if (!sessController.faiAssunzione(sessione, nuoveAssunzioni)) {
            /* si potrebbe dare più autorità al session controller facendo sì che
             sessController.faiAssunzioni nel caso in cui faiAssunzioni è false, recupera e restituisce
             il commento
             */
            JFrame padre = (JFrame) SwingUtilities.getWindowAncestor(this);
            AlreadyReachedDialog ard = new AlreadyReachedDialog(padre, true, sessione.getCommento());
            if (ard.getReturnStatus() == AlreadyReachedDialog.RET_UNDO) {
                sessController.undo(sessione, sessione.getCommento());
            }
        }
        provaMappaturaCorrente();
    }//GEN-LAST:event_faiAssunzioniButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        JFrame padre = (JFrame) SwingUtilities.getWindowAncestor(this);
        UndoDialog undoDialog = new UndoDialog(padre, true);
        if (undoDialog.getReturnStatus() == UndoDialog.RET_OK) {
            sessController.undo(sessione, undoDialog.getMotivazione());
            provaMappaturaCorrente();
        }
    }//GEN-LAST:event_undoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (sessController.salvaSessione(sessione)) {
                feedbackSessione.setText("Sessione salvata");
                jButton1.setEnabled(false);
            } else {
                feedbackSessione.setText("Errore salvataggio");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(SessioneApertaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded

    }//GEN-LAST:event_jTable1AncestorAdded

    private void provaMappaturaCorrente() {
        try {
            /* temporaneamente è così */
            mapCorrente = sessione.getMappaturaCorrente();
            jTextArea1.setText(messaggio.getTestoCifrato());
            jTextArea2.setText(Cifratore.decifraMonoalfabetica(mapCorrente, messaggio.getTestoCifrato()));
            undoButton.setEnabled(!mapCorrente.isEmpty());

        } catch (SQLException ex) {
            Logger.getLogger(SessioneApertaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Object[][] getFrequencyData(boolean lingua) {
        Object[][] data = null;
        try {
            Map<Character, Double> freq = null;
            if (lingua) {
                freq = AnalisiFrequenze.getFrequency(messaggio.getLingua());
            } else {
                freq = AnalisiFrequenze.getFrequency((Messaggio) messaggio);
            }

            data = new Object[freq.size()][2];
            /* da risistemare perchè deve essere MessaggioSpia */
            int i = 0;
            for (Map.Entry<Character, Double> entry : freq.entrySet()) {
                data[i][0] = entry.getKey();
                data[i][1] = entry.getValue();
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessioneApertaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    private Sessione sessione = null;
    private MessaggioSpia messaggio = null;
    private Mappatura mapCorrente = null;
    private SessionController sessController = SessionController.getInstance();
    private final char[] alfabeto = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton faiAssunzioniButton;
    private javax.swing.JLabel feedbackSessione;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables

    private class CharField extends JTextField {

        private char character;

        public CharField(char c) {
            character = c;
            Character toWrite = mapCorrente.inverseMap(c);
            if (toWrite != null) {
                setText(toWrite + "");
            }
        }

        @Override
        public void processKeyEvent(KeyEvent ev) {
            char c = ev.getKeyChar();
            if ((ev.getKeyCode() != KeyEvent.VK_BACK_SPACE) && ((!Character.isLetter(c) && c != '-') || getDocument().getLength() > 0)) {
                ev.consume();
                return;
            }
            super.processKeyEvent(ev);
        }

        public char getInternalChar() {
            return character;
        }
    }
}
